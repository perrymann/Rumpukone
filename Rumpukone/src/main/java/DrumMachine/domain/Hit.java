
package DrumMachine.domain;

import jm.music.data.*;

/**
 * @author pnikande
 * 
 * Luokassa Hit luodaan yksittäinen rummun tai symbaalin isku. Luokka sisältää oliomuuttujana Jmusicin 
 * Note-olion.
 */

public final class Hit {
    private Note hit;
    
    public Hit(int instrument, int rhythmValue) {
        this.hit = new Note(getInstrument(instrument), getRhythmValue(rhythmValue), dynamize());
        
    }
    /**
     * Metodi määrittää mikä midi-instrumentti valitaan syötteen perusteella.
     * 
     * @param instrument
     * @return midi-instrumenttia vastaava arvo
     */    

    public int getInstrument(int instrument) {
        if (instrument == 1) {
            instrument = 35; //Bassdrum
        }
        else if (instrument == 2) {
            instrument = 36; //toinen Bass drum
        }
        else if (instrument == 3) { // snare
            instrument = 38;
        }
        else if (instrument == 4) { // hi-hat 
            instrument = 42;
        } else {
            instrument = -2147483648;
        }
        return instrument;
    }
    
    /**
     * Metodi määrittää iskulle aika-arvon syötteen perusteella ja muuttaa sen liukuluvuksi.
     * @param rhythmValue
     * @return Jmusicin arvoja vastaava liukuluku
     */
    
    public double getRhythmValue(int rhythmValue) {
        double x = rhythmValue;
        
        if (x == 4) {
            x = 1.0;
        }
        else if (x == 8) {
            x = 0.5;
        }
        else if (x == 16) {
            x = 0.25;
        }
        return x;
    }
    
    /**
     * Metodi palauttaa Note-tyyppisen oliomuuttujan.
     * @return Note
     */
    
    public Note getHit() {
        return this.hit;
    }
    
    /**
     * Metodi palauttaa Note-tyyppisen oliomuuttujan voimakkuuden arvon. 
     * @return Note-tyyppisen muuttujan voimakkuus kokonaislukuna.
     */
    
    public int getDynamics() {
        return this.hit.getDynamic();
    }
    
    public String toString () {
        return this.hit.getFrequency() + ", " + this.hit.getRhythmValue() + ", " + this.hit.getDynamic();
    }
    
    /**
     * Metodi arpoo luotavalle Note-tyyppiselle oliomuuttujalle satunnaisen voimakkuusarvon. 
     * @return Kokonaisluku väliltä 80-125.
     */
    
    public int dynamize() {
        return (int) (Math.random() * 45 + 80);
   
    }
}
