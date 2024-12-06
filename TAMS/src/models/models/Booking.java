package models;

public class Booking {
    private int id;
    private int userId;
    private int packageId;
    private String bookingDate;
    private String paymentStatus;

    public Booking(int id, int userId, int packageId, String bookingDate, String paymentStatus) {
        this.id = id;
        this.userId = userId;
        this.packageId = packageId;
        this.bookingDate = bookingDate;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public int getPackageId() { return packageId; }
    public void setPackageId(int packageId) { this.packageId = packageId; }

    public String getBookingDate() { return bookingDate; }
    public void setBookingDate(String bookingDate) { this.bookingDate = bookingDate; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
