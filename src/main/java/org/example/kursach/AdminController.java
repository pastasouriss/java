package org.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.Optional;

public class AdminController {

    @FXML
    private ImageView settingsIcon;
    @FXML
    private ImageView adminImage;

    @FXML
    private void initialize() {
        String imagePath = "/org/example/kursach/settings.png"; // Путь к картинке
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath)); // Загружаем картинку
            settingsIcon.setImage(image); // Устанавливаем картинку в ImageView
        } catch (Exception e) {
            System.err.println("Не удалось загрузить изображение: " + imagePath);
            e.printStackTrace();
        }
        String adminImagePath = "/org/example/kursach/admin.png"; // Путь к картинке
        try {
            Image adminImageFile = new Image(getClass().getResourceAsStream(adminImagePath)); // Загружаем картинку
            adminImage.setImage(adminImageFile); // Устанавливаем картинку в ImageView
        } catch (Exception e) {
            System.err.println("Не удалось загрузить изображение: " + adminImagePath);
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSettingsClick(MouseEvent event) {
        // Открываем диалог подтверждения выхода
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение выхода");
        alert.setHeaderText(null);
        alert.setContentText("Вы уверены, что хотите выйти?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Переход к экрану входа
            try {
                Stage currentStage = (Stage) settingsIcon.getScene().getWindow();
                currentStage.close(); // Закрываем текущее окно

                FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
                Parent root = loader.load();
                Stage loginStage = new Stage();
                loginStage.setTitle("Главная страница");
                loginStage.setScene(new Scene(root, 700, 500));
                loginStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void handleUsersButton() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Работа с пользователями");
        alert.setHeaderText(null);
        alert.setContentText("Открыт модуль работы с пользователями.");
        alert.showAndWait();
    }

    @FXML
    private void handleProductsButton() {
        try {
            // Загружаем FXML файл нового окна
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin_products-view.fxml"));
            Parent root = loader.load();

            // Создаем новое окно
            Stage productsStage = new Stage();
            productsStage.setTitle("Работа с продукцией");
            productsStage.setScene(new Scene(root, 700, 500)); // Указываем размеры окна
            productsStage.show();

            // Закрываем текущее окно (если нужно)
            Stage currentStage = (Stage) adminImage.getScene().getWindow();
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}