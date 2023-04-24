import components.MyButton;
import components.MyLabel;
import components.MyTextField;
import constant.Constants;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.util.Random;

public class Board extends JFrame {

    private MyLabel heading;

    private JPanel mainGrid, smallGrids[][];
    private MyTextField textField[][];

    private JPanel leftButtonPanel;
    private MyButton check, newGame, changeLevel;

    private JPanel rightButtonPanel;
    private MyButton clear, back, quit;

    private GridBagConstraints c;

    private Random rd;
    private boolean booleanArray[][];
    private int integerArray[][];

    // (level) is selected level user selected;
    Board(int level){

        Constants.CURRENT_LEVEL = level;

        // rd to generate random (row, column and value)
        rd=new Random();

        // this is used to check weather cell is filled or not
        // TRUE = filled
        // FALSE = not filled
        booleanArray = new boolean[9][9];

        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 10;

        this.setTitle("Sudoku Board");
        this.setIconImage(Constants.sudokuLogo.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(1300, 700));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Constants.bgColor);
        this.setLayout(new GridBagLayout());

        // Adding all components;
        setHeading();
        setLeftSideButtons();
        setMainGrid();
        setRightSideButtons();

        this.setVisible(true);
    }

    public void setHeading() {
        heading = new MyLabel("Sudoku", Constants.headingFont40);
        c.gridx=0;  this.add(new JLabel(), c);
        c.gridx=1;  this.add(heading, c);
        c.gridx=2;  this.add(new JLabel());
    }

    public void setMainGrid() {

        // Outer 3x3 grid
        mainGrid = new JPanel();
        mainGrid.setPreferredSize(Constants.gridSize);
        mainGrid.setLayout(new GridLayout(3, 3, 10, 10));
        mainGrid.setBackground(Constants.transparent);

        // Inner 3x3 grid
        smallGrids = new JPanel[3][3];
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                smallGrids[i][j] = new JPanel(new GridLayout(3, 3, 5, 5));
                smallGrids[i][j].setBackground(Constants.transparent);
                mainGrid.add(smallGrids[i][j]);
            }
        }

        c.gridx=1;
        c.gridy=1;
        this.add(mainGrid, c);

        // All text fields;
        textField = new MyTextField[9][9];
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                textField[i][j] = new MyTextField();
                smallGrids[i/3][j/3].add(textField[i][j]);
            }
        }

        // setting values in text fields as per - selected level;
        setLevel();
    }

    public void setLeftSideButtons() {
        leftButtonPanel = new JPanel();
        leftButtonPanel.setLayout(new GridBagLayout());
        leftButtonPanel.setBackground(Constants.transparent);

        GridBagConstraints leftC=new GridBagConstraints();
        leftC.insets = new Insets(20, 0, 20, 100);

        check = new MyButton("Check",
                Constants.buttonFont16, Constants.mediumButtonSize, this::checkAction);
        leftC.gridy=0;
        leftButtonPanel.add(check, leftC);

        newGame = new MyButton("New Game",
                Constants.buttonFont16, Constants.mediumButtonSize, this::newGameAction);
        leftC.gridy=1;
        leftButtonPanel.add(newGame, leftC);

        changeLevel = new MyButton("Level",
                Constants.buttonFont16, Constants.mediumButtonSize, this::changeLevelAction);
        leftC.gridy=2;
        leftButtonPanel.add(changeLevel, leftC);

        c.gridx=0;
        c.gridy=1;
        this.add(leftButtonPanel, c);
    }

    public void setRightSideButtons() {
        rightButtonPanel = new JPanel();
        rightButtonPanel.setLayout(new GridBagLayout());
        rightButtonPanel.setBackground(Constants.transparent);

        GridBagConstraints rightC=new GridBagConstraints();
        rightC.insets = new Insets(20, 100, 20, 0);

        clear = new MyButton("Clear",
                Constants.buttonFont16, Constants.mediumButtonSize, this::clearAction);
        rightC.gridy=0;
        rightButtonPanel.add(clear, rightC);

        rightC.gridy=1;
        back = new MyButton("Back",
                Constants.buttonFont16, Constants.mediumButtonSize, this::backAction);
        rightButtonPanel.add(back, rightC);

        quit = new MyButton("Quit",
                Constants.buttonFont16, Constants.mediumButtonSize, this::quitAction);
        rightC.gridy=2;
        rightButtonPanel.add(quit, rightC);

        c.gridx=2;
        c.gridy=1;
        this.add(rightButtonPanel, c);
    }

    public void setLevel() {
        if(Constants.CURRENT_LEVEL == Constants.EASY_LEVEL) {
            placeValues(20);
        }

        else if(Constants.CURRENT_LEVEL == Constants.MEDIUM_LEVEL) {
            placeValues(15);
        }

        else if(Constants.CURRENT_LEVEL == Constants.HARD_LEVEL) {
            placeValues(10);
        }
    }

    public void placeValues(int count) {

        // this array has same values which text has;
        integerArray = new int[9][9];

        int i=0;
        while(i<count) {

            int row = rd.nextInt(0, 9);
            int col = rd.nextInt(0, 9);

            // while we get unfilled cell
            // booleanArray FALSE indicates unfilled index;
            while(booleanArray[row][col]) {
                row = rd.nextInt(0, 9);
                col = rd.nextInt(0, 9);
            }

            int value = rd.nextInt(1, 10);
            // while we get value which we can place on cell;
            while(! isSafe(row, col, value)) {
                value = rd.nextInt(1, 10);
            }

            booleanArray[row][col]=true;
            textField[row][col].setEditable(false);
            textField[row][col].setForeground(Constants.filledBoxTextColor);
            integerArray[row][col]=value;
            textField[row][col].setText(value + "");
            i++;
        }
    }

    public void checkAction(ActionEvent e) {

        // checking for is grid check filled and has only (1-9) chars;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {

                String text = textField[i][j].getText();

                // is cell not filled;
                if(text.length()==0) {
                    JOptionPane.showMessageDialog(this,
                            "Fill check grid", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // is cell improperly filled;
                int ch = text.charAt(0);
                if((text.length()>1) || (ch<'1' || ch>'9')) {
                    JOptionPane.showMessageDialog(this,
                            "You can only place (1-9) chars", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        // placing all values of grid into integerArray;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                integerArray[i][j] = Integer.parseInt(textField[i][j].getText());
            }
        }

        // checking win;
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(! isSafe(i, j, integerArray[i][j])) {
                    JOptionPane.showMessageDialog(this,
                            "You Lose", "You Lose", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        // display message if player wins;
        JOptionPane.showMessageDialog(this,
                "You WIN\nDo you wanna play again", "You Win", JOptionPane.PLAIN_MESSAGE);
        newGameAction(e);
    }

    public void newGameAction(ActionEvent e) {
        this.dispose();
        new Board(Constants.CURRENT_LEVEL);
    }

    public void changeLevelAction(ActionEvent e) {
        new ChangeLevel(this);

    }

    public void clearAction(ActionEvent e) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(textField[i][j].isEditable()) {
                    textField[i][j].setText("");
                }
            }
        }
    }

    public void backAction(ActionEvent e) {
        this.dispose();
        new Levels();
    }

    public void quitAction(ActionEvent e) {
        System.exit(0);
    }

    private boolean isSafe(int row, int col, int value) {

        int tfValue=0;

        //  for row & column;
        for(int i=0; i<9; i++) {

            if(integerArray[row][i] == value)
                return false;

            if(integerArray[i][col] == value)
                return false;
        }

        //  for 3x3 grid;
        int r=(row/3) * 3, c=(col/3) * 3;

        for(int i=r; i<r+3; i++) {
            for(int j=c; j<c+3; j++) {
                if(integerArray[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}