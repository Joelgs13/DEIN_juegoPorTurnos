module org.example.juegoporturnos {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.juegoporturnos to javafx.fxml;
    exports org.example.juegoporturnos;
}