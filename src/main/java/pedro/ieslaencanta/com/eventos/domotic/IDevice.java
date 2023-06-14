/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic;

/**
 *
 * @author Pedro
 */
public interface IDevice {
       
    public void Start();

  
    public void Stop();
    
    public DeviceState getDeviceState();
}
