package models;

public class Package {
    private int id;
    private String name;
    private String category;
    private double price;
    private int availability;

    public Package(int id, String name, String category, double price, int availability) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.availability = availability;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getAvailability() { return availability; }
    public void setAvailability(int availability) { this.availability = availability; }
}
