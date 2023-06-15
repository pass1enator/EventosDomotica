/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import pedro.ieslaencanta.com.eventos.domotic.Dimmer;
import pedro.ieslaencanta.com.eventos.domotic.EBooleanState;
import pedro.ieslaencanta.com.eventos.domotic.Light;
import pedro.ieslaencanta.com.eventos.domotic.PresenceSensor;
import pedro.ieslaencanta.com.eventos.domotic.Switch;

/**
 *
 * @author Pedro
 */
public class DimmerComponent extends Slider{
    private Dimmer  item;
    /**
     * 
     */
    public  DimmerComponent (){
        super();
        this.maxWidth(48d);
        this.maxHeight(48d);
        this.item= new Dimmer();
        this.valueProperty().addListener( (arg, oldVal, newVal)->{
           this.item.setState(newVal.intValue());
        });
        }
    public  Dimmer getElement(){
        return this.item;
    }
    
}
