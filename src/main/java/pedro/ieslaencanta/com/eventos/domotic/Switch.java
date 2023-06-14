/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic;

import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import java.util.Vector;
import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;

/**
 *
 * @author Pedro
 */
public class Switch implements IDeviceBoolean {

    private EBooleanState state;
     private DeviceState deviceState;
     
    private Vector<ISwitchListener> switchlisteners;

    public Switch() {
        this.switchlisteners = new Vector<>();
    }

    public void addChangeStateListener(ISwitchListener l) {
        this.switchlisteners.add(l);
    }

    public void removeChangeStateListener(ISwitchListener l) {
        this.switchlisteners.remove(l);
    }

    public EBooleanState getState() {
        return state;
    }

    public void setState(EBooleanState state) {
        boolean sendevent = false;
        if (state != this.state) {
            sendevent = true;
        }
        this.state = state;
        if (sendevent) {
            onChangeState();
        }
    }

    private void onChangeState() {
        SwitchEvent event = new SwitchEvent(this);
//se avisa
        this.switchlisteners.forEach(sl -> sl.onSwitchChange(event));
    }
       @Override
    public void Start() {
          this.deviceState=DeviceState.Running;
    }

    @Override
    public void Stop() {
          this.deviceState=DeviceState.Stopped;
    }

    @Override
    public DeviceState getDeviceState() {
       return this.deviceState;
        
    }
}
