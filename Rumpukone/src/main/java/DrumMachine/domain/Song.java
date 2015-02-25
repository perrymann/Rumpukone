
package DrumMachine.domain;

import java.util.ArrayList;
import jm.music.data.*;
import jm.music.tools.Mod;
import jm.util.Play;

/**
 * @author pnikande
 * 
 * Luokassa Song luodaan kappaleen pohja. Song-olio sisältää luokkamuuttujana JMusicin Score-olion.
 * Kappaleeseen tulevat rumpukompit (Drumbeat) tallennetaan ensiksi ArrayList-tyyppiseen oliomuuttujaan, 
 * josta ne siirretään FinalizeSong()-metodissa JMusicin Score-olioon.
 */

public class Song {
    private Score song;
    private String name;
    private ArrayList<Drumbeat> drumbeatList = new ArrayList<>();
    
    
    public Song(String name) {
        this.name = name;
        this.song = new Score(this.name);
        System.out.println("testi");
    }
    
    public Score getSong() {
        return this.song;
    }
    
    /**
     * Metodi lisää Drumbeat-luokan ilmentymän ArrayList-muuttujaan. 
     * @param drumbeat 
     */
    
    public void addDrumbeat(Drumbeat drumbeat) {
        this.drumbeatList.add(drumbeat);                    //this.song.add(drumbeat.getbeat());
        System.out.println("lisätty listaan");
        
    }
    
    /**
     * Metodi siirtää Drumbeat-luokan ilmentymät ArrayList-muuttujasta paikalliseen Array-muuttujaan ja 
     * siirtää Drumbeat-luokan Part-oliot Score-olioon.
     * 
     */
    
    public void finalizeSong() {
        Part tmp = drumbeatList.get(0).getBeat();
        for (int i = 1; i < drumbeatList.size(); i++) {
            Mod.append(tmp, drumbeatList.get(i).getBeat());
        }
        this.song.add(tmp);
    }
    
    /**
     * Metodi toistaa Score-olion sisältämän mididatan.
     */
    
    public void play() {
        Play.midi(this.song);
    }
    
}
