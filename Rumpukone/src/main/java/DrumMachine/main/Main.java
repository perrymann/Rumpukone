/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DrumMachine.main;

import DrumMachine.ui.UI;
import DrumMachine.domain.*;
import javax.swing.SwingUtilities;

/**
 *
 * @author pnikande
 */
public class Main {
    
    public static void main(String[] args) {
        Machine sovelluslogiikka = new Machine(); 
        UI ui = new UI(sovelluslogiikka);
        SwingUtilities.invokeLater(ui);
          
      
        
    }
}
