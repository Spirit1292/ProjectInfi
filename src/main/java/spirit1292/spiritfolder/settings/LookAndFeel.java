package main.java.spirit1292.spiritfolder.settings;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;

public class LookAndFeel
{
    public static void main(String[] args)
    {
        try
        {
            if (Reference.LOOKANDFEEL_SHORT_JAVA == UIManager.getLookAndFeel().getName())
            {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                        TerminalMessages.MESSAGE_DONE +
                        TerminalMessages.TITLE_LOOKANDFEEL_INSTALL_MESSAGE +
                        UIManager.getLookAndFeel().getName());
            }
            else
            {
                System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_LOOKANDFEEL_IS_INSTALL +
                        UIManager.getLookAndFeel().getName());
            }
        }
        catch (UnsupportedLookAndFeelException e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_LOOKANDFEEL_ERROR_UNSUPPORTED);
            System.out.println(TerminalMessages.TITLE_LOOKANDFEEL_CURRENT +
                    UIManager.getLookAndFeel().getDescription());
        }
        catch (ClassNotFoundException e)
        {
            // handle exception
        }
        catch (InstantiationException e)
        {
            // handle exception
        }
        catch (IllegalAccessException e)
        {
            // handle exception
        }
    }
}
