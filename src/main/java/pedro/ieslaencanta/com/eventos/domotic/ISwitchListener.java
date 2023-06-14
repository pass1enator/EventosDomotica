/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic;

import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;

/**
 *
 * @author Pedro
 */
public interface ISwitchListener extends java.util.EventListener {

    public void onSwitchChange(SwitchEvent event);
}
