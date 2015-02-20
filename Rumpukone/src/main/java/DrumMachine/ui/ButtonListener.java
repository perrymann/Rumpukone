
package DrumMachine.ui;

import DrumMachine.domain.Machine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ButtonListener implements ActionListener{
    private Machine machine;
    private JTextField hitFieldLength;
    private JButton newBeat;
    private JButton submitBeat;
    private JButton test;
    private JTextField loopField;
    private JTextField tempoField;
   
    public ButtonListener(Machine machine, JTextField hitFieldLength, JButton newBeat, 
            JButton submitBeat, JButton test, JTextField loopField, JTextField tempoField) {
        this.machine = machine;
        this.hitFieldLength = hitFieldLength;
        this.newBeat = newBeat;
        this.submitBeat = submitBeat;
        this.test = test;
        this.loopField = loopField;
        this.tempoField = tempoField;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().equals(newBeat)) {
                int tempo = Integer.parseInt(tempoField.getText());
                machine.createDrumbeat(tempo);
                int hits = Integer.parseInt(hitFieldLength.getText());
                machine.createDrumPhrase(hits);
                machine.formatDrumPhrase();

            }
            if (ae.getSource().equals(this.submitBeat)) {
                machine.FinalizePhrases();
                machine.addDrumPhrasesIntoDrumbeat();
                int loop = Integer.parseInt(loopField.getText());
                machine.defineLooping(loop);
            }
            if (ae.getSource().equals(test)) {
                machine.testDrumBeat();
            }
        } catch (Exception e) {

        }

    }
}
