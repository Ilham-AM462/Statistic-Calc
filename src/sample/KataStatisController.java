package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class KataStatisController {
    @FXML
    private RadioButton median, modus;
    @FXML
    private Label label;

    Word data;
    public void dataMove(String[] kata){
        data = new Word(kata);
    }

    public void pressedNext(){
        if (!median.isSelected() || !modus.isSelected()){
            label.setText("Pilih Dulu baru klik OK!");
        }
        if (median.isSelected()){
            label.setText("Median dari data : \n" + data.median());
        } else if (modus.isSelected()){
            label.setText("Modus dari data : \n" + data.modus());
        }
    }

    public void back(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
