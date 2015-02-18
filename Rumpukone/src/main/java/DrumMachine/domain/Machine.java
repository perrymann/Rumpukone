
package DrumMachine.domain;

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
 

    public Machine() {
    }
    
    /**
     * Metodi writeFile(String name) kutsuu ReaderPlayer-luokan metodia,joka tallentaa Score-olion mid-tiedostona. 
     * @param name 
     */
    
    public void writeFile(String name) {
       readerPlayer.writeToFile(getSong(),name);
    }
    
    /**
     * Metodi playSong(String name) kutsuu ReaderPlayer-luoka metodia, joka toistaa tallennetun mid-tiedoston.
     * @param name 
     */
    
    public void playSong(String name) {
        readerPlayer.playSavedFile(name);
    }
    
    /**
     * Metodi createSong(String nimi) luo uuden Song-luokan ilmentymän.
     * @param nimi
    */
    
    public void createSong(String nimi) {
        this.song = new Song(nimi);
    }
    
    public Score getSong() {
        return this.song.getSong();
    }
    
    /**
     * Metodi playSong() kutsuu Song-luokan metodia, joka toistaa Score-muuttujan.
     */
    
    public void playSong() {
        this.song.play();
    }
    
    /**
     * Metodi createDrumbeat(String nimi) luo uuden Drumbeat-luokan ilemntymän. 
     *  
     * @param tempo asettaa tempon
     */
    
    public void createDrumbeat(int tempo) { //String nimi
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
    
     public void addDrumbeatIntoSong() {
        this.song.addDrumbeat(drumBeat);
    }
    
    /**
     * Metodi testDrumBeat() kutsuu Drumbeat-luokan metodia, joka toistaa rumpukompin. 
     */
     
    public void testDrumBeat() {
        this.drumBeat.testDrumbeat();
        
    }
    
    /////////////////////////////////////////////////////////////////////////
    /**
     * Metodi createDrumPhrase() luo uuden drumPhrase-luokan ilmentymän ja alustaa kaikki iskut tauoiksi.
     * 
     * @param x määrittää, kuinka monta iskua ilmentymään mahtuu.
     */
    
    public void FormatDrumPhrase(int x) {
        this.length = x;
        System.out.println(length);
        this.drumPhrase = new DrumPhrase(length);
        this.drumHit = new Hit(-1, 8);
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < length; j++) {
                this.drumPhrase.addBassDrumHitToList(drumHit.getHit(), j);
                this.drumPhrase.addSnareHitToList(drumHit.getHit(), j);
                this.drumPhrase.addCrashHitToList(drumHit.getHit(), j);
                this.drumPhrase.addHihatHitToList(drumHit.getHit(), j);
            }
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
            }
        }    
    }
    
    public void FinalizePhrases() {
        this.drumPhraseList = this.drumPhrase.finalizePhraseLists();
    }
}
