package models;

public class Feedback {
    private int id;
    private int userId;
    private String comments;
    private int rating;

    public Feedback(int id, int userId, String comments, int rating) {
        this.id = id;
        this.userId = userId;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
