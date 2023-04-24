package constant;

import fonts.ExternalFonts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.ImageIcon;

/*
    From here we can customize our SUDOKU;
    This class has all the variables you need to customize it;
*/

public class Constants {

    public static int CURRENT_LEVEL = 0;

    public static final int EASY_LEVEL = 0;
    public static final int MEDIUM_LEVEL = 1;
    public static final int HARD_LEVEL = 2;

    public static final String METAL_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
    public static final String NIMBUS_LOOK_AND_FEEL = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
    public static final String MOTIF_LOOK_AND_FEEL = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    public static final String WINDOWS_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    public static final String WINDOWS_CLASSIC_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

    public static final Color bgColor=new Color(15, 156, 123);
    public static final Color headingColor = new Color(255, 255, 255);
    public static final Color buttonTextColor = new Color(15, 156, 123);
    public static final Color transparent = new Color(0, 0, 0, 0);
    public static final Color filledBoxTextColor = Color.RED;

    public static final String jetBrainsFontPath = "src/fonts/JetBrainsMono.ttf";
    public static final String keniaFontPath = "src/fonts/Kenia.ttf";

    public static final Font buttonFont16 = ExternalFonts.getJetBrainsFont(16);
    public static final Font buttonFont30 = ExternalFonts.getJetBrainsFont(30);
    public static final Font textFieldFont20 = ExternalFonts.getJetBrainsFont(20);
    public static final Font headingFont40 = ExternalFonts.getKeniaFont(40);
    public static final Font headingFont80 = ExternalFonts.getKeniaFont(80);

    public static final Dimension mediumButtonSize = new Dimension(150, 30);
    public static final Dimension levelButtonSize = new Dimension(200, 50);
    public static final Dimension indexPageButtonSize = new Dimension(200, 50);
    public static final Dimension gridSize = new Dimension(550, 550);

    public static final ImageIcon sudokuLogo = new ImageIcon("image/sudoku_logo.png");
    public static final String BUTTON_SOUND = "src/sound/button_sound.wav";
}