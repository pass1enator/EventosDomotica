/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.eventos;

import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;

/**
 *
 * @author Pedro
 */
public class Resources {

    private HashMap<String, Image> imagenes;
    private HashMap<String, MediaPlayer> sonidos;
    private HashMap<String, Font> fuentes;
    private String path_imagenes[][] = {
        {"light_on", "luz-encendida.png"},
        {"light_off", "luz_apagada.png"},
        {"switch_on", "interruptor-encendido.png"},
        {"switch_off", "interruptor-apagado.png"},
        {"sensor_presencia_on", "sensor_presencia_on.png"},
        {"sensor_presencia_off", "sensor_presencia_off.png"}
    /*,
        {"player", "Player.png"},
        {"animals", "Animals.png"},
        {"weapons", "ItemsWeapons.png"},
        {"ballons", "Balloons.png"},
        {"bricks", "Foreground.png"}*/

    };
    private String path_sonidos[][] = { /* {"wall", "BallBounce.wav"},
    {"shoot", "BubbleShot.wav"},
    {"jump", "jump1.wav"},
    {"intro", "intro.wav"},
    {"background1", "level1sound.wav"}*/};
    //nombre, fichero, tipo, tamanyo
    private String path_fuentes[][] = { /* {"wonder", "WONDER.TTF", "8BIT WONDER Nominal", "22"},
        {"pixel", "PublicPixel.TTF", "Public Pixel", "18"},
        {"arcade", "ARCADE_I.TTF", "Arcade Interlaced", "18"}*/};
    private static Resources resource;

    {
        resource = null;

    }

    private Resources() {

        load();
    }

    private void load() {
        this.imagenes = new HashMap<>();
        this.sonidos = new HashMap<>();
        this.fuentes = new HashMap<>();
        ClassLoader classLoader = getClass().getClassLoader();
        //cargar las imagenes
        for (int i = 0; i < this.path_imagenes.length; i++) {
            this.imagenes.put(this.path_imagenes[i][0], new Image(classLoader.getResource(this.path_imagenes[i][1]).toString()));
        }
        for (int i = 0; i < this.path_sonidos.length; i++) {
            this.sonidos.put(this.path_sonidos[i][0], new MediaPlayer(new Media(classLoader.getResource(this.path_sonidos[i][1]).toString())));
        }
        for (int i = 0; i < this.path_fuentes.length; i++) {
            this.fuentes.put(
                    this.path_fuentes[i][0],
                    Font.loadFont(classLoader.getResource(this.path_fuentes[i][1]).toString(),
                            Integer.parseInt(this.path_fuentes[i][3])));
        }
    }

    public static Resources getInstance() {
        if (Resources.resource == null) {
            Resources.resource = new Resources();
        }
        return Resources.resource;
    }

    public Image getImage(String name) {
        Image i = this.imagenes.get(name);
        return i;
    }

    public MediaPlayer getSound(String name) {
        return this.sonidos.get(name);
    }

    public Font getFont(String name) {
        return this.fuentes.get(name);
    }

}
