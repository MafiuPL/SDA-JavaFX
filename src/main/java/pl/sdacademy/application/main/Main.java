package pl.sdacademy.application.main; /**
 * Created by RENT on 2017-03-14.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        zaladowanie widoku uzycie fxml - robilismy to po  ustaleniu sceny
//        odwolujemy sie do resources poprzez this
//        powolanie loader'a
//        wazny "/" przed plikiem fxml

//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/BillFromView.fxml"));

//        aplikacja formularz, zajecia 15.03

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/CompanyCreateView.fxml"));

//        root to stackPane

//        podstawowy pane w javie fx
//        stage to scena, pane to wyswietlenie

        StackPane stackPane = loader.load();

//        pan'a przylaczamy do sceny;
//        w nawiasie ponizej przy new Scene () : ctrl+p - zeby zobaczyc jakie argumenty
//        ctrl+spacja - podpowiedz

        Scene scene = new Scene(stackPane);

//        rozszerzenie klasy application i nadpisuje metode start
//        podpinamy scene pod stage

        primaryStage.setScene(scene);

//        ustawiamy tytul okna

        primaryStage.setTitle("Login");

        primaryStage.show();
    }
}
