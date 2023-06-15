/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices;

import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import java.util.Vector;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDeviceBoolean;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISensorListener;


/**
 *
 * @author Pedro
 */
public class PresenceSensor implements IDeviceBoolean {

    private EBooleanState state;
     private DeviceState deviceState;
     
    private Vector<ISensorListener> sensorlisteners;

    public PresenceSensor() {
        this.sensorlisteners = new Vector<>();
           this.state = EBooleanState.OFF;
    }

    public void addChangeStateListener(ISensorListener l) {
        this.sensorlisteners.add(l);
    }

    public void removeChangeStateListener(ISensorListener l) {
        this.sensorlisteners.remove(l);
    }

    @Override
    public EBooleanState getState() {
        return state;
    }

    @Override
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
        SensorEvent event = new SensorEvent(this);
//se avisa
        this.sensorlisteners.forEach(sl -> sl.onSensorChange(event));
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
