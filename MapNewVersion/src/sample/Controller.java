package sample;

import Domain.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class Controller extends  RepoController{
    @FXML
    private TextField activityName;

    @FXML
    private TextField activityType;

    private   Map<Integer,Integer> c = new HashMap<Integer, Integer>();
    private   Map<Integer,Integer> rr = new HashMap<Integer, Integer>();

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

    private Node getNodeFromGridPane(GridPane gridPane, Integer col, Integer row) {
        Node result = null;
        ObservableList<Node> childrens = gridPane.getChildren();

        for (Node node : childrens) {
            if(GridPane.getRowIndex(node).equals(row) && GridPane.getColumnIndex(node).equals(col)) {
                result = node;
                break;
            }
        }

        return result;
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

        Map<String,Integer> column = new HashMap<String,Integer>();
        column.put("Monday",1);
        column.put("Tuesday",2);
        column.put("Wednesday",3);
        column.put("Thursday",4);
        column.put("Friday",5);

        Map<String,Integer> rows = new HashMap<String,Integer>();

        rows.put("8",1);
        rows.put("10",2);
        rows.put("12",3);
        rows.put("14",4);
        rows.put("16",5);

        Text tst = new Text(r.toString());


        if (c.get(column.get(day)) == null && rr.get(rows.get(hour)) == null) {

            timeTable.add(tst,column.get(day),rows.get(hour));
            c.put(column.get(day),1);
            rr.put(rows.get(hour),1);
        }
        else{
            Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText("Input not valid");
            errorAlert.setContentText("Slot already used");
            errorAlert.showAndWait();
        }
    }

    @FXML
    void addRoom(ActionEvent event) {
        String name = roomName.getText();

        Room r = new Room(name);

        roomRepository.addRoom(r);
    }



    @FXML
    void addTeacher(ActionEvent event) {
        String name = teacherName.getText();
        String rank = teacherRank.getText();

        Teacher t = new Teacher(name,rank);

        teacherRepository.addTeacher(t);
    }

    @FXML
    void removeActivity(ActionEvent event) {
        String name = activityName.getText();
        String type = activityType.getText();

        Activity a = new Activity(name,type);

        activityRepository.deleteActivity(a);
    }

    @FXML
    void removeDiscipline(ActionEvent event) {
        String name = disciplineName.getText();

        Discipline d = new Discipline(name);

        disciplineRepository.deleteDiscipline(d);
    }

    @FXML
    void removeFormation(ActionEvent event) {
        String name = formationName.getText();

        Formation f = new Formation(name);

        formationRepository.deleteFormation(f);
    }

    @FXML
    void removeRoom(ActionEvent event) {
        String name = roomName.getText();

        Room r = new Room(name);

        roomRepository.deleteRoom(r);
    }

    @FXML
    void removeTeacher(ActionEvent event) {
        String name = teacherName.getText();
        String rank = teacherRank.getText();

        Teacher t = new Teacher(name,rank);

        teacherRepository.removeTeacher(t);
    }

}
