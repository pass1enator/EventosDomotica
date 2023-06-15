/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices;


import java.util.Vector;
import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDeviceBoolean;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISwitchListener;
/**
 *
 * @author Pedro
 */
public class Switch implements IDeviceBoolean {

    private EBooleanState state;
    private DeviceState deviceState;
    //listado de escuchadores
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

    //cuando se produce el cambio de estado se emite el evento
    public void setState(EBooleanState state) {
        boolean sendevent = false;
        if (state != this.state) {
            sendevent = true;
        }
        this.state = state;
        if (sendevent) {
            //avisar
            onChangeState();
        }
    }
    //avisar a los escuchadores
    private void onChangeState() {
        SwitchEvent event = new SwitchEvent(this);

        this.switchlisteners.forEach(sl -> sl.onSwitchChange(event));
    }

    @Override
    public void Start() {
        this.deviceState = DeviceState.Running;
    }

    @Override
    public void Stop() {
        this.deviceState = DeviceState.Stopped;
    }

    @Override
    public DeviceState getDeviceState() {
        return this.deviceState;

    }
}
