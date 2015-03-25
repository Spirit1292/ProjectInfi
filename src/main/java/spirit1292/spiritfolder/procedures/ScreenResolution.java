package main.java.spirit1292.spiritfolder.procedures;

import java.awt.*;

public class ScreenResolution
{
    public static int horizontalSizeString;
    public static int verticalSizeString;

    public static int GetHorizontalRes()
    {
        horizontalSizeString = Toolkit.getDefaultToolkit().getScreenSize().width;
        return horizontalSizeString;
    }

    public static int GetVerticalRes()
    {
        verticalSizeString = Toolkit.getDefaultToolkit().getScreenSize().height;
        return verticalSizeString;
    }

    public static String ScreenResString()
    {
        return "Screen resolution: " + GetHorizontalRes() + ":" + GetVerticalRes();
    }
}
