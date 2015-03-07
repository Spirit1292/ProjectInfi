package main.java.spirit1292.spiritfolder.settings;

import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

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
                new Message().ShowMessage(1, 1, TerminalMessages.TITLE_LOOKANDFEEL_INSTALL_MESSAGE +
                        UIManager.getLookAndFeel().getName(), false);
            }
            else
            {
                new Message().ShowMessage(1, 2, TerminalMessages.TITLE_LOOKANDFEEL_IS_INSTALL +
                        UIManager.getLookAndFeel().getName(), false);
            }
        }
        catch (UnsupportedLookAndFeelException ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_LOOKANDFEEL_ERROR_UNSUPPORTED, true);
            new Message().ShowMessage(1, 2, TerminalMessages.TITLE_LOOKANDFEEL_CURRENT +
                    UIManager.getLookAndFeel().getDescription(), false);
        }
        catch (ClassNotFoundException ex)
        {
            // handle exception
        }
        catch (InstantiationException ex)
        {
            // handle exception
        }
        catch (IllegalAccessException ex)
        {
            // handle exception
        }
    }
}
