
package DrumMachine.domain;

import jm.music.data.*;
import jm.music.tools.*;
import jm.util.Play;

/**
 * @author pnikande
 * 
 * Luokassa Drumbeat luodaan yksittäinen rumpukomppi. Luokka sisältää oliomuuttujana JMusicin 
 * Part-olion.
 */


public class Drumbeat {
    private String name;
    private Part drumBeat;
    
    public Drumbeat(String name) {
        this.name = name;
        this.drumBeat = new Part(this.name, 0, 9);
    }
    
    /**
     * Metodi lisää Phrase-muuttujan rumpukomppiin.
     * @param phrase 
     */
    
    public void addDrumPhrase(Phrase phrase) {
        drumBeat.add(phrase);
    }
    
    /**
     * Metodi asettaa rumpukompille tempon.
     * @param tempo 
     */
    
    public void setTempoForDrumbeat(double tempo) {
        this.drumBeat.setTempo(tempo);
    }
    
    /**
     * Metodi määrittää rumpukompin mahdollisten toistokertojen määrän.
     * @param loops 
     */
    
    public void loopDrumbeat(int loops) {
        Mod.repeat(drumBeat, loops);
    }
    
    public Part getBeat() {
        return drumBeat;
    }
    public String getName() {
        return name;
    }
    
    /**
     * Metodi toistaa valmiin rumpukompin, esimerkiksi testausta varten.
     */
    
    public void testDrumbeat () {
        Play.midi(drumBeat);
    }
}
