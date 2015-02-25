
package DrumMachine.domain;

import java.io.FileNotFoundException;
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
     * @throws java.io.FileNotFoundException 
     */
    
    public void playSavedFile(String name) throws FileNotFoundException {
        Play.mid(name + ".mid");
      
    }    
    /**
     * Metodi tallentaa Score-olion mid-tiedostona.
     * @param score
     * @param name 
     */
    
    public void writeToMidiFile(Score score, String name) {
        Write.midi(score, name + ".mid");
        System.out.println("jes!");
    }    
    
}
