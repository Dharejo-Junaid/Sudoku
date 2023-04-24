import components.MyButton;
import components.MyLabel;
import constant.Constants;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class Levels extends JFrame {

    private MyButton easy, medium, hard,back;

    Levels() {

        this.setTitle("Levels");
        this.setIconImage(Constants.sudokuLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(600, 450));
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Constants.bgColor);

        // GridBagLayout;
        GridBagLayout bg = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(20, 0, 20, 0);
        this.setLayout(bg);

        // Heading Label;
        MyLabel heading = new MyLabel("Levels", Constants.headingFont80);
        this.add(heading, c);

        easy = new MyButton("Easy", Constants.buttonFont16, Constants.levelButtonSize, this::setEasy);
        c.gridy = 1;
        this.add(easy, c);

        medium = new MyButton("Medium", Constants.buttonFont16, Constants.levelButtonSize, this::setMedium);
        c.gridy = 2;
        this.add(medium, c);

        hard = new MyButton("Hard", Constants.buttonFont16, Constants.levelButtonSize, this::setHard);
        c.gridy = 3;
        this.add(hard, c);

        back=new MyButton("Back", Constants.buttonFont16, new Dimension(120,30), this::setBack);
        c.gridy++;
        this.add(back,c);

        this.setVisible(true);

    }

    public void setEasy(ActionEvent e) {
        this.dispose();
        new Board(Constants.EASY_LEVEL);
    }

    public void setMedium(ActionEvent e) {
        this.dispose();
        new Board(Constants.MEDIUM_LEVEL);
    }

    public void setHard(ActionEvent e) {
        this.dispose();
        new Board(Constants.HARD_LEVEL);
    }

    public void setBack(ActionEvent e){
        this.dispose();
        new Start();
    }
}
