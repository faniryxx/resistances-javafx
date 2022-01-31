module com.mycompany.resistances.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.resistances.javafx to javafx.fxml;
    exports com.mycompany.resistances.javafx;
}
