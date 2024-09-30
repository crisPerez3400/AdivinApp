package dad.AdivinApp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import javafx.stage.Stage;

public class Interfaz extends Application {

    private TextField numeroText;
    private int numeroAdivinar;
    private boolean numeroAdivinado;

    @Override
    public void start(Stage stage) throws Exception{

        Label labelNumero = new Label("Introducir numero: ");
        numeroText = new TextField();
        numeroText.setPromptText("Introducir numero: ");

        Button comprobarButton = new Button();
        comprobarButton.setText("Comprobar");
        comprobarButton.setOnAction(event -> comprobarButton() );
        comprobarButton.setDefaultButton(true);

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.setFillWidth(false);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(labelNumero, numeroText, comprobarButton);

        Scene scene = new Scene(root, 320, 240);


        stage.setTitle("Adivinapp");
     //   stage.setScene(scene);
        stage.setScene(scene);
        stage.show();
        generarNuevoNumero();

    }
 //metodos
    private void comprobarButton() {

        if (numeroAdivinado) {
            numeroAdivinado = false;
            generarNuevoNumero();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("Ya has ganado");
            alert.setContentText("Se reinicia el juego");
            alert.showAndWait();

            return;
        }

        Numero n = new Numero();
        n.setNumero(Integer.parseInt(numeroText.getText()));

        if (n.getNumero() > 100 || n.getNumero() < 0) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("numero invalido");
            alert.setContentText("Numero invalido");
            alert.showAndWait();
        } else {
            System.out.println(numeroAdivinar);
            if (n.getNumero() == numeroAdivinar) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText("Has ganado");
                alert.setContentText("Has ganado");

                alert.showAndWait();
                numeroAdivinado = true;
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Has perdido");
                alert.setContentText("Ooops");

                alert.showAndWait();
            }
        }



    }
    private void generarNuevoNumero() {
        Numero n = new Numero();
        numeroAdivinar = n.generarNumeroAleatorio();
        System.out.println("Número a adivinar: " + numeroAdivinar);
    }
}
