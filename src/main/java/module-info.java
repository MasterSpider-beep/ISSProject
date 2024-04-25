module com.projectiss {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.projectiss to javafx.fxml;
    exports com.projectiss;
    exports com.projectiss.GUI;
    exports com.projectiss.exceptions;
    exports com.projectiss.repository;
    exports com.projectiss.services;
    exports com.projectiss.domain;
}