package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Message
{
    Date Date = new Date( );
    SimpleDateFormat Time = new SimpleDateFormat ("hh:mm:ss");
    String TypeStr;
    String CategoryStr;
    String TerminalMessage;

    public void ShowMessage(int Type, int Category, String Message, boolean ShowErrorMessage)
    {
        switch (Type)
        {
            case 1: {TypeStr = TerminalMessages.MESSAGE_SYSTEM; break;}
            case 2: {TypeStr = TerminalMessages.MESSAGE_WINDOW; break;}
            default: {System.out.println(TerminalMessages.TITLE_MESSAGE_INDEX_ERROR);}
        }

        switch (Category)
        {
            case 1: {CategoryStr = TerminalMessages.MESSAGE_DONE; break;}
            case 2: {CategoryStr = TerminalMessages.MESSAGE_INFO; break;}
            case 3: {CategoryStr = TerminalMessages.MESSAGE_WARN; break;}
            case 4: {CategoryStr = TerminalMessages.MESSAGE_ERROR; break;}
            default: {System.out.println(TerminalMessages.TITLE_MESSAGE_INDEX_ERROR);}
        }

        TerminalMessage = Time.format(Date) + " " + TypeStr + CategoryStr + Message;
        if (Category == 4)
        {
            JOptionPane.showMessageDialog(
                    null,
                    Message,
                    TerminalMessages.TITLE_PROCEDURE_CLOSE_QUESTION_TITLE,
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(TerminalMessage);
            if (ShowErrorMessage)
            {
                throw new Error();
            }
        }
        else
        {
            System.out.println(TerminalMessage);
        }
    }
}
