package DrumMachine.domain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import jm.music.data.*;

/**
 * @author pnikande Machine-luokka luo muut domain-pakkauksessa olevat oliot ja
 * vastaa sovelluslogiikasta.
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
     * Metodi writeFile(String name) kutsuu ReaderPlayer-luokan metodia,joka
     * tallentaa Score-olion mid-tiedostona.
     *
     * @param name on nimi, jolla tiedosto tallentuu
     * @see DrumMachine.domain.ReaderPlayer#writeToMidiFile(jm.music.data.Score, java.lang.String)
     */
    public void writeFile(String name) {
        readerPlayer.writeToMidiFile(getSong(), name);
    }

    /**
     * Metodi playSong(String name) kutsuu ReaderPlayer-luoka metodia, joka
     * toistaa tallennetun mid-tiedoston.
     *
     * @param name on toistettvan tiedoston nimi
     * @throws java.io.FileNotFoundException
     * @see DrumMachine.domain.ReaderPlayer#playSavedFile(java.lang.String) 
     */
    
    public void playSong(String name) throws FileNotFoundException {
        readerPlayer.playSavedFile(name);
    }

    /**
     * Metodi createSong(String nimi) luo uuden Song-luokan ilmentymän.
     */
    
    public void createSong() {
        this.song = new Song("testi");
    }
    
    /**
     * @see DrumMachine.domain.Song#getSong()
     * @return Score
     */
    
    public Score getSong() {
        return this.song.getSong();
    }

    /**
     * Metodi playSong() kutsuu Song-luokan metodia, joka toistaa
     * Score-muuttujan.
     * @see DrumMachine.domain.Song#play()
     */
    
    public void playSong() {
        this.song.play();
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
     * Metodi defineLooping(int loop) kutsuu Drumbeat-luokan metodia, joka
     * määrittää kuinka monta kertaa rumpukomppi loopataan.
     *
     * @see DrumMachine.domain.Drumbeat#loopDrumbeat(int)
     * @param loop määrittää toistohen määrän
     */
    public void defineLooping(int loop) {
        this.drumBeat.loopDrumbeat(loop);
    }

    /**
     * Metodi addDrumPhraseIntoDrumbeat() kutsuu Drumbeat-luokan metodia, joka
     * lisää fraasin rumpukomppiin.
     * @see DrumMachine.domain.Drumbeat#addDrumPhrase(Phrase)
     */
    
    public void addDrumPhrasesIntoDrumbeat() {
        for (Phrase x : drumPhraseList) {
            this.drumBeat.addDrumPhrase(x);
        }
    }

    /**
     * Metodi addDrumbeatIntoSong() kutsuu Song-luokan metodia, joka lisää
     * rumpukompin kappaleeseen.
     * @see DrumMachine.domain.Song#addDrumbeat(DrumMachine.domain.Drumbeat) 
     */
    
    public void addDrumbeatIntoList() {
        this.song.addDrumbeat(drumBeat);
    }

    /**
     * Metodi finalizeSong() kutsuu kahta Song-luokan metodia, jotka yhdistävät
     * yksittäiset rumpukompit ja liittävät ne kappaleeseen.
     * @see DrumMachine.domain.Song#finalizeSong()
     * @see DrumMachine.domain.Song#addPartToSong()
     */
    
    public void finalizeSong() {
        this.song.finalizeSong();
        this.song.addPartToSong();
    }

    /**
     * Metodi testDrumBeat() kutsuu Drumbeat-luokan metodia, joka toistaa
     * rumpukompin.
     * @see DrumMachine.domain.Drumbeat#testDrumbeat()
     */
    
    public void testDrumBeat() {
        this.drumBeat.testDrumbeat();
    }

    /**
     * Metodi createDrumPhrase() luo uuden drumPhrase-luokan ilmentymän.
     * 
     * @param length määrittää fraasin tahtilajin.
     */
    
    public void createDrumPhrase(int length) {
        this.length = length;
        this.drumPhrase = new DrumPhrase(length);
    }

    public Drumbeat getDrumbeat() {
        return this.drumBeat;
    }

    /**
     * Metodi formatDrumPhrase() alustaa kaikkien fraasien iskut tauoiksi.
     * @see DrumMachine.domain.DrumPhrase#addBassDrumHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addSnareHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addOpenHatHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addHihatHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addGhostHitToList(Note, int)
     */
    
    public void formatDrumPhrases() {
        this.drumHit = new Hit(-1, 8);
        for (int j = 0; j < length; j++) {
            this.drumPhrase.addBassDrumHitToList(drumHit.getHit(), j);
            this.drumPhrase.addSnareHitToList(drumHit.getHit(), j);
            this.drumPhrase.addOpenHatHitToList(drumHit.getHit(), j);
            this.drumPhrase.addHihatHitToList(drumHit.getHit(), j);
            this.drumPhrase.addGhostHitToList(drumHit.getHit(), j);
        }
    }

    /**
     * Metodi createHit(int instrument, int rhythmValue) luo uuden Hit-luokan
     * ilemntymän.
     *
     * @param instrument määrittää instrumentin
     * @param rhythmValue määrittää aika-arvon
     * @param row määrittää minkä instrumentin listaan isku laitetaan
     * @param column määrittää iskun paikan kompissa
     * @see DrumMachine.domain.DrumPhrase#addBassDrumHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addSnareHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addOpenHatHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addHihatHitToList(Note, int)
     * @see DrumMachine.domain.DrumPhrase#addGhostHitToList(Note, int)
     */
    
    public void createHit(int instrument, int rhythmValue, int row, int column) {
        if (column <= length - 1) {
            this.drumHit = new Hit(instrument, rhythmValue);
            if (row == 0) {
                this.drumPhrase.addBassDrumHitToList(drumHit.getHit(), column);
            } else if (row == 1) {
                this.drumPhrase.addSnareHitToList(drumHit.getHit(), column);
            } else if (row == 2) {
                this.drumPhrase.addOpenHatHitToList(drumHit.getHit(), column);
            } else if (row == 3) {
                this.drumPhrase.addHihatHitToList(drumHit.getHit(), column);
            } else if (row == 4) {
                this.drumPhrase.addGhostHitToList(drumHit.getHit(), column);
            }
        }
    }

    /**
     * Metodi kutsuu DrumPhrase-luokan metodia finalizePhraseLists(), ja liittää
     * palautusarvon oliomuuttujaan drumPhraseList;
     * @see DrumMachine.domain.DrumPhrase#finalizePhraseLists()
     */
    public void finalizePhrases() {
        this.drumPhraseList = this.drumPhrase.finalizePhraseLists();
    }

    public DrumPhrase getDrumPhrase() {
        return this.drumPhrase;
    }
}
