package model;

public class Product {
    private String id;
    private String name;
    private String genre;
    private int price;
    private int amount;

    public Product() {
    }

    public Product(String id, String name, String genre, int price, int amount) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Sản phẩm: " +
                "id: " + id + "," +
                "sản phẩm: " + name + "," +
                "Loại: " + genre + "," +
                "giá: " + price + "," +
                "số lượng: " + amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
