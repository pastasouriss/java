package org.example.kursach;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;


public class LoginController {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView imageView;
    @FXML
    private VBox rootVBox; // Корневой контейнер сцены


    @FXML
    private void initialize() {
        Platform.runLater(() -> rootVBox.requestFocus());
        // Проверяем, есть ли изображение в указанном пути
        String imagePath = "/org/example/kursach/login.png";
        try {
            // Загружаем изображение
            Image avatar = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(avatar);
        } catch (Exception e) {
            System.err.println("Не удалось загрузить изображение: " + imagePath);
            e.printStackTrace();
        }
    }

    @FXML
    private void onSubmit(ActionEvent event) {
        String login = loginField.getText();
        String password = passwordField.getText();

        try {
            if ("admin".equals(login) && "password".equals(password)) {
                openNewWindow("first_admin-view.fxml", "Модуль администратора", event);
            } else if ("user".equals(login) && "password".equals(password)) {
                openNewWindow("user-view.fxml", "Модуль пользователя", event);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText(null);
                alert.setContentText("Неверный логин или пароль!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onBack(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Главное окно");
            stage.setScene(new Scene(root, 700, 500)); // Размер главной сцены
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void openNewWindow(String fxmlFile, String title, ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 700, 500)); // Размер окна
        stage.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
