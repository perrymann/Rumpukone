package drummachine.ui;

import drummachine.domain.Machine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ButtonListener implements ActionListener {

    private Machine machine;
    private JButton newSong;
    private JTextField hitFieldLength;
    private JButton newBeat;
    private JButton submitBeat;
    private JButton test;
    private JTextField loopField;
    private JTextField tempoField;
    private JButton addToSong;
    private boolean beatOk = false;
    private boolean songOk = false;
    private JButton listenSong;
    private JTextField name;
    private JButton save;
    private JTextField songName;
    private JButton play;

    public ButtonListener(Machine machine, JButton newSong, JTextField hitFieldLength, JButton newBeat,
            JButton submitBeat, JButton test, JTextField loopField, JTextField tempoField, JButton addToSong,
            JButton listenSong) {
        this.machine = machine;
        this.hitFieldLength = hitFieldLength;
        this.newBeat = newBeat;
        this.submitBeat = submitBeat;
        this.test = test;
        this.loopField = loopField;
        this.tempoField = tempoField;
        this.newSong = newSong;
        this.addToSong = addToSong;
        this.listenSong = listenSong;
    }

    public ButtonListener(Machine machine, JTextField name, JButton save, JTextField songName, JButton play) {
        this.machine = machine;
        this.name = name;
        this.save = save;
        this.songName = songName;
        this.play = play;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource().equals(newSong)) {
            machine.createSong();
            songOk = true;
        }
        try {
            if (ae.getSource().equals(newBeat) && Integer.parseInt(tempoField.getText()) > 0 && Integer.parseInt(hitFieldLength.getText()) > 0) {
                int tempo = Integer.parseInt(tempoField.getText());
                int hits = Integer.parseInt(hitFieldLength.getText());
                machine.createDrumbeat(tempo);
                machine.createDrumPhrase(hits);
                machine.formatDrumPhrases();
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Määritä ensin iskujen määrä ja tempo ja klikkaa OK.",
                    "Virhe",
                    JOptionPane.PLAIN_MESSAGE);
        }

        try {
            if (ae.getSource().equals(submitBeat) && songOk) {
                if (machine.getDrumbeat() != null && !loopField.getText().isEmpty()) {
                    machine.finalizePhrases();
                    machine.addDrumPhrasesIntoDrumbeat();
                    int loop = Integer.parseInt(loopField.getText());
                    machine.defineLooping(loop);
                    machine.addDrumbeatIntoList();
                    beatOk = true;
                }
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Määritä iskujen määrä ja tempo ja klikkaa OK!\n"
                    + "Valitse iskut, määritä loopit ja klikkaa Tallenna!",
                    "Virhe",
                    JOptionPane.PLAIN_MESSAGE);
        }

        if (ae.getSource().equals(test)) {
            if (machine.getDrumbeat() != null && beatOk) {
                machine.testDrumBeat();
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Ei testattavaa komppia!",
                        "Virhe",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (ae.getSource().equals(addToSong)) {
            if (machine.getDrumbeat() != null && beatOk && songOk) {
                machine.finalizeSong();
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Tee rumpukomppi valmiiksi ennen lisäämistä!",
                        "Virhe",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (ae.getSource().equals(listenSong)) {
            if (songOk) {
                machine.playSong();
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Ei soitettavaa kappaletta!",
                        "Virhe",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (ae.getSource().equals(save)) {
            if (!name.getText().isEmpty()) {
                machine.writeFile(name.getText());
            } else {
                JOptionPane.showMessageDialog(new JFrame(),
                        "Ei tallennettavaa kappaletta!",
                        "Virhe",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (ae.getSource().equals(play)) {
            try {
                machine.playSong(songName.getText());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ButtonListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
