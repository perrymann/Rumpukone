
package DrumMachine.ui;

import DrumMachine.domain.Machine;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author pnikande
 * 
 * Graafinen käyttöliittymä-luokka, jossa luodaan käyttöliittymän komponentit.
 * 
 */
public class UI implements Runnable {

    Machine machine;
    private JFrame frame;
    private ArrayList<JCheckBox> checkboxList;
    private int gridLength = 24;

    public UI(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        frame = new JFrame("Drum Machine");
        frame.setPreferredSize(new Dimension(1200, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void setGridLength(int length) {
        this.gridLength = length;
    }

    private void createComponents(Container container) {
        container.add(splitScreen(container));

    }

    /**
     * Metodi jakaa ruudun kahteen osaan.
     * 
     * @param container
     * @return JPanel
     */
    
    private JPanel splitScreen(Container container) {
        JPanel panel = new JPanel(new GridLayout(2, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(buttonGrid1());
        panel.add(drumGrids());

        return panel;
    }
    
    /**
     * Metodi luo ruudun alaosan.
     * @return JPanel
     */

    public JPanel drumGrids() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder("Iskujen määritys"));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(gridbag);
        GridLayout instrumentNameBox = new GridLayout(5, 1);
        instrumentNameBox.setVgap(7);

        JPanel p = new JPanel(instrumentNameBox);
        p.add(new JLabel("Bass Drum"));
        p.add(new JLabel("Open Hi hat"));
        p.add(new JLabel("Snare"));
        p.add(new JLabel("Hi hat"));
        p.add(new JLabel("Ghost"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        panel.add(p, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        panel.add(createGrids(), c);

        return panel;
    }
    
    /**
     * Metodi luo rumpujen iskujen kentän.
     * @return Jpanel
     */
    
    private JPanel createGrids() {
        GridLayout grid = new GridLayout(5, gridLength);
        grid.setVgap(1);
        grid.setHgap(2);
        JPanel panel = new JPanel(grid);

        for (int i = 0; i < 5; i++) {
            for (int x = 0; x < gridLength; x++) {
                JCheckBox c = new JCheckBox();
                c.setEnabled(true);
                c.addItemListener(new DrumHitListener(i, x, machine));
                panel.add(c);
            }
        }
        return panel;
    }
    
    /**
     * Metodi jakaa ruudun yläosan kahteen osaan.
     * @return JPanel
     */
    
    private JPanel buttonGrid1() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(operatorButtons1());
        panel.add(operatorButtons2());

        return panel;
    }

    /**
     * Metodi määrittelee ruudun yläosan vasemmanpuoleisen osan komponentit ja määrittää niille kuuntelijaolion.
     * @return JPanel
     */
    
    private JPanel operatorButtons1() {
        JPanel panel = new JPanel(new GridLayout(5, 3));
        panel.setBorder(BorderFactory.createTitledBorder("Kompin alustus"));

        JButton newSongButton = new JButton("Uusi kappale");
        JButton newBeatButton = new JButton("OK");
        JLabel hits = new JLabel("Iskut (1-24):", SwingConstants.CENTER);
        JTextField tf = new JTextField();
        JButton submit = new JButton("Tallenna");
        JButton testBeat = new JButton("Testaa");
        JLabel looptext = new JLabel("Toistokerrat (1->):", SwingConstants.CENTER);
        JTextField lf = new JTextField();
        JLabel tempoText = new JLabel("Tempo:", SwingConstants.CENTER);
        JTextField tempoField = new JTextField();
        JButton addToSong = new JButton("Lisää kappaleeseen");
        JButton listenSong = new JButton("Kuuntele!");

        ButtonListener x = new ButtonListener(machine, newSongButton, tf, newBeatButton, submit,
                testBeat, lf, tempoField, addToSong, listenSong);
        newSongButton.addActionListener(x);
        newBeatButton.addActionListener(x);
        submit.addActionListener(x);
        testBeat.addActionListener(x);
        addToSong.addActionListener(x);
        listenSong.addActionListener(x);

        panel.add(newSongButton);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(hits);
        panel.add(tf);
        panel.add(new JLabel(""));
        panel.add(tempoText);
        panel.add(tempoField);
        panel.add(newBeatButton);
        panel.add(looptext);
        panel.add(lf);
        panel.add(submit);
        panel.add(testBeat);
        panel.add(addToSong);
        panel.add(listenSong);

        return panel;
    }
    
    /**
     * Metodi määrittelee ruudun yläosan oikeanpuoleisen osan komponentit ja määrittää niille kuuntelijaolion.
     * @return JPanel
     */
    
    private JPanel operatorButtons2() {
        JPanel panel = new JPanel(new GridLayout(5, 3));
        panel.setBorder(BorderFactory.createTitledBorder("Tiedostojen hallinta"));

        JLabel saveText = new JLabel("Tallenna nimellä:", SwingConstants.CENTER);
        JTextField name = new JTextField();
        JButton save = new JButton("OK");
        JLabel playText = new JLabel("Toista tiedosto:", SwingConstants.CENTER);
        JTextField songName = new JTextField();
        JButton play = new JButton("OK");

        ButtonListener x = new ButtonListener(machine, name, save, songName, play);

        save.addActionListener(x);
        play.addActionListener(x);

        panel.add(saveText);
        panel.add(name);
        panel.add(save);
        panel.add(playText);
        panel.add(songName);
        panel.add(play);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));

        return panel;
    }

}
