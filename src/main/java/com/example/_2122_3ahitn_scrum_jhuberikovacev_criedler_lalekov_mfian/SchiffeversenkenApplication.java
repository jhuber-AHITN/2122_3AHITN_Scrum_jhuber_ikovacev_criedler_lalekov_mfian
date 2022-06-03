package com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian;

import com.example._2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian.model.Spiel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SchiffeversenkenApplication extends Stage {

    Stage stage;
    public SchiffeversenkenApplication(Spiel sp) throws IOException {
        stage = this;
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/_2122_3ahitn_scrum_jhuberikovacev_criedler_lalekov_mfian/Schiffeversenken.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
