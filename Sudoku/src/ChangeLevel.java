import components.MyButton;
import components.MyLabel;
import constant.Constants;

import javax.swing.JFrame;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

public class ChangeLevel extends JDialog {

    private JFrame parent;
    private MyButton easy, medium, hard;
    private GridBagConstraints c;

    /*
        Receiving Board Frame (parent);
        When Player change the level
        we dispose current board(parent)
        and open new board;
    */

    ChangeLevel(JFrame parent) {

        this.parent = parent;

        // GridBagLayout;
        c = new GridBagConstraints();
        c.insets = new Insets(10, 0, 10, 0);

        this.setTitle("Change Level");
        this.setIconImage(Constants.sudokuLogo.getImage());
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.getContentPane().setBackground(Constants.bgColor);
        this.setSize(400, 250);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridBagLayout());

        // Heading Label;
        MyLabel heading = new MyLabel("Levels", Constants.headingFont40);
        this.add(heading, c);

        c.insets = new Insets(5, 0, 5, 0);

        // Level Button(s);
        easy = new MyButton("Easy", Constants.buttonFont16, Constants.mediumButtonSize, this::setEasy);
        c.gridy = 1;
        this.add(easy, c);

        medium = new MyButton("Medium", Constants.buttonFont16, Constants.mediumButtonSize, this::setMedium);
        c.gridy = 2;
        this.add(medium, c);

        hard = new MyButton("Hard", Constants.buttonFont16, Constants.mediumButtonSize, this::setHard);
        c.gridy = 3;
        this.add(hard, c);

        this.setVisible(true);
    }

    public void setEasy(ActionEvent e) {
        this.dispose();

        if(Constants.CURRENT_LEVEL == Constants.EASY_LEVEL) {
            return;
        }

        this.parent.dispose();
        new Board(Constants.EASY_LEVEL);
    }

    public void setMedium(ActionEvent e) {
        this.dispose();

        if(Constants.CURRENT_LEVEL == Constants.MEDIUM_LEVEL) {
            return;
        }

        this.parent.dispose();
        new Board(Constants.MEDIUM_LEVEL);
    }

    public void setHard(ActionEvent e) {
        this.dispose();

        if(Constants.CURRENT_LEVEL == Constants.HARD_LEVEL) {
            return;
        }

        this.parent.dispose();
        new Board(Constants.HARD_LEVEL);
    }
}
