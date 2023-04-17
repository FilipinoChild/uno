module me.trendingz.uno {
    requires javafx.controls;
    requires javafx.fxml;


    opens me.trendingz.uno to javafx.fxml;
    exports me.trendingz.uno;
}