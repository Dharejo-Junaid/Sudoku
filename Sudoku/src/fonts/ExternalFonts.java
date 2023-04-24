package fonts;

import constant.Constants;

import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ExternalFonts {

    public static Font getJetBrainsFont(float fontSize) {
        try {
            return FontUIResource.createFont(Font.TRUETYPE_FONT,
                    new File(Constants.jetBrainsFontPath)).deriveFont(fontSize);
        }

        catch (FontFormatException e) {}
        catch (IOException e) {}

        return null;
    }

    public static Font getKeniaFont(float fontSize) {
        try {
            return FontUIResource.createFont(Font.TRUETYPE_FONT,
                    new File(Constants.keniaFontPath)).deriveFont(fontSize);
        }

        catch (FontFormatException e) {}
        catch (IOException e) {}

        return null;
    }
}
