
package DrumMachine.domain;

import jm.music.data.*;
import jm.util.Play;

public class Drumbeat {
    private String nimi;
    private Part kompinOsa;
    
    public Drumbeat(String nimi) {
        this.nimi = nimi;
        this.kompinOsa = new Part("nimi", 0, 9);
    }
    
    public void addDrumPhrase(Phrase phrase) {
        kompinOsa.add(phrase);
    }
    
    public Part getBeat() {
        return kompinOsa;
    }
    public String getNimi() {
        return nimi;
    }
    
    public void testDrumbeat () {
        Play.midi(kompinOsa);
    }
}
