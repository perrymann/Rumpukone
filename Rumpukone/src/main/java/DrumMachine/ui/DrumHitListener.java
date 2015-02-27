package DrumMachine.ui;

import DrumMachine.domain.Machine;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author pnikande
 * 
 * Luokassa luodaan DrumHitListener-olio, joka kuuntelee käyttöliittymän rumpuiskukenttien Checkbox-komponentteja.
 */

public class DrumHitListener implements ItemListener {

    private Machine machine;
    private int row;
    private int column;

    public DrumHitListener(int row, int column, Machine machine) {
        this.column = column;
        this.row = row;
        this.machine = machine;
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getStateChange() == ItemEvent.SELECTED) {
            machine.createHit(row, 8, row, column);
        } else {
            machine.createHit(-1, 8, row, column);
        }
    }
}
