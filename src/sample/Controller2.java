package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller2 {
    @FXML
    private Button confirmButton2, nextButton;
    @FXML
    private TextField dtAngka;
    @FXML
    private Label angkaLabel;
    int[] angka;
    public void dataMove(int r){
        angka = new int[r];
    }
    int counter = 0;


    public void pressedConfirm() {
        String temp = dtAngka.getText();
        for (int i = 0; i < temp.length(); i++){
            if (!Character.isDigit(temp.charAt(i))){
                angkaLabel.setVisible(true);
                temp = null;
                break;
            } else {
                angkaLabel.setVisible(false);
            }
        }
        if (counter < angka.length) {
            if (temp != null) {
                angka[counter] = Integer.parseInt(temp);
                counter++;
            }
        }
        if (counter == angka.length){
            nextButton.setDisable(false);
            confirmButton2.setDisable(true);
        }
    }

    public void pressedNext(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NomorStatis.fxml"));
        Parent root = loader.load();
        NomorStatisController nSC = loader.getController();
        nSC.dataMove(angka);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
