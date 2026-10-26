package OOPproject;

public class Product {
    private String name;
    private String imageName;
    private double price;
    private String madeIn;
    private String category;

    public Product(String name, String imageName, double price, String madeIn, String category) {
        this.name = name;
        this.imageName = imageName;
        this.price = price;
        this.madeIn = madeIn;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public void setMadeIn(String madeIn) {
        this.madeIn = madeIn;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                ", price=" + price +
                ", madeIn='" + madeIn + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
