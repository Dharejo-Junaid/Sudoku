import components.MyButton;
import components.MyLabel;
import constant.Constants;

import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

class Start extends JFrame {

    private MyButton play, exit;

    Start() {

        this.setTitle("Sudoku Game");
        this.setIconImage(Constants.sudokuLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Constants.bgColor);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(15, 0, 15, 0);

        // Heading Label
        MyLabel heading = new MyLabel("Sudoku Game", Constants.headingFont80);
        this.add(heading, c);

        // Play Button;
        play = new MyButton("Play", Constants.buttonFont30, Constants.indexPageButtonSize, this::playAction);
        c.gridy=1;
        this.add(play, c);

        // Exit Button;
        exit = new MyButton("Exit", Constants.buttonFont30, Constants.indexPageButtonSize, this::exitAction);
        c.gridy=2;
        this.add(exit, c);

        this.setVisible(true);
    }

    public void playAction(ActionEvent e) {
        this.dispose();
        new Levels();
    }

    public void exitAction(ActionEvent e) {
        System.exit(0);
    }
}