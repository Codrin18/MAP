module MapNewVersion {
    requires javafx.fxml;
    requires  javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    opens Domain;
    opens Repository;
    opens sample;
}