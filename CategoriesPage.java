package OOPproject;

import OOPproject.Category;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesPage {

    private Stage stage;
    private String username;
    private List<Category> categories = new ArrayList<>();

    public CategoriesPage(Stage stage, String username,List<Category> categories ) {
        this.stage = stage;
        this.username = username;
       this.categories=categories;
    }

    public void show() {
        // Create main container
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Top section with welcome message and logout button
        HBox topBar = new HBox();
        topBar.setSpacing(10);
        topBar.setPadding(new Insets(10));
        topBar.setStyle("-fx-background-color: #3498db;");

        Label welcomeLabel = new Label("Welcome, " + username + "!");
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        welcomeLabel.setTextFill(Color.WHITE);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button cartButton = new Button("Cart (0)");
        cartButton.setStyle("-fx-background-color: #e74c3c; -fx-text-fill: white;");

        Button logoutButton = new Button("Logout");
//        logoutButton.setOnAction(e -> logout());

        topBar.getChildren().addAll(welcomeLabel, spacer, cartButton, logoutButton);

        // Center section with categories grid
        GridPane categoryGrid = new GridPane();
        categoryGrid.setHgap(20);
        categoryGrid.setVgap(20);
        categoryGrid.setAlignment(Pos.CENTER);
        categoryGrid.setPadding(new Insets(20));

        // Add categories to the grid
        int col = 0;
        int row = 0;
        for (Category category : categories) {
            VBox categoryBox = createCategoryBox(category);

            categoryGrid.add(categoryBox, col, row);

            col++;
            if (col > 2) {  // 3 columns
                col = 0;
                row++;
            }
        }

        // Developer info at bottom
        HBox bottomBar = new HBox();
        bottomBar.setAlignment(Pos.CENTER_RIGHT);
        bottomBar.setPadding(new Insets(10));

        Button devInfoButton = new Button("Developer Info");
        devInfoButton.setOnAction(e -> showDevInfo());

        bottomBar.getChildren().add(devInfoButton);

        // Add all sections to the root layout
        root.setTop(topBar);
        root.setCenter(categoryGrid);
        root.setBottom(bottomBar);

        // Create and set the scene
        Scene scene = new Scene(root, 800, 600);
        stage.setTitle("Online Shopping - Categories");
        stage.setScene(scene);
        stage.show();
    }

    private VBox createCategoryBox(Category category) {
        VBox box = new VBox();
        box.setAlignment(Pos.CENTER);
        box.setPadding(new Insets(10));
        box.setSpacing(10);
        box.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-background-color: white;");
        box.setPrefWidth(200);
        box.setPrefHeight(220);

        // Image view for the category
        ImageView imageView = new ImageView();
        try {
            File file = new File("images/" + category.getImageName());
            if (file.exists()) {
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);
                imageView.setFitWidth(180);
                imageView.setFitHeight(150);
                imageView.setPreserveRatio(true);
            } else {
                Label noImage = new Label("No Image");
                noImage.setPrefWidth(180);
                noImage.setPrefHeight(150);
                noImage.setAlignment(Pos.CENTER);
                noImage.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #ddd;");
                box.getChildren().add(noImage);
            }
        } catch (Exception e) {
            Label noImage = new Label("No Image");
            noImage.setPrefWidth(180);
            noImage.setPrefHeight(150);
            noImage.setAlignment(Pos.CENTER);
            noImage.setStyle("-fx-background-color: #f8f8f8; -fx-border-color: #ddd;");
            box.getChildren().add(noImage);
        }

        // Label for category name
        Label nameLabel = new Label(category.getName());
        nameLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        if (imageView.getImage() != null) {
            box.getChildren().addAll(imageView, nameLabel);
        } else {
            box.getChildren().add(nameLabel);
        }

        // Make the box clickable
        box.setOnMouseClicked(e -> openCategoryProducts(category));

        // Add hover effect
        box.setOnMouseEntered(e -> {
            box.setStyle("-fx-border-color: #3498db; -fx-border-radius: 5; -fx-background-color: #f8f8f8;");
            box.setCursor(javafx.scene.Cursor.HAND);
        });

        box.setOnMouseExited(e -> {
            box.setStyle("-fx-border-color: #ddd; -fx-border-radius: 5; -fx-background-color: white;");
        });

        return box;
    }

    private void loadCategories() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Categories.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    String name = parts[0];
                    String imageName = parts[1];
                    categories.add(new Category(name, imageName));
                }
            }
        } catch (IOException e) {
            showAlert("Error", "Could not load categories from file");
            e.printStackTrace();
        }
    }

    private void openCategoryProducts(Category category) {
        // This method would open the products page for the selected category
        // We'll implement this in the next step
        showAlert("Category Selected", "You selected: " + category.getName());

        // Here you would navigate to the products page
        // ProductsPage productsPage = new ProductsPage(stage, username, category);
        // productsPage.show();
    }

//    private void logout() {
//        // Go back to login page
//        LoginPage loginPage = new LoginPage(stage);
//        loginPage.show();
//    }

    private void showDevInfo() {
        // Show a dialog with developer information
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Developer Information");
        alert.setHeaderText("Online Shopping Application");
        alert.setContentText("Developed by: Your Name\nEmail: your.email@example.com\n\nSWER142 Course Project - Bethlehem University");
        alert.showAndWait();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}