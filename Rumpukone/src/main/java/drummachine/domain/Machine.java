package drummachine.domain;

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

    public Score getSong() {
        return this.song.getSong();
    }

    /**
     * Metodi playSong() kutsuu Song-luokan metodia, joka toistaa
     * Score-muuttujan.
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
     * Metodi defineLooping(int loop) kutsuu Drumbeat-luokan metodia, joka
     * määrittää kuinka monta kertaa rumpukomppi loopataan.
     *
     * @see loopDrumbeat(loop)
     * @param loop määrittää toistohen määrän
     */
    public void defineLooping(int loop) {
        this.drumBeat.loopDrumbeat(loop);

    }

    /**
     * Metodi addDrumPhraseIntoDrumbeat() kutsuu Drumbeat-luokan metodia, joka
     * lisää fraasin rumpukomppiin.
     */
    public void addDrumPhrasesIntoDrumbeat() {
        for (Phrase x : drumPhraseList) {
            this.drumBeat.addDrumPhrase(x);
        }
    }

    /**
     * Metodi addDrumbeatIntoSong() kutsuu Song-luokan metodia, joka lisää
     * rumpukompin kappaleeseen.
     *
     */
    public void addDrumbeatIntoList() {
        this.song.addDrumbeat(drumBeat);
    }

    /**
     * Metodi finalizeSong() kutsuu kahta Song-luokan metodia, jotka yhdistävät
     * yksittäiset rumpukompit ja liittävät ne kappaleeseen.
     */
    public void finalizeSong() {
        this.song.finalizeSong();
        this.song.addPartToSong();
    }

    /**
     * Metodi testDrumBeat() kutsuu Drumbeat-luokan metodia, joka toistaa
     * rumpukompin.
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
     */
    public void formatDrumPhrases() {
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
     * Metodi createHit(int instrument, int rhythmValue) luo uuden Hit-luokan
     * ilemntymän.
     *
     * @param instrument määrittää instrumentin
     * @param rhythmValue määrittää aika-arvon
     * @param row määrittää minkä instrumentin listaan isku laitetaan
     * @param column määrittää iskun paikan kompissa
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
     * Metodi kutsuu DrumPhrase-luokan metodia finalizePhraseLists(), ja liittää
     * palautusarvon oliomuuttujaan drumPhraseList;
     */
    public void finalizePhrases() {
        this.drumPhraseList = this.drumPhrase.finalizePhraseLists();
    }

    public DrumPhrase getDrumPhrase() {
        return this.drumPhrase;
    }
}
