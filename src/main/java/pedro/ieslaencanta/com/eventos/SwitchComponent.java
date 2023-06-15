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
public class SwitchComponent extends ImageView {

    private Switch sswitch;

    public SwitchComponent() {
        super();
        this.sswitch = new Switch();
        this.setImage(Resources.getInstance().getImage("switch_off"));
        //evento de la imagen al pulsar, cambia la imagen y se cambia el estado
        //del switch interno
        this.setOnMousePressed((t) -> {
            if (this.sswitch.getState() == EBooleanState.ON) {
                this.sswitch.setState(EBooleanState.OFF);
                this.setImage(Resources.getInstance().getImage("switch_off"));
            } else {
                this.sswitch.setState(EBooleanState.ON);
                this.setImage(Resources.getInstance().getImage("switch_on"));

            }
        });
    }
    public Switch getSwitch() {
        return this.sswitch;
    }
}
