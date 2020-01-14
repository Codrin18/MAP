package sample;

import Domain.Equation;
import Domain.FirstDegreeEquation;
import Domain.SecondDegreeEquation;
import Repository.Repository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Repository repo = new Repository();
        ArrayList<Double> coeff = new ArrayList<>();
        ArrayList<Double> coeff1 = new ArrayList<>();
        ArrayList<Double> coeff2 = new ArrayList<>();
        coeff.add(3.0);
        coeff.add(2.0);
        coeff1.add(6.0);
        coeff1.add(11.0);
        coeff1.add(0.0);
        coeff2.add(-3.0);
        coeff2.add(2.0);
        coeff2.add(0.0);
        repo.add(new FirstDegreeEquation(coeff));
        repo.add(new SecondDegreeEquation(coeff1));
        repo.add(new SecondDegreeEquation(coeff2));
        Controller ctrl = new Controller(repo);
        loader.setController(ctrl);
        Parent root = loader.load();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 550, 580));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
