package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private RadioButton rButtonS, rButtonN;
    @FXML
    private Button nextButton3, confirmButton;
    @FXML
    private TextField txtInput;
    @FXML
    private Label isNumeric, typeData;
    public String banyakData;
    int counter = 0;


    public void pressedNext(ActionEvent event) throws IOException {
        if (rButtonN.isSelected()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu2.fxml"));
            Parent root = loader.load();
            Controller2 controller2 = loader.getController();
            controller2.dataMove(Integer.parseInt(txtInput.getText()));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        if (rButtonS.isSelected()){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menu3.fxml"));
            Parent root = loader.load();
            Controller3 controller3 = loader.getController();
            controller3.dataMove(Integer.parseInt(txtInput.getText()));
            Scene scene = new Scene(root);
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    public void pressedConfirm() {
        counter++;
        banyakData = txtInput.getText();
        for (int i = 0; i < banyakData.length(); i++){
            if (!Character.isDigit(banyakData.charAt(i))){
                isNumeric.setVisible(true);
                banyakData = null;
                break;
            }
            else if (Character.isDigit(banyakData.charAt(i))){
                isNumeric.setVisible(false);
                if (counter%2 == 0){
                    txtInput.setDisable(false);
                    confirmButton.setText("Confirm");
                    rButtonS.setDisable(true);
                    rButtonN.setDisable(true);
                    rButtonS.setVisible(false);
                    rButtonN.setVisible(false);
                    nextButton3.setVisible(false);
                    nextButton3.setDisable(true);
                    typeData.setVisible(false);
                }
                if (counter%2 != 0){
                    txtInput.setDisable(true);
                    confirmButton.setText("Cancel");
                    rButtonS.setDisable(false);
                    rButtonN.setDisable(false);
                    rButtonS.setVisible(true);
                    rButtonN.setVisible(true);
                    nextButton3.setVisible(true);
                    nextButton3.setDisable(false);
                    typeData.setVisible(true);
                }
            }
        }
    }

    public void pressedAbout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("About.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
