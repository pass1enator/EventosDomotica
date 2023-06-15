/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos;

import javafx.scene.image.ImageView;
import pedro.ieslaencanta.com.eventos.domotic.devices.EBooleanState;
import pedro.ieslaencanta.com.eventos.domotic.devices.Light;
import pedro.ieslaencanta.com.eventos.domotic.devices.PresenceSensor;
import pedro.ieslaencanta.com.eventos.domotic.devices.Switch;

/**
 *
 * @author Pedro
 */
public class PresenceComponent extends ImageView{
    private PresenceSensor  item;
    public PresenceComponent(){
        super();
        this.maxWidth(48d);
        this.maxHeight(48d);
        this.item= new PresenceSensor();
         this.setImage(Resources.getInstance().getImage("sensor_presencia_off"));
        this.setOnMousePressed((t) -> {
            if(this.item.getState()==EBooleanState.ON){
                this.item.setState(EBooleanState.OFF);
                this.setImage(Resources.getInstance().getImage("sensor_presencia_off"));
            }
            else{
                 this.item.setState(EBooleanState.ON);
                this.setImage(Resources.getInstance().getImage("sensor_presencia_on"));
         
            }
        });
    }
    public PresenceSensor getElement(){
        return this.item;
    }
    
}
