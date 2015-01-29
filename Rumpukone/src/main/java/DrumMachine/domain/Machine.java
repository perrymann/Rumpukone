
package DrumMachine.domain;

import jm.JMC;
import jm.midi.*;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class Machine {
    private DrumPhrase rumpufraasi;
    private Drumbeat rumpukomppi;
    private Hit isku;
    private Song biisi;
    private ReaderPlayer rp = new ReaderPlayer();
//    private Phrase [] fraasilista; 

    public Machine() {
    }
    
    // komennot kirjoitus/toisto-oliolle;
    
    public void writeFile(String name) {
       rp.writeToFile(getSong(),name);
    }
    
    public void playSong(String name) {
        rp.playSavedFile(name);
    }
    

    // Luodaan pohja biisille
    
    public void createSong(String nimi) {
        this.biisi = new Song(nimi);
    }
    
    public Score getSong() {
        return this.biisi.getSong2();
    }
    
    public void setTempoForSong(double tempo) {
        this.biisi.setTempoForSong2(tempo);
    }
    
    public void playSong() {
        this.biisi.play();
    }
    
    // Luodaan uusi osa (eli rumpukomppi) ja lisätään se biisiin
    
    public void createDrumbeat(String nimi) {
        this.rumpukomppi = new Drumbeat(nimi);
    }
    
    public void addDrumbeatIntoScore() {
        this.biisi.addDrumbeat(rumpukomppi.getBeat());
    }
    
    public void addDrumPhraseIntoDrumbeat () {
        this.rumpukomppi.addDrumPhrase(this.rumpufraasi.getPhrase());
    }
   
    // testataan rumpukomppia 
    
    public void testDrumBeat() {
        this.rumpukomppi.testDrumbeat();
    }
    
    // Luodaan DrumPhrase (= yksittäisen rummun "stemma" ja Hit (yksittäinen isku)
    
    public void createDrumPhrase () {
        this.rumpufraasi = new DrumPhrase();
    }
    
    public void createHit(int instrument, int rhythmValue) {
        this.isku = new Hit(instrument, rhythmValue);
    }
    
    // Lisätään iskuja DrumPhraseen
    
    public void addHitIntoPhrase() {
        this.rumpufraasi.addHit(this.isku);
    }
    
    public void defineLooping(int loop) {
        this.rumpufraasi.loopPhrase(loop);
    }
    
}
