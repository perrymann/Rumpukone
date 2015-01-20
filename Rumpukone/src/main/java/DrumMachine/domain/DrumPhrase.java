
package DrumMachine.domain;

import java.util.Random;
import jm.JMC;
import jm.music.data.*;
import jm.music.tools.Mod;

public class DrumPhrase {
    private Phrase fraasi;
    
    public DrumPhrase() {
        this.fraasi = new Phrase(0.0);
    }
    
    public Phrase getPhrase() {
        return fraasi;
    }
    
    public void addNote(Hit isku) {
        this.fraasi.add(isku.getNuotti());
    }
    
    public void loopPhrase(int loop) {
        Mod.repeat(this.fraasi, loop);
    }
}    
    
    
