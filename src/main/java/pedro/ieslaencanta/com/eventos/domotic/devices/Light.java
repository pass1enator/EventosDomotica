/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices;

import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import java.util.Vector;
import java.util.function.Consumer;
import pedro.ieslaencanta.com.eventos.LightComponent;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDevice;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDeviceBoolean;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISensorListener;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISwitchListener;

import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;

/**
 *
 * @author Pedro
 */
public class Light implements ISensorListener,ISwitchListener, IDevice, Runnable {

    private EBooleanState state;
    private DeviceState deviceState;
    private Boolean modo_alarma;
    private static long tiempo_sleep = 1000;
    private Thread t;
    private LightComponent lc;
    public Light() {
        this.deviceState = deviceState.Stopped;
        this.state = EBooleanState.OFF;
        this.modo_alarma = false;
        this.lc=null;
    }

    public synchronized void setOn() {
        this.state = EBooleanState.ON;
        if(this.lc!=null){
            this.lc.setOn();
        }
        System.out.println("Se ha encendido la luz");
    }

    public synchronized void setOff() {
        this.state = EBooleanState.OFF;
        if(this.lc!=null){
            this.lc.setOff();
        }
        System.out.println("Se ha apagado la luz");
    }

    private synchronized void changeDeviceState(DeviceState d) {
        this.deviceState = d;
    }

    public EBooleanState getLightState() {
        return this.state;
    }

    @Override
    public void onSensorChange(SensorEvent event) {
        if (((IDeviceBoolean) event.getSource()).getState() == EBooleanState.OFF) {
             this.modo_alarma = false;
            this.setOff();
           
        } else {
             this.modo_alarma = true;
            this.setOn();
        }
    }

    public LightComponent getLc() {
        return lc;
    }

    public void setLc(LightComponent lc) {
        this.lc = lc;
    }

    @Override
    public void run() {
        while (this.deviceState == deviceState.Running) {
            try {
                Thread.sleep(Light.tiempo_sleep);
                if (this.modo_alarma) {
                    this.Switch();
                }
            } catch (InterruptedException ex) {

                // Logger.getLogger(Light.class.getName()).log(Level.ALL, null,
                //        ex);
            }
        }
    }

    private void Switch() {
        if (this.state == EBooleanState.OFF) {
            this.setOn();
        } else {
            this.setOff();
        }
    }

    @Override
    public void Start() {
        if (this.deviceState == deviceState.Stopped) {
            this.changeDeviceState(deviceState.Running);
            this.t = new Thread(this);
            this.t.start();
        }
    }

    @Override
    public void Stop() {
        this.changeDeviceState(deviceState.Stopped);
        
    }

    @Override
    public DeviceState getDeviceState() {
        return this.deviceState;
    }

    @Override
    public void onSwitchChange(SwitchEvent event) {
          if (((IDeviceBoolean) event.getSource()).getState() == EBooleanState.OFF) {
           
            this.setOff();
           
        } else {
          
            this.setOn();
        }
     }
   
}
