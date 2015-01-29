
package DrumMachine.domain;

import jm.music.data.*;
import jm.util.*;

public class ReaderPlayer {

    public ReaderPlayer() {
    }
    
    // soittaa tallennetun tiedoston...
    
    public void playSavedFile(String name) {
        Play.mid(name + ".mid");
    }
    
    // Tallentaa tiedoston
    
    public void writeToFile(Score score, String name) {
        Write.midi(score, name + ".mid");
    }    
    
}
