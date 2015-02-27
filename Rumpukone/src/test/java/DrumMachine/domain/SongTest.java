/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrumMachine.domain;

import drummachine.domain.Drumbeat;
import drummachine.domain.Song;
import jm.music.data.Score;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pnikande
 */
public class SongTest {
    private Song song;
    
    public SongTest() {
    }
    
    @Before
    public void setUp() {
        this.song = new Song("Testi");
    }
  
    @Test 
    public void addDrumBeatToimiiOikein() {
        Drumbeat drumbeat = new Drumbeat(120);
        this.song.addDrumbeat(drumbeat);
        assertTrue(1 == this.song.getDrumbeatList().size());
    }
    
    @Test
    public void finalizeToimiiOikein() {
        Drumbeat drumbeat1 = new Drumbeat(120);
        this.song.addDrumbeat(drumbeat1);
        Drumbeat drumbeat2 = new Drumbeat(120);
        this.song.addDrumbeat(drumbeat2);
        this.song.finalizeSong();
        assertTrue(this.song.getPartToSong() != null);
    }
}
