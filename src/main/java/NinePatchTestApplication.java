import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NinePatchTestApplication extends Application {
    private Stage primaryStage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        var controller = new NinePatchTestController();
        loadFXMLWithExistingController("/ninePatchTest.fxml", controller, controller);
        controller.init();
        this.primaryStage = primaryStage;
        this.primaryStage.setScene(new Scene(controller));
        primaryStage.show();
    }


    public static Node loadFXMLWithExistingController(String fxmlUrl, Object controller, Object root){
        var page = new FXMLLoader( controller.getClass().getResource( fxmlUrl));
        page.setRoot(root);

        page.setClassLoader(root.getClass().getClassLoader());
        //controller factory allows us to control the instantiation of the controller.
        // if you specify a controller class in the fxml, it will default to trying to load its own instance of the controller class
        page.setControllerFactory((t)->{
            return controller;
        });
        try {
            return page.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
