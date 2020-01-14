module TestMAP {
    requires javafx.fxml;
    requires  javafx.controls;
    requires javafx.graphics;
    opens Domain;
    opens Repository;
    opens sample;
}