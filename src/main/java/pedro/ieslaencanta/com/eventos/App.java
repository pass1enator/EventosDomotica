package pedro.ieslaencanta.com.eventos;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    GridPane grid;

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

       
        this.createGridView();
        var scene = new Scene(this.grid, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public void createGridView() {
        this.grid = new GridPane();
        this.grid.setMinSize(640, 480);
        this.grid.setAlignment(Pos.CENTER);
        var image = new LightComponent();//eView(Resources.getInstance().getImage("light_on"));
        var sswitch= new SwitchComponent();
        var psenso= new PresenceComponent();
        
        sswitch.getSwitch().addChangeStateListener(image.getLight());
        psenso.getElement().addChangeStateListener(image.getLight());
        this.grid.add(image, 0, 0);
        this.grid.add( sswitch, 1, 0);
        this.grid.add(psenso, 0, 1);
        /*image.setOnMouseClicked((t) -> {
                    image.setImage(Resources.getInstance().getImage("light_off"));
     
        });*/
      

    }

    public static void main(String[] args) {
        launch();
    }

}
