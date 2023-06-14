/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos;

import java.util.function.Consumer;
import javafx.scene.image.ImageView;
import pedro.ieslaencanta.com.eventos.domotic.EBooleanState;
import pedro.ieslaencanta.com.eventos.domotic.Light;

/**
 *
 * @author Pedro
 */
public class LightComponent extends ImageView{
    private Light ligth;
    
    public LightComponent(){
        super();
        this.ligth= new Light();
        this.ligth.setLc(this);
         this.setImage(Resources.getInstance().getImage("light_off"));
        this.setOnMousePressed((t) -> {
            if(this.ligth.getLightState()==EBooleanState.ON){
                this.ligth.setOff();
            }
            else{
                this.ligth.setOn();
          
            }
        });
       
      
    }
    public void setOn(){
               this.setImage(Resources.getInstance().getImage("light_on"));
         
    }
    public void setOff(){
               this.setImage(Resources.getInstance().getImage("light_off"));
         
    }
    public Light getLight(){
        return this.ligth;
    }
   
    
}
