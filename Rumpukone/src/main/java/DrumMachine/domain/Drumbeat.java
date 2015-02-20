
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
    private int tempo;
    private Part drumBeat;
    
    public Drumbeat(int tempo) {
        this.tempo = tempo;
        this.drumBeat = new Part(0, 9);
        setTempoForDrumbeat(tempo);
    }
    
    /**
     * Metodi lisää Phrase-muuttujan rumpukomppiin.
     * @param phrase 
     */
    
    public void addDrumPhrase(Phrase phrase) {
        this.drumBeat.addPhrase(phrase);
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
    
    public int getTempo() {
        return tempo;
    }
    
    /**
     * Metodi toistaa valmiin rumpukompin, esimerkiksi testausta varten.
     * 
     */
    
    public void testDrumbeat () {
        Play.midi(drumBeat);
    }
}
