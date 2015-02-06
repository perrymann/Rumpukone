/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrumMachine.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author pnikande
 */
public class UI implements Runnable {

    private JFrame frame;
    private  ArrayList<JCheckBox> checkboxList;

    public UI() {
    }
    
    @Override
    public void run() {
        frame = new JFrame("Drum Machine");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        createComponents (frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createComponents(Container container) {
        container.add(splitScreen());
        
        
    }
    
    private JPanel splitScreen() {
        JPanel panel =  new JPanel(new GridLayout(3, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Tähän jotakin"));
        panel.add(new JLabel("Tähänkin jotakin"));
        panel.add(addGrids());
        
        return panel;
    }
    
    public JPanel addGrids() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        checkboxList = new ArrayList<>();
        Box instrumentNameBox = new Box(BoxLayout.Y_AXIS);
        Box buttonBox = new Box(BoxLayout.Y_AXIS);
        
        instrumentNameBox.add(new JLabel("Crash"));
        instrumentNameBox.add(new JLabel("Hi hat"));
        instrumentNameBox.add(new JLabel("Snare"));
        instrumentNameBox.add(new JLabel("Bass Drum"));
        panel.add(BorderLayout.EAST, buttonBox);
        panel.add(BorderLayout.WEST, instrumentNameBox);
        
        panel.add(BorderLayout.CENTER, createGrids());
        
        
        return panel;
    }
    
    
    private JPanel createGrids() {
        GridLayout grid = new GridLayout(4,16);
        grid.setVgap(1);
        grid.setHgap(2);
        JPanel panel = new JPanel(grid);
        
        for (int i = 0; i < 4; i++) {
            for (int x = 0; x < 16; x++) {
                JCheckBox c = new JCheckBox();
                c.setSelected(false);
                checkboxList.add(c);
                panel.add(c); 
            }
        }
            return panel;
    }
        
    
}
