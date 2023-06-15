/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic;

import pedro.ieslaencanta.com.eventos.domotic.events.DimmerEvent;
import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import java.util.Vector;
import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;

/**
 *
 * @author Pedro
 */
public class Dimmer implements IDeviceInteger {

    private int state;
    private DeviceState deviceState;
    private int max = 100;
    private int min = 0;
    private Vector<IDimmerListener> switchlisteners;

    public Dimmer() {
        this.switchlisteners = new Vector<>();
    }

    public void addChangeStateListener(IDimmerListener l) {
        this.switchlisteners.add(l);
    }

    public void removeChangeStateListener(ISwitchListener l) {
        this.switchlisteners.remove(l);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        boolean sendevent = false;
        if (state >= min && state <= max) {
            if (state != this.state) {
                sendevent = true;
            }
            this.state = state;
            if (sendevent) {
                onChangeState();
            }
        }
    }

    private void onChangeState() {
        DimmerEvent event = new DimmerEvent(this);
        // se avisa
        this.switchlisteners.forEach(sl -> sl.onDimmerChange(event));
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

    @Override
    public int getLevel() {
        // TODO Auto-generated method stub
        return this.state;
    }

    @Override
    public void setLevel(int level) {
        this.setState(level);
    }

    @Override
    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public void setMin(int min) {
        this.min = min;
    }

    @Override
    public void inc() {
        // TODO Auto-generated method stub
        this.setLevel(this.state - 1);
    }

    @Override
    public void dec() {
        this.setLevel(this.state - 1);
    }
}
