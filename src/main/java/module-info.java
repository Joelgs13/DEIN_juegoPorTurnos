module org.example.juegoporturnos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;


    opens org.example.juegoporturnos to javafx.fxml;
    exports org.example.juegoporturnos;
}