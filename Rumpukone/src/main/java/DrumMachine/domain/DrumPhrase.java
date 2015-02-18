
package DrumMachine.domain;

import java.util.ArrayList;
import jm.music.data.*;


/**
 * @author pnikande
 * Luokassa DrumPhrase luodaan fraasi, joka sisältää yksittäisen rummun ja symbaalin iskuja. Luokka sisältää 
 * oliomuuttujana JMusicin Phrase-olion.
 */


public class DrumPhrase {
    private Note [] bassDrum;
    private Note [] snare;
    private Note [] crash;
    private Note [] hihat;
    private Phrase bd = new Phrase(0.0);
    private Phrase sn = new Phrase(0.0);
    private Phrase cr = new Phrase(0.0);
    private Phrase hh = new Phrase(0.0);
    private ArrayList<Phrase> phraseList = new ArrayList<>();
    
    public DrumPhrase(int length) {
        this.bassDrum = new Note[length];
        this.crash = new Note[length];
        this.snare = new Note[length];
        this.hihat = new Note[length];
        
        
    }
    
    public void addBassDrumHitToList(Note hit, int position) {
        this.bassDrum [position] = hit;
    }
    
    public void addSnareHitToList(Note hit, int position) {
        this.snare [position] = hit;
    }
    
    public void addCrashHitToList(Note hit, int position) {
        this.crash [position] = hit;
    }
    
    public void addHihatHitToList(Note hit, int position) {
        this.hihat [position] = hit;
    }
    
//    /**
//     * Metodi lisää Hit-luokan luoman olion Note DrumPhrase-luokan luomaan Phrase-olioon.  
//     * @param hit
//     */
    
    public ArrayList<Phrase> finalizePhraseLists() {
        bd.addNoteList(bassDrum);
        sn.addNoteList(snare);
        cr.addNoteList(crash);
        hh.addNoteList(hihat);
        
        phraseList.add(bd);
        phraseList.add(sn);
        phraseList.add(cr);
        phraseList.add(hh);
       
        
        return phraseList;
        
    }

}    
    
    
