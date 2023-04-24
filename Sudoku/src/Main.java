import constant.Constants;
import sound.Sound;

import javax.swing.UIManager;

/**
 * Execution of SUDOKU starts from here;
*/

public class Main {
    public static void main(String[] args) throws Exception {

        // setting sound file
        Sound.setFile(Constants.BUTTON_SOUND);

        // I have defined a LOOK AND FEEL which is used here;
        UIManager.setLookAndFeel(Constants.WINDOWS_CLASSIC_LOOK_AND_FEEL);
        Start st = new Start();
    }
}
