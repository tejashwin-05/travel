package models;

public class Query {
    private int id;
    private int userId;
    private String message;
    private String status;

    public Query(int id, int userId, String message, String status) {
        this.id = id;
        this.userId = userId;
        this.message = message;
        this.status = status;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
