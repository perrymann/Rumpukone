
package DrumMachine.domain;

import jm.music.data.*;

public class Drumbeat {
    private String nimi;
    private Part kompinOsa;
    
    public Drumbeat(String nimi) {
        this.nimi = nimi;
        this.kompinOsa = new Part("nimi", 0, 9);
    }
    
    public void addPhrase(Phrase phrase) {
        kompinOsa.add(phrase);
    }
    
    public Part getBeat() {
        return kompinOsa;
    }
}
