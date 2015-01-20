
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
    private Score biisi;
    private Phrase [] fraasilista;
    
    public Machine() {}
    
    // Luodaan pohja biisille
    
    public void createScore(String nimi) {
        this.biisi = new Score(nimi);
    }
    
    public Score getScore() {
        return this.biisi;
    }
    
    public void setTempoForScore(double tempo) {
        this.biisi.setTempo(tempo);
    }
    
    public void playScore() {
        Play.midi(this.biisi);
    }
    
    // Luodaan uusi osa (eli rumpukomppi) ja lisätään se biisiin
    
    public void createDrumbeat(String nimi) {
        this.rumpukomppi = new Drumbeat(nimi);
    }
    
    public void addDrumbeatIntoScore() {
        this.biisi.add(rumpukomppi.getBeat());
    }
    
    public void addDrumPhraseIntoDrumbeat () {
        this.rumpukomppi.addPrase(this.rumpufraasi.getPhrase());
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
        this.rumpufraasi.addNote(this.isku);
    }
    
    public void defineLooping(int loop) {
        this.rumpufraasi.loopPhrase(loop);
    }
    
}
