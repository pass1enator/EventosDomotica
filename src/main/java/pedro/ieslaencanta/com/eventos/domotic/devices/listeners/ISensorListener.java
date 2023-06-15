/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices.listeners;

import pedro.ieslaencanta.com.eventos.domotic.devices.*;
import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;

/**
 *
 * @author Pedro
 */
public interface ISensorListener extends java.util.EventListener {

    public void onSensorChange(SensorEvent event);
}
