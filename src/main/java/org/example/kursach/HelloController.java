package org.example.kursach;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class HelloController {


    @FXML
    private void onLogin(ActionEvent event) {
        try {
            // Загрузка новой сцены
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
            Parent root = loader.load();

            // Создаем новое окно (Stage)
            Stage stage = new Stage();
            stage.setTitle("Вход");
            stage.setScene(new Scene(root, 700,500));
            stage.show();

            // (Опционально) Закрыть текущую сцену
            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void onExit() {
        System.exit(0);
    }
}
