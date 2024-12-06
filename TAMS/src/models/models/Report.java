package models;

public class Report {
    private int id;
    private String title;
    private String content;
    private String generatedDate;

    public Report(int id, String title, String content, String generatedDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.generatedDate = generatedDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getGeneratedDate() { return generatedDate; }
    public void setGeneratedDate(String generatedDate) { this.generatedDate = generatedDate; }
}
