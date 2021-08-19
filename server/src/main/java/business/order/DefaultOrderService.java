package business.order;

import api.ApiException;
import business.BookstoreDbException;
import business.JdbcUtils;
import business.book.Book;
import business.book.BookDao;
import business.cart.ShoppingCart;
import business.cart.ShoppingCartItem;
import business.customer.CustomerForm;
import business.customer.CustomerDao;
import business.customer.Customer;
import business.order.LineItem;
import business.order.LineItemDao;
import business.order.Order;
import business.order.OrderDao;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;
import java.util.stream.Collectors;

public class DefaultOrderService implements OrderService {

	private BookDao bookDao;
	private OrderDao orderDao;
	private LineItemDao lineItemDao;
	private CustomerDao customerDao;

	public BookDao getBookDao() { return bookDao; }
	public OrderDao getOrderDao() { return orderDao; }
	public LineItemDao getLineItemDao() { return lineItemDao; }
	public CustomerDao getCustomerDao() { return customerDao; }

	public void setBookDao(BookDao bookDao) { this.bookDao = bookDao; }
	public void setOrderDao(OrderDao orderDao) { this.orderDao = orderDao; }
	public void setLineItemDao(LineItemDao lineItemDao) { this.lineItemDao = lineItemDao; }
	public void setCustomerDao(CustomerDao customerDao) { this.customerDao = customerDao; }


	@Override
	public OrderDetails getOrderDetails(long orderId) {
		Order order = orderDao.findByOrderId(orderId);
		Customer customer = customerDao.findByCustomerId(order.getCustomerId());
		List<LineItem> lineItems = lineItemDao.findByOrderId(orderId);
		List<Book> books = lineItems
				.stream()
				.map(lineItem -> bookDao.findByBookId(lineItem.getBookId()))
				.collect(Collectors.toList());
		return new OrderDetails(order,
				customer,
				lineItems,
				books);
	}

	private Date getDate(String monthString, String yearString) {
		Calendar calndr1 = (Calendar)Calendar.getInstance();
		calndr1.set(Calendar.MONTH, Integer.parseInt(monthString) - 1);
		calndr1.set(Calendar.YEAR, Integer.parseInt(yearString));
		Date dt = calndr1.getTime();
		return dt;
	}

	private int generateConfirmationNumber() {
		Random r = new Random();
		return r.nextInt(999999999);
	}


	private long performPlaceOrderTransaction(
			String name, String address, String phone,
			String email, String ccNumber, Date date,
			ShoppingCart cart, Connection connection) {
		try {
			connection.setAutoCommit(false);
			long customerId = customerDao.create(
					connection,
					name,
					address,
					phone,
					email,
					ccNumber,
					date);

			long customerOrderId = orderDao.create(
					connection,
					cart.getComputedSubtotal() + cart.getSurcharge(),
					generateConfirmationNumber(),
					customerId);


			for (ShoppingCartItem item : cart.getItems()) {
				lineItemDao.create(connection, customerOrderId,
						item.getBookId(), item.getQuantity());
			}
			connection.commit();
			return customerOrderId;
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				throw new BookstoreDbException("Failed to roll back transaction", e1);
			}
			return 0;
		}
	}

	@Override
    public long placeOrder(CustomerForm customerForm, ShoppingCart cart) {

		validateCustomer(customerForm);
		validateCart(cart);

		try (Connection connection = JdbcUtils.getConnection()) {
			Date date = getDate(
					customerForm.getCcExpiryMonth(),
					customerForm.getCcExpiryYear());
			return performPlaceOrderTransaction(
					customerForm.getName(),
					customerForm.getAddress(),
					customerForm.getPhone(),
					customerForm.getEmail(),
					customerForm.getCcNumber(),
					date,
					cart,
					connection);

		} catch (SQLException e) {
			throw new BookstoreDbException("Error during close connection for customer order", e);
		}
	}



	private void validateCustomer(CustomerForm customerForm) {

    	String name = customerForm.getName();
		String address = customerForm.getAddress();

		String email = customerForm.getEmail();
		String ccnumber = customerForm.getCcNumber().trim().replaceAll("[\\s-()]", "");

		if (name == null || name.equals("") || name.length() > 45 || name.length() < 4) {
			throw new ApiException.InvalidParameter("Invalid name field");
		}
		if (address == null || address.equals("") || address.length() > 45 || address.length() < 4) {
			throw new ApiException.InvalidParameter("Invalid address field");
		}
		String phone = customerForm.getPhone();
		if (phone == null || phone.equals("")) {
			throw new ApiException.InvalidParameter("Invalid phone field");
		}
		phone = phone.trim().replaceAll("[\\s-\\(\\)()]", "");
		if ( phone.length() != 10) {
			throw new ApiException.InvalidParameter("Invalid phone field");
		}
		if (email == null || email.equals("") || !email.contains("@") || email.substring(email.length() - 1).equals(".") || email.substring(email.length() - 1).equals("@") ) {
			throw new ApiException.InvalidParameter("Invalid email field");
		}
		if (ccnumber == null || ccnumber.equals("") || ccnumber.length() < 14 || ccnumber.length() > 16 ) {
			throw new ApiException.InvalidParameter("Invalid ccnumber field");
		}
		if (expiryDateIsInvalid(customerForm.getCcExpiryMonth(), customerForm.getCcExpiryYear())) {
			throw new ApiException.InvalidParameter("Invalid expiry date");

		}
	}

	private boolean expiryDateIsInvalid(String ccExpiryMonth, String ccExpiryYear) {
		// HINT: Use Integer.parseInt and the YearMonth class
		if (ccExpiryMonth == "" || ccExpiryMonth == null || ccExpiryYear == "" || ccExpiryYear == null) return true;
		var cleanMonth = Integer.parseInt(ccExpiryMonth);
		boolean isInRange = Math.min(1,12) <= cleanMonth && Math.max(1,12) >= cleanMonth;
		if ( !isInRange )return true;
		YearMonth expDate = YearMonth.of(Integer.parseInt(ccExpiryYear), cleanMonth);
		YearMonth todaysDate = YearMonth.now();
		return (todaysDate.isAfter(expDate));
	}

	private void validateCart(ShoppingCart cart) {

		if (cart.getItems().size() <= 0) {
			throw new ApiException.InvalidParameter("Cart is empty.");
		}

		cart.getItems().forEach(item-> {
			if (item.getQuantity() <= 0 || item.getQuantity() > 99) {
				throw new ApiException.InvalidParameter("Invalid quantity");
			}
			Book databaseBook = bookDao.findByBookId(item.getBookId());
			if (item.getPrice() != databaseBook.getPrice()) {
				throw new ApiException.InvalidParameter("Invalid price");
			}
			if (item.getCategoryId() != databaseBook.getCategoryId()) {
				throw new ApiException.InvalidParameter("Invalid category");
			}

		});
	}

}
