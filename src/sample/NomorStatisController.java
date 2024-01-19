package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;


public class NomorStatisController {
    @FXML
    RadioButton rMean, rModus, rMedian;
    @FXML
    Button nextButton;
    @FXML
    Label label;
    Nomor data;
    public void dataMove(int[] angka){
        data = new Nomor(angka);
    }

    public void pressedNext(){
        if (!rMedian.isSelected() || !rModus.isSelected() || !rMean.isSelected()){
            label.setText("Pilih Dulu baru klik OK!");
        }
        if (rMedian.isSelected()){
            label.setText("Median dari data : \n" + data.median());
        } else if (rModus.isSelected()){
            label.setText("Modus dari data : \n" + data.modus());
        }else if (rMean.isSelected()){
            label.setText("Mean dari data : \n" + data.mean());
        }
    }

    public void back(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
