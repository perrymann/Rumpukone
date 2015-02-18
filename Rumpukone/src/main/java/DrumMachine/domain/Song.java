
package DrumMachine.domain;

import java.util.ArrayList;
import jm.music.data.*;
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
    }
    
    public Score getSong() {
        return this.song;
    }
    
    /**
     * Metodi lisää Drumbeat-luokan ilmentymän ArrayList-muuttujaan. 
     * @param drumbeat 
     */
    
    public void addDrumbeat(Drumbeat drumbeat) {
        this.drumbeatList.add(drumbeat);
    }
    
    /**
     * Metodi siirtää Drumbeat-luokan ilmentymät ArrayList-muuttujasta paikalliseen Array-muuttujaan ja 
     * siirtää Drumbeat-luokan Part-oliot Score-olioon.
     * 
     */
    
    public void finalizeSong() {
        Part [] l = new Part [drumbeatList.size()];
        int temp = 0; 
        for (Drumbeat x : drumbeatList) {
            l [temp] = x.getBeat();
            temp++;
        }
        this.song.addPartList(l);
    }
    
    /**
     * Metodi toistaa Score-olion sisältämät mididatan.
     */
    
    public void play() {
        Play.midi(this.song);
    }
    
    /**
     * Metodi palauttaa merkkijonona ArrayList-muuttujan sisältämät Drumbeat-oliot.
     * @return String
     */
    
    public String getDrumbeatList() {
        String beats = "";
        int tmp = 1;
        for (Drumbeat x : drumbeatList) {
            beats += tmp + ") " + x.getName() + "\n";
        }
        return beats;
    }
    
    /**
     * Metodi hakee Drumbeat-olioita ArrayList-muuttujasta indeksinumeron perusteella. 
     * @param index
     * @return Drumbeat
     */
    
    public Drumbeat getBeatFromList(int index) {
        return drumbeatList.get(index);
        
    }
}
