package org.example.kursach;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditingController {

    @FXML
    private TextField nameField;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField quantityField;

    // Обработка нажатия на "Добавить"
    @FXML
    private void handleAdd() {
        String name = nameField.getText();
        String manufacturer = manufacturerField.getText();
        String priceText = priceField.getText();
        String quantityText = quantityField.getText();

        try {
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);

            if (name.isEmpty() || manufacturer.isEmpty()) {
                throw new IllegalArgumentException("Все поля должны быть заполнены.");
            }

            // Здесь можно добавить логику сохранения товара

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Успех");
            alert.setContentText("Товар успешно добавлен!");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            showError("Стоимость и количество должны быть числовыми.");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    // Обработка нажатия на "Назад"
    @FXML
    private void handleBack() {
        Stage stage = (Stage) nameField.getScene().getWindow();
        stage.close(); // Закрываем текущее окно
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
