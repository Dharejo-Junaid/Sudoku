package components;

import constant.Constants;
import sound.Sound;

import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    ActionListener l;

    public MyButton(String text, Font font, Dimension buttonSize, ActionListener l) {
        this.setText(text);
        this.setFont(font);
        this.setForeground(Constants.buttonTextColor);
        this.setPreferredSize(buttonSize);
        this.addActionListener(this);
        this.setFocusable(false);

        this.l = l;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sound.play();
        l.actionPerformed(e);
    }
}
