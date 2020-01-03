package sample;

import Domain.Activity;
import Domain.Discipline;
import Domain.Formation;
import Domain.Relation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Controller extends  RepoController{
    @FXML
    private TextField activityName;

    @FXML
    private TextField activityType;

    @FXML
    private Button addActivityButton;

    @FXML
    private Button removeActivityButton;

    @FXML
    private TableView<?> activityTable;

    @FXML
    private TextField disciplineName;

    @FXML
    private Button addDisciplineButton;

    @FXML
    private GridPane timeTable;

    @FXML
    private Button removeDiscipline;

    @FXML
    private TableView<?> disciplineTable;

    @FXML
    private TextField formationName;

    @FXML
    private Button addFormationButton;

    @FXML
    private Button removeFormationButton;

    @FXML
    private TableView<?> formationTable;

    @FXML
    private TextField roomName;

    @FXML
    private Button addRoomButton;

    @FXML
    private Button removeRoomButton;

    @FXML
    private TableView<?> roomTable;

    @FXML
    private TableView<?> teacherTable;

    public Controller() {
        super();
    }

    @FXML
    private TextField teacherName;

    @FXML
    private TextField teacherRank;

    @FXML
    private Button addTeacherButton;

    @FXML
    private Button removeTeacher;

    @FXML
    private TextField relationActivity;

    @FXML
    private TextField relationDiscipline;

    @FXML
    private TextField relationFormation;

    @FXML
    private TextField relationRoom;

    @FXML
    private TextField relationTeacher;

    @FXML
    private TextField relationHour;

    @FXML
    private Button addRelationButton;

    @FXML
    private TextField relationDay;

    @FXML
    void addActivity(ActionEvent event) {
        String name = activityName.getText();
        String type = activityType.getText();

        Activity a = new Activity(name,type);

        activityRepository.addActivity(a);
    }

    @FXML
    void addDiscipline(ActionEvent event) {
        String name = disciplineName.getText();

        Discipline d = new Discipline(name);

        disciplineRepository.addDiscipline(d);
    }

    @FXML
    void addFormation(ActionEvent event) {
        String name = formationName.getText();

        Formation f = new Formation(name);

        formationRepository.addFormation(f);
    }

    @FXML
    void addRelation(ActionEvent event) {
        String activity = relationActivity.getText();
        String discipline = relationDiscipline.getText();
        String formation = relationFormation.getText();
        String room = relationRoom.getText();
        String teacher = relationTeacher.getText();
        String hour = relationHour.getText();
        String day = relationDay.getText();

        Relation r = new Relation(activity,discipline,formation,room,teacher,hour);

        relationRepository.addRelation(r);

        

    }

    @FXML
    void addRoom(ActionEvent event) {

    }

    @FXML
    void addTeacher(ActionEvent event) {

    }

    @FXML
    void removeActivity(ActionEvent event) {

    }

    @FXML
    void removeDiscipline(ActionEvent event) {

    }

    @FXML
    void removeFormation(ActionEvent event) {

    }

    @FXML
    void removeRoom(ActionEvent event) {

    }

    @FXML
    void removeTeacher(ActionEvent event) {

    }

}
