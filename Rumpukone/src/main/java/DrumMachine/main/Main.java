/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DrumMachine.main;

import DrumMachine.ui.UI;
import DrumMachine.domain.*;
import DrumMachine.ui.*;
import javax.swing.SwingUtilities;
import jm.music.data.Note;
import jm.util.Play;

/**
 *
 * @author pnikande
 */
public class Main {
    
    public static void main(String[] args) {
        UI ui = new UI();
        SwingUtilities.invokeLater(ui);
        
      //  Machine sovelluslogiikka = new Machine();    
      //  Kayttoliittyma kali = new Kayttoliittyma(sovelluslogiikka);
        
    }
}
