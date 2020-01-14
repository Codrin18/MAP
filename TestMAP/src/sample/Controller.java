package sample;

import Domain.Equation;
import Repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Repository repo;
    long i = 123;
    public Controller(Repository repo){
        this.repo = repo;
    }

    @FXML
    private ListView<String> equationsListView;

    @FXML
    private Button viewAllButton;

    @FXML
    private Button computeSolutionsButton;

    @FXML
    private Button constantTermButton;

    @FXML
    void computeSolutions(ActionEvent event) {
        int index = equationsListView.getSelectionModel().getSelectedIndex();
        ArrayList<Equation> equations = repo.getEquations();
        equationsListView.getItems().add("Solutions" + equations.get(index).getSolutions().toString());


    }

    @FXML
    void constantTerm(ActionEvent event) {
        List<Equation> equations = repo.getEquations();
        equations.stream()
                .filter(equation -> equation.getDegree()==2 && equation.getCoefficients().get(2) == 0);

        for(Equation e: equations){
            equationsListView.getItems().add(e + e.getSolutions().toString());
        }
    }

    @FXML
    void viewAll(ActionEvent event) {

    }

    @FXML
    public void initialize(){
        ArrayList<Equation> equations = repo.getEquations();
        ObservableList obs =  FXCollections.observableArrayList((equations));

        this.equationsListView.setItems(obs);
    }

}
