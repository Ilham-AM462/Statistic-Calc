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

public class Controller3 {
    @FXML
    private Button confirmButton3, nextButton;
    @FXML
    private TextField dtAngka;
    @FXML
    private Label angkaLabel;
    String[] kata;

    public void dataMove(int r){
        kata = new String[r];
    }
    int counter = 0;


    public void pressedConfirm() {
        String temp = dtAngka.getText();
        for (int i = 0; i < temp.length(); i++){
            if (!Character.isAlphabetic(temp.charAt(i))){
                angkaLabel.setVisible(true);
                temp = null;
                break;
            } else {
                angkaLabel.setVisible(false);
            }
        }
        if (counter < kata.length) {
            if (temp != null) {
                kata[counter] = temp;
                counter++;
            }
        }
        if (counter == kata.length){
            nextButton.setDisable(false);
            confirmButton3.setDisable(true);
        }
        dtAngka.setText(null);
    }

    public void pressedNext(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("KataStatis.fxml"));
        Parent root = loader.load();
        KataStatisController kSC = loader.getController();
        kSC.dataMove(kata);
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
