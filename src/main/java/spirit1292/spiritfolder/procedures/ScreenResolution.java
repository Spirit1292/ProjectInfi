package main.java.spirit1292.spiritfolder.procedures;

import javax.swing.*;
import java.awt.*;

public class ScreenResolution
{
    Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();

    public int GetHorizontalRes()
    {
        return(ScreenSize.width);
    }

    public int GetVerticalRes()
    {
        return(ScreenSize.height);
    }

    public static void ShowScreenRes()
    {
        String HorizontalSizeString =
                String.valueOf(new ScreenResolution().GetHorizontalRes());
        String VerticalSizeString =
                String.valueOf(new ScreenResolution().GetVerticalRes());

        JOptionPane.showMessageDialog(
                null,
                "Information about Screen Resolution:\n"
                + "Width of Screen: " + HorizontalSizeString + "\n"
                + "Height of Screen: " + VerticalSizeString,
                "Program Message",
                JOptionPane.DEFAULT_OPTION );
    }

    public static void main(String[] args)
    {

    }
}
