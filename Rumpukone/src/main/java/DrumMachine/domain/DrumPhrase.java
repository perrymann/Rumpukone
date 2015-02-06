
package DrumMachine.domain;

import jm.music.data.*;


/**
 * @author pnikande
 * Luokassa DrumPhrase luodaan fraasi, joka sisältää yksittäisen rummun ja symbaalin iskuja. Luokka sisältää 
 * oliomuuttujana JMusicin Phrase-olion.
 */


public class DrumPhrase {
    private Phrase phrase;
    
    public DrumPhrase() {
        this.phrase = new Phrase(0.0);
    }
    
    public Phrase getPhrase() {
        return phrase;
    }
    
    /**
     * Metodi lisää Hit-luokan luoman olion Note DrumPhrase-luokan luomaan Phrase-olioon.  
     * @param hit 
     */
    
    public void addHit(Hit hit) {
        this.phrase.add(hit.getHit());
    }

}    
    
    
