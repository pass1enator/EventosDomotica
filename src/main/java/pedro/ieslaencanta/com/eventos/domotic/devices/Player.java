/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos.domotic.devices;

import pedro.ieslaencanta.com.eventos.domotic.events.SensorEvent;
import java.util.Vector;
import java.util.function.Consumer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import pedro.ieslaencanta.com.eventos.LightComponent;
import pedro.ieslaencanta.com.eventos.Resources;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDevice;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDeviceBoolean;
import pedro.ieslaencanta.com.eventos.domotic.devices.interfaces.IDeviceInteger;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.IDimmerListener;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISensorListener;
import pedro.ieslaencanta.com.eventos.domotic.devices.listeners.ISwitchListener;
import pedro.ieslaencanta.com.eventos.domotic.events.DimmerEvent;

import pedro.ieslaencanta.com.eventos.domotic.events.SwitchEvent;

/**
 *
 * @author Pedro
 */
public class Player implements IDimmerListener, ISwitchListener, IDevice {

    private EBooleanState state;
    private DeviceState deviceState;

    private MediaPlayer mediaplayer;

    public Player() {
        this.deviceState = deviceState.Stopped;
        this.state = EBooleanState.OFF;
        this.mediaplayer = Resources.getInstance().getSound("sonido");
        //entrar en bucle, evento que salta al terminar
        this.mediaplayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaplayer.seek(Duration.ZERO);
                mediaplayer.play();
            }
        });

    }

    public synchronized void setOn() {
        this.state = EBooleanState.ON;
        this.mediaplayer.play();
        System.out.println("Se ha encendido el reproductor");
    }

    public synchronized void setOff() {
        this.state = EBooleanState.OFF;
        this.mediaplayer.stop();
        System.out.println("Se ha apagado el reproductor");
    }

    private synchronized void changeDeviceState(DeviceState d) {
        this.deviceState = d;
    }

    @Override
    public void Start() {

        this.changeDeviceState(deviceState.Running);

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
    public void onDimmerChange(DimmerEvent event) {
        
        this.mediaplayer.setVolume(((IDeviceInteger) event.getSource()).getLevel()/100d);
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
