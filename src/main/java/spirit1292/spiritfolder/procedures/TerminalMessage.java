package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;

public class TerminalMessage
{
    String TypeStr;
    String CategoryStr;
    String TerminalMessage;

    public void ShowMessage(int Type, int Category, String Message)
    {
        switch (Type)
        {
            case 1:
            {
                TypeStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_SYSTEM;
                break;
            }
            case 2:
            {
                TypeStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_WINDOW;
                break;
            }
            default:
            {
                System.out.println("Invalid message index!!!");
            }
        }

        switch (Category)
        {
            case 1:
            {
                CategoryStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_DONE;
                break;
            }
            case 2:
            {
                CategoryStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_INFO;
                break;
            }
            case 3:
            {
                CategoryStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_WARN;
                break;
            }
            case 4:
            {
                CategoryStr = main.java.spirit1292.spiritfolder.reference.TerminalMessages.MESSAGE_ERROR;
                break;
            }
            default:
            {
                System.out.println("Invalid message index!!!");
            }
        }

        TerminalMessage = TypeStr + CategoryStr + Message;

        if (Category == 4)
        {
            JOptionPane.showMessageDialog(
                    null,
                    Message,
                    TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(TerminalMessage);
        }
        else System.out.println(TerminalMessage);
    }
}
