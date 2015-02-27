
package drummachine.domain;

import java.util.ArrayList;
import jm.music.data.*;
import jm.music.tools.Mod;

/**
 * @author pnikande
 * Luokassa DrumPhrase luodaan fraasi, joka sisältää yksittäisen rummun ja symbaalin iskuja. Luokka sisältää 
 * oliomuuttujana JMusicin Phrase-olion. Phrase-oliot tallennetaan ArrayList-muuttujaan.
 */

public class DrumPhrase {
    private Note [] bassDrum;
    private Note [] snare;
    private Note [] crash;
    private Note [] hihat;
    private Note [] ghost;
    private Phrase bd = new Phrase(0.0);
    private Phrase sn = new Phrase(0.0);
    private Phrase cr = new Phrase(0.0);
    private Phrase hh = new Phrase(0.0);
    private Phrase gh = new Phrase(0.0);
    private ArrayList<Phrase> phraseList = new ArrayList<>();
    
    public DrumPhrase(int length) {
        this.bassDrum = new Note[length];
        this.crash = new Note[length];
        this.snare = new Note[length];
        this.hihat = new Note[length];
        this.ghost = new Note[length];
    }
    
    /**
     * Metodi lisää Note-olion bassdrum-iskuja sisältävään Note-arrayhin position-parametrin määrättyyn indeksiin.
     * 
     * @param hit määrittää arrayhin lisättävän Note-olion.
     * @param position määrittää arrayn indeksin, johon Note-olio lisätään.
     */
    
    public void addBassDrumHitToList(Note hit, int position) {
        this.bassDrum [position] = hit;
        System.out.println("toimiiko");
    }
    
    /**
     * Metodi lisää Note-olion snare-iskuja sisältävään Note-arrayhin position-parametrin määrättyyn indeksiin.
     * 
     * @param hit määrittää arrayhin lisättävän Note-olion.
     * @param position määrittää arrayn indeksin, johon Note-olio lisätään.
     */
    
    public void addSnareHitToList(Note hit, int position) {
        this.snare [position] = hit;
    }
    
    /**
     * Metodi lisää Note-olion open hi hat -iskuja sisältävään Note-arrayhin position-parametrin määrättyyn indeksiin.
     * 
     * @param hit määrittää arrayhin lisättävän Note-olion.
     * @param position määrittää arrayn indeksin, johon Note-olio lisätään.
     */
    
    public void addCrashHitToList(Note hit, int position) {
        this.crash [position] = hit;
    }
    
    /**
     * Metodi lisää Note-olion hi hat -iskuja sisältävään Note-arrayhin position-parametrin määrättyyn indeksiin.
     * 
     * @param hit määrittää arrayhin lisättävän Note-olion.
     * @param position määrittää arrayn indeksin, johon Note-olio lisätään.
     */
    
    public void addHihatHitToList(Note hit, int position) {
        this.hihat [position] = hit;
    }
    
    /**
     * Metodi lisää Note-olion Ghost snare -iskuja sisältävään Note-arrayhin position-parametrin määrättyyn indeksiin.
     * 
     * @param hit määrittää arrayhin lisättävän Note-olion.
     * @param position määrittää arrayn indeksin, johon Note-olio lisätään.
     */
    
    public void addGhostHitToList(Note hit, int position) {
        this.ghost [position] = hit;
        
    }
    
    /**
     * Metodi lisää Note-arrayt DrumPhrase-luokan luomaan Phrase-olioihin ja lisää ne ArrayList-muuttujaan.  
     * 
     * @return ArrayList<> sisältää eri rummuille varatut Phrase-oliot.
     */
    
    public ArrayList<Phrase> finalizePhraseLists() {
        bd.addNoteList(bassDrum);
        sn.addNoteList(snare);
        cr.addNoteList(crash);
        hh.addNoteList(hihat);
        gh.addNoteList(ghost);
        
        phraseList.add(bd);
        phraseList.add(sn);
        phraseList.add(cr);
        phraseList.add(hh);
        phraseList.add(gh);
        
        quantize();
        
        return phraseList;
        
    }
    
    public int getLength() {
        return this.bassDrum.length;
    }
    
    public Note [] getNoteArray() {
        return this.bassDrum;
    }

    /**
     * Metodi kvantisoi rummun iskut fraasissa.
     * 
     */
    public void quantize() {
        for (Phrase x : phraseList) {
            Mod.quantise(x, 0.0);
        }
    }

}
