
package DrumMachine.domain;

import jm.JMC;
import jm.midi.*;
import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class Machine {
    private DrumPhrase drumPhrase;
    private Drumbeat drumBeat;
    private Hit drumHit;
    private Song song;
    private ReaderPlayer readerPlayer = new ReaderPlayer();
 

    public Machine() {
    }
    
    // komennot kirjoitus/toisto-oliolle;
    
    public void writeFile(String name) {
       readerPlayer.writeToFile(getSong(),name);
    }
    
    public void playSong(String name) {
        readerPlayer.playSavedFile(name);
    }
    
    // Luodaan pohja biisille
    
    public void createSong(String nimi) {
        this.song = new Song(nimi);
    }
    
    public Score getSong() {
        return this.song.getSong();
    }
    
    public void playSong() {
        this.song.play();
    }
    
    // Luodaan uusi osa (eli rumpukomppi) 
    
    public void createDrumbeat(String nimi) {
        this.drumBeat = new Drumbeat(nimi);
    }
    
    public void setTempoForDrumbeat(double tempo) {
        this.drumBeat.setTempoForDrumbeat(tempo);
    }
    
    public void defineLooping(int loop) {
        this.drumBeat.loopDrumbeat(loop);
    }
    
    // lisätään fraasi komppiin
    
    public void addDrumPhraseIntoDrumbeat () {
        this.drumBeat.addDrumPhrase(this.drumPhrase.getPhrase());
    }
    
    // Lisätään rumpukompit biisiin
    
     public void addDrumbeatIntoSong() {
        this.song.addDrumbeat(drumBeat);
    }
    
     
   
    // testataan rumpukomppia 
    
    public void testDrumBeat() {
        this.drumBeat.testDrumbeat();
    }
    
    // Luodaan DrumPhrase (= yksittäisen rummun "stemma" ja Hit (yksittäinen isku)
    
    public void createDrumPhrase () {
        this.drumPhrase = new DrumPhrase();
    }
    
    public void createHit(int instrument, int rhythmValue) {
        this.drumHit = new Hit(instrument, rhythmValue);
    }
    
    // Lisätään iskuja DrumPhraseen
    
    public void addHitIntoPhrase() {
        this.drumPhrase.addHit(this.drumHit);
    }
    
   
    
}
