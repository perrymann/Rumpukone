
package drummachine.domain;

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
        this.hit = new Note(getInstrument(instrument), getRhythmValue(rhythmValue), getDynamics(instrument));
        
    }
    /**
     * Metodi määrittää mikä midi-instrumentti valitaan syötteen perusteella.
     * 
     * @param instrument on määritelty kokonaisluku (0, 1, 2, 3, 4 tai -1)
     * @return midi-instrumenttia vastaava arvo
     */    

    public int getInstrument(int instrument) {
      
        if (instrument == 0) {
            instrument = 35; //Bassdrum
        } else if (instrument == 1) {
            instrument = 46; // open hi-hat
        } else if (instrument == 2 || instrument == 4) { // snaret
            instrument = 38;
        } else if (instrument == 3) { // hi-hat 
            instrument = 42;
        } else {
            instrument = -2147483648;
        }
        return instrument;
    }
    
    /**
     * Metodi määrittää iskulle aika-arvon syötteen perusteella ja muuttaa sen liukuluvuksi.
     * @param rhythmValue on määritelty kokonaisluku. Tässä ohjelmaversiossa se on aina 8.
     * @return Jmusicin arvoja vastaava liukuluku
     */
    
    public double getRhythmValue(int rhythmValue) {
        double x = rhythmValue;
        
        if (x == 4) {
            x = 1.0;
        } else if (x == 8) {
            x = 0.5;
        } else if (x == 16) {
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
     * Metodi palauttaa Note-tyyppisen oliomuuttujan voimakkuuden arvon. Rumpu GhostSnare saa vakioarvoksi 30, muiden voimakkuus 
     * arvotaan dynamize-metodissa.
     * @param instrument
     * @return Note-tyyppisen muuttujan voimakkuus kokonaislukuna.
     */
    
    public int getDynamics(int instrument) {
        if (instrument == 4) {
            return 30;
        } else {
            return dynamize();
        }
    }
    
    /**
     * Metodi arpoo luotavalle Note-tyyppiselle oliomuuttujalle satunnaisen voimakkuusarvon. 
     * @return Kokonaisluku väliltä 80-125.
     */
    
    public int dynamize() {
        return (int) (Math.random() * 45 + 80);
   
    }
}
