package OOPproject;// TestCategoriesView.java
import javafx.application.Application;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;


public class OnlineShopping extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create some sample categories for testing
        List<Category> sampleCategories = new ArrayList<>();
        sampleCategories.add(new Category("Shoes", "shoes.jpeg"));
        sampleCategories.add(new Category("Electronics", "electronics.jpeg"));
        sampleCategories.add(new Category("Clothing", "clothing.jpeg"));
        sampleCategories.add(new Category("Books", "books.jpeg"));
        sampleCategories.add(new Category("Miscellaneous", "miscellaneous.jpeg"));

        // Create and show the categories page with sample data
        CategoriesPage categoryPage = new CategoriesPage(primaryStage, "TestUser",sampleCategories);

        GridPane pane = new GridPane();
    }

    public static void main(String[] args) {
        launch(args);
}
}