/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrumMachine.ui;

import DrumMachine.domain.Machine;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author pnikande
 */
public class UI implements Runnable {

    private Machine machine;
    private JFrame frame;
    private ArrayList<JCheckBox> checkboxList;
    private int gridLength = 16;

    public UI(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void run() {
        frame = new JFrame("Drum Machine");
        frame.setPreferredSize(new Dimension(900, 600));
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

    private JPanel splitScreen(Container container) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));
        panel.add(new JLabel("Tähän jotakin"));
        panel.add(operatorButtons());
        panel.add(drumGrids());

        return panel;
    }

    public JPanel drumGrids() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        panel.setLayout(gridbag);

        GridLayout instrumentNameBox = new GridLayout(4, 1);
        instrumentNameBox.setVgap(7);
        
        JPanel p = new JPanel(instrumentNameBox);
        p.add(new JLabel("Bass Drum"));
        p.add(new JLabel("Hi hat"));
        p.add(new JLabel("Snare"));
        p.add(new JLabel("Hi hat"));
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        panel.add(p, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        c.gridx = 1;
        panel.add(createGrids(), c);

        return panel;
    }
    
    private JPanel createGrids() {
        GridLayout grid = new GridLayout(4, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        JPanel panel = new JPanel(grid);
        
        
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < gridLength; x++) {
                JCheckBox c = new JCheckBox();
                c.setEnabled(true);
                c.addItemListener(new DrumHitListener(i, x, machine));
                panel.add(c);
            }
        }
        return panel;
    }
    
    private JPanel operatorButtons() {
        GridLayout layout = new GridLayout(5, 3);
        JPanel panel = new JPanel(layout);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));
       
        
        
        JButton newBeatButton= new JButton("Uusi rumpukomppi");
        JLabel hits = new JLabel("Iskut (1-16):");
        JTextField tf = new JTextField();
        JButton submit = new JButton("Tallenna komppi");
        JButton testBeat = new JButton("Testaa");
        JLabel looptext = new JLabel("Loopit:");
        JTextField lf = new JTextField();
        JButton loopButton = new JButton("Aseta looppaus");
        JLabel tempoText = new JLabel("Tempo:");
        JTextField tempoField = new JTextField();
        //JButton tempoSetter = new JButton("Aseta tempo");
       
        
        ButtonListener x = new ButtonListener(machine, tf, newBeatButton, submit, 
                testBeat, lf, loopButton, tempoField);
        newBeatButton.addActionListener(x);
        submit.addActionListener(x);
        testBeat.addActionListener(x);
        
        panel.add(hits);
        panel.add(looptext);
        panel.add(tempoText);
        
        panel.add(tf);
        panel.add(lf);
        panel.add(tempoField);
        
        panel.add(newBeatButton);
        
        
        
        panel.add(submit);
        panel.add(testBeat);
        
        return panel;
        
        // clear checkboxes...
    }

}

