
package DrumMachine.domain;

import jm.music.data.*;
import jm.util.*;

/**
 * 
 * @author pnikande
 * 
 * Luokassa ReaderPlayer tallennetaan Score-olio .mid-tiedostona projektitiedoihin, 
 * josta se on haettavissa toistoa varten.
 */

public class ReaderPlayer {

    public ReaderPlayer() {
    }
    
    /**
     * Metodi toistaa tallennetun mid-tiedoston.
     * @param name 
     */
    
    public void playSavedFile(String name) {
        Play.mid(name + ".mid");
    }
    
    /**
     * Metodi tallentaa Score-olion mid-tiedostona.
     * @param score
     * @param name 
     */
    
    public void writeToFile(Score score, String name) {
        Write.midi(score, name + ".mid");
    }    
    
}
