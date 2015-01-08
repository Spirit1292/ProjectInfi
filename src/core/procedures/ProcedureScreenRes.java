package core.procedures;

import javax.swing.*;
import java.awt.*;

public class ProcedureScreenRes
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
                String.valueOf(new ProcedureScreenRes().GetHorizontalRes());
        String VerticalSizeString =
                String.valueOf(new ProcedureScreenRes().GetVerticalRes());

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
