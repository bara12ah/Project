package OOPproject;

public class Category {
    private String name;
    private String ImageName;

    public Category(String name,String imageName ) {
        this.ImageName = imageName;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", ImageName='" + ImageName + '\'' +
                '}';
    }
}
