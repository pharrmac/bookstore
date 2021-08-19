
package business;

import business.book.BookDao;
import business.book.BookDaoJdbc;
import business.category.CategoryDao;
import business.category.CategoryDaoJdbc;
import business.customer.CustomerDaoJdbc;
import business.order.*;
import business.customer.CustomerDao;
import business.order.LineItem;
import business.order.LineItemDao;
import business.order.LineItemDaoJdbc;
import business.order.Order;
import business.order.OrderDao;
import business.order.OrderDaoJdbc;
import business.order.OrderService;
import business.order.DefaultOrderService;
import business.BookstoreDbException;
import business.JdbcUtils;
import business.book.Book;
import business.book.BookDao;
import business.cart.ShoppingCart;
import business.cart.ShoppingCartItem;
import business.customer.CustomerForm;
import business.customer.Customer;


public class ApplicationContext {

    private CategoryDao categoryDao;
    private BookDao bookDao;
    private OrderService orderService;
    private OrderDao orderDao;
    private LineItemDao lineItemDao;
    private CustomerDao customerDao;

    public static ApplicationContext INSTANCE = new ApplicationContext();

    private ApplicationContext() {
        categoryDao = new CategoryDaoJdbc();
        bookDao = new BookDaoJdbc();
        orderDao = new OrderDaoJdbc();
        lineItemDao = new LineItemDaoJdbc();
        customerDao = new CustomerDaoJdbc();
        orderService = new DefaultOrderService();
        ((DefaultOrderService)orderService).setBookDao(bookDao);
        ((DefaultOrderService)orderService).setBookDao(bookDao);
        ((DefaultOrderService)orderService).setOrderDao(orderDao);
        ((DefaultOrderService)orderService).setLineItemDao(lineItemDao);
        ((DefaultOrderService)orderService).setCustomerDao(customerDao);

    }

    public CategoryDao getCategoryDao() {
        return categoryDao;
    }
    public BookDao getBookDao() { return bookDao; }
    public OrderService getOrderService() { return orderService; }
    public OrderDao getOrderDao() { return orderDao; }
    public LineItemDao getLineItemDao() { return lineItemDao; }
    public CustomerDao getCustomerDao() { return customerDao; }

    public void setBookDao(BookDao bookDao) { this.bookDao = bookDao; }
    public void setOrderDao(OrderDao orderDao) { this.orderDao = orderDao; }
    public void setLineItemDao(LineItemDao lineItemDao) { this.lineItemDao = lineItemDao; }
    public void setCustomerDao(CustomerDao customerDao) { this.customerDao = customerDao; }

}
