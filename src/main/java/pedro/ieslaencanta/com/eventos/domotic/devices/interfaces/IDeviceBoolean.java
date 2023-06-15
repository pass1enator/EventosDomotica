/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices.interfaces;

import pedro.ieslaencanta.com.eventos.domotic.devices.*;

/**
 *
 * @author Pedro
 */
public interface IDeviceBoolean extends IDevice {
     public EBooleanState getState();

    public void setState(EBooleanState state);
}
