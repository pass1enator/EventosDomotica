/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic;

/**
 *
 * @author Pedro
 */
public interface IDeviceInteger extends IDevice {
     public int getLevel();

    public void setLevel(int level);
    public void setMax(int max);
    public void setMin(int min);
    public void inc();
    public void dec();
}
