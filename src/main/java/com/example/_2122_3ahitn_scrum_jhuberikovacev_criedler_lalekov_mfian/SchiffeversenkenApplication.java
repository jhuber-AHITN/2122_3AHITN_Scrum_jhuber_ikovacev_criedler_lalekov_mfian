package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spieler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchiffeversenkenApplication extends Stage {

    Stage stage;
    public SchiffeversenkenApplication(Spiel spiel) throws IOException {
        stage = this;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/_2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian/Schiffeversenken.fxml"));

        Parent root = (Parent)fxmlLoader.load();


        Scene scene = new Scene(root);

        SchiffeversenkenController controller = fxmlLoader.<SchiffeversenkenController>getController();
        controller.setSp(spiel);

        stage.setScene(scene);
        stage.show();
    }
}
