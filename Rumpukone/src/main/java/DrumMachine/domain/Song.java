

package DrumMachine.domain;

import jm.music.data.*;
import jm.util.Play;

public class Song {
    private Score biisi;
    private String nimi;
    
    public Song(String nimi) {
        this.nimi = nimi;
        this.biisi = new Score(this.nimi);
    }
    
    public Score getSong2() {
        return this.biisi;
    }
    
    public void setTempoForSong2(double tempo) {
        this.biisi.setTempo(tempo);
    }
    
    public void addDrumbeat(Part part) {
        this.biisi.add(part);
    }
    
    public void play() {
        Play.midi(this.biisi);
    }
    
}
