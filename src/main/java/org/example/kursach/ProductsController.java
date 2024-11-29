package org.example.kursach;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;

public class ProductsController {

    @FXML
    private ImageView settingsIcon;

    @FXML
    private void initialize() {
        String imagePath = "/org/example/kursach/settings.png"; // Путь к картинке
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath)); // Загружаем картинку
            settingsIcon.setImage(image); // Устанавливаем картинку в ImageView
        } catch (Exception e) {
            System.err.println("Не удалось загрузить изображение: " + imagePath);
            e.printStackTrace();
        }}

    @FXML
    private void handleEditMode() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("add_user-view.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Режим редактирования");
            stage.setScene(new Scene(root, 700, 500)); // Устанавливаем размеры нового окна
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void handleViewMode() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Режим просмотра");
        alert.setHeaderText(null);
        alert.setContentText("Вы находитесь в режиме просмотра.");
        alert.showAndWait();
    }

    @FXML
    private void handleSettingsClick(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Подтверждение выхода");
        alert.setHeaderText(null);
        alert.setContentText("Вы уверены, что хотите выйти?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Закрываем текущее окно и возвращаемся на главный экран
            try {
                javafx.stage.Stage currentStage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                currentStage.close();

                javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("hello-view.fxml"));
                javafx.scene.Parent root = loader.load();
                javafx.stage.Stage loginStage = new javafx.stage.Stage();
                loginStage.setTitle("Главная страница");
                loginStage.setScene(new javafx.scene.Scene(root, 700, 500));
                loginStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @FXML
    private void handleReturnToMain() {
        try {
            // Загружаем FXML файл для admin-view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("first_admin-view.fxml"));
            Parent root = loader.load();

            // Создаем новое окно для admin-view
            Stage mainStage = new Stage();
            mainStage.setTitle("Администратор");
            mainStage.setScene(new Scene(root, 700, 500));
            mainStage.show();

            // Получаем текущее окно и закрываем его
            Stage currentStage = (Stage) settingsIcon.getScene().getWindow(); // Здесь работаем с тем же элементом, что и раньше
            currentStage.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}