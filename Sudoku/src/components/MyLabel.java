package components;

import constant.Constants;

import javax.swing.JLabel;
import java.awt.Font;

public class MyLabel extends JLabel {

    public MyLabel(String text, Font font) {
        this.setText(text);
        this.setFont(font);
        this.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        this.setForeground(Constants.headingColor);
    }
}
