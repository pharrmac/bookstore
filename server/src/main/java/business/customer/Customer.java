package business.customer;

import java.util.Date;

public class Customer {

    private long customerId;
    private String customerName;
    private String address;
    private String phone;
    private String phoneForDisplay;
    private String email;
    private String ccNumber;
    private String ccNumberForDisplay;
    private Date ccExpDate;

    public Customer(long customerId, String customerName, String address, String phone, String email, String ccNumber, Date ccExpDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.ccNumber = ccNumber;
        this.ccExpDate = ccExpDate;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getAddress() { return address; }

    public String getPhone() { return phone; }

    public String getPhoneForDisplay() {
        phoneForDisplay = getPhone().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
        return phoneForDisplay;
    }

    public String getEmail() { return email; }

    public String getCcNumber() { return ccNumber; }

    public String getCcNumberForDisplay() {
       // **** **** **** 1111
        ccNumberForDisplay = getCcNumber().replaceAll(".(?=.{4})", "*");
        return ccNumberForDisplay;
    }

    public Date getCcExpDate() { return ccExpDate; }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", ccNumber='" + ccNumber + '\'' +
                ", ccExpDate=" + ccExpDate +
                '}';
    }
}
