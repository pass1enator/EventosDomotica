package pedro.ieslaencanta.com.eventos;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import pedro.ieslaencanta.com.eventos.domotic.IDevice;

/**
 * JavaFX App
 */
public class App extends Application {

    private GridPane grid;
    private ArrayList<IDevice> devices;
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        this.devices= new ArrayList<>();
        this.createGridView();
        var scene = new Scene(this.grid, 640, 480);
        stage.setScene(scene);
         stage.setOnCloseRequest(arg0 -> {
            
         });   
        stage.show();
    }

    public void createGridView() {
        this.grid = new GridPane();
        this.grid.setMinSize(640, 480);
        this.grid.setAlignment(Pos.CENTER);
        var ligth = new LightComponent();//eView(Resources.getInstance().getImage("light_on"));
        var sswitch= new SwitchComponent();
        var psenso= new PresenceComponent();
        
        sswitch.getSwitch().addChangeStateListener(ligth.getLight());
        psenso.getElement().addChangeStateListener(ligth.getLight());
        this.devices.add(ligth.getLight());
        this.devices.add(sswitch.getSwitch());
        this.devices.add(psenso.getElement());
        this.devices.forEach( c-> {c.Start();});
        
        this.grid.add(ligth, 0, 0);
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
