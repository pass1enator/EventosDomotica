/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices.listeners;

import pedro.ieslaencanta.com.eventos.domotic.devices.*;
import pedro.ieslaencanta.com.eventos.domotic.events.DimmerEvent;
/**
 *
 * @author Pedro
 */
public interface IDimmerListener extends java.util.EventListener {

    public void onDimmerChange(DimmerEvent event);
}
