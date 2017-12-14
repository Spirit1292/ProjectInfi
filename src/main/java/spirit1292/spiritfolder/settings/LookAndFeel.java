package main.java.spirit1292.spiritfolder.settings;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Reference;

import javax.swing.*;

public class LookAndFeel
{
    public static void main(String[] args)
    {
        try
        {
            if (Reference.LOOKANDFEEL_SHORT_JAVA.equals(UIManager.getLookAndFeel().getName()))
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_LOOKANDFEEL_INSTALL_DONE") + " " +
                        UIManager.getLookAndFeel().getName(), null);
            }
            else
            {
                if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_LOOKANDFEEL_INSTALL_CANCEL") + " " +
                        UIManager.getLookAndFeel().getName(), null);
            }
        }

        catch (UnsupportedLookAndFeelException ulafex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_LOOKANDFEEL_ERROR_UNSUPPORTED"), null);
            new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_LOOKANDFEEL_CURRENT") + " " +
                    UIManager.getLookAndFeel().getDescription(), ulafex);
        }

        catch (IllegalAccessException iaex)
        {
            // handle exception
        }

        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_LOOKANDFEEL_ERROR"), ex);
        }
    }
}
