
package DrumMachine.domain;

import DrumMachine.ui.UI;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import jm.music.data.*;

/**
 * @author pnikande
 * 
 * Machine-luokka luo muut domain-pakkauksessa olevat oliot ja vastaa sovelluslogiikasta. 
 */

public class Machine {
    private int length;
    private DrumPhrase drumPhrase;
    private Drumbeat drumBeat;
    private Hit drumHit;
    private Song song;
    private final ReaderPlayer readerPlayer = new ReaderPlayer();
    private ArrayList<Phrase> drumPhraseList;
    private UI ui;
 

    public Machine() {
    }
    
    /**
     * Metodi writeFile(String name) kutsuu ReaderPlayer-luokan metodia,joka tallentaa Score-olion mid-tiedostona. 
     * @param name 
     */
    
    public void writeFile(String name) {
       readerPlayer.writeToMidiFile(getSong(),name);
    }
    
    /**
     * Metodi playSong(String name) kutsuu ReaderPlayer-luoka metodia, joka toistaa tallennetun mid-tiedoston.
     * @param name 
     */
    
    public void playSong(String name) throws FileNotFoundException {
        readerPlayer.playSavedFile(name);
    }
    
    /**
     * Metodi createSong(String nimi) luo uuden Song-luokan ilmentymän.
     * @param nimi
    */
    
    public void createSong() {
        this.song = new Song("testi");
    }
    
    public Score getSong() {
        return this.song.getSong();
    }
    
    /**
     * Metodi playSong() kutsuu Song-luokan metodia, joka toistaa Score-muuttujan.
     */
    
    public void playSong() {
        this.song.play();
        System.out.println("soitetaan");
    }
    
    /**
     * Metodi createDrumbeat(String nimi) luo uuden Drumbeat-luokan ilemntymän. 
     *  
     * @param tempo asettaa tempon
     */
    
    public void createDrumbeat(int tempo) {
        this.drumBeat = new Drumbeat(tempo);
        
    }
    
    /**
     * Metodi defineLooping(int loop) kutsuu Drumbeat-luokan metodia, 
     * joka määrittää kuinka monta kertaa rumpukomppi loopataan.
     * @see loopDrumbeat(loop)
     * @param loop 
     */
    
    public void defineLooping(int loop) {
        this.drumBeat.loopDrumbeat(loop);
    }
    
    /**
     * Metodi addDrumPhraseIntoDrumbeat() kutsuu Drumbeat-luokan metodia, joka lisää fraasin rumpukomppiin.
     */
    
    public void addDrumPhrasesIntoDrumbeat() {
        for (Phrase x : drumPhraseList) {
            this.drumBeat.addDrumPhrase(x);
        }
    }
    
    /**
     * Metodi addDrumbeatIntoSong() kutsuu Song-luokan metodia, joka lisää rumpukompin kappaleeseen.
     * 
     */
    
    public void addDrumbeatIntoList() {
        this.song.addDrumbeat(drumBeat);
    }
     
    public void finalizeSong() {
        this.song.finalizeSong();
    }
    
    /**
     * Metodi testDrumBeat() kutsuu Drumbeat-luokan metodia, joka toistaa rumpukompin. 
     */
     
    public void testDrumBeat() {
        this.drumBeat.testDrumbeat();
    }
    
    /**
     * Metodi createDrumPhrase() luo uuden drumPhrase-luokan ilmentymän. 
     * @param length määrittää fraasin tahtilajin.
     */
    
    public void createDrumPhrase(int length) {
        System.out.println(length);
        this.length = length;
        this.drumPhrase = new DrumPhrase(length);
    }
    
    public Drumbeat getDrumbeat() {
        return this.drumBeat;
    }
       
    /**
     * Metodi formatDrumPhrase() alustaa kaikkien fraasien iskut tauoiksi.
     */
      public void formatDrumPhrase() {
        this.drumHit = new Hit(-1, 8);
        for (int j = 0; j < length; j++) {
            this.drumPhrase.addBassDrumHitToList(drumHit.getHit(), j);
            this.drumPhrase.addSnareHitToList(drumHit.getHit(), j);
            this.drumPhrase.addCrashHitToList(drumHit.getHit(), j);
            this.drumPhrase.addHihatHitToList(drumHit.getHit(), j);
            this.drumPhrase.addGhostHitToList(drumHit.getHit(), j);
        }
    }

    /**
     * Metodi createHit(int instrument, int rhythmValue) luo uuden Hit-luokan ilemntymän.
     * @param instrument
     * @param rhythmValue 
     * @param row 
     * @param column 
     */
    
    public void createHit(int instrument, int rhythmValue, int row, int column) {
        if (column <= length - 1) {
            this.drumHit = new Hit(instrument, rhythmValue);
            if (row == 0) {
                this.drumPhrase.addBassDrumHitToList(drumHit.getHit(), column);
            } else if (row == 1) {
                this.drumPhrase.addSnareHitToList(drumHit.getHit(), column);
            } else if (row == 2) {
                this.drumPhrase.addCrashHitToList(drumHit.getHit(), column);
            } else if (row == 3) {
                this.drumPhrase.addHihatHitToList(drumHit.getHit(), column);
            } else if (row == 4) {
                this.drumPhrase.addGhostHitToList(drumHit.getHit(), column);
            }    
        }    
    }
    
    /**
     *  
     */
    
    public void FinalizePhrases() {
        this.drumPhraseList = this.drumPhrase.finalizePhraseLists();
    }
}
