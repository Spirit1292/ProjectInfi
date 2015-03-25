package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

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

    public void ShowMessage(int Type, int Category, String Message, Exception ErrorMessage)
    {
        switch (Type)
        {
            case 1: {TypeStr = AppLang.Lang("MESSAGE_SYSTEM"); break;}
            case 2: {TypeStr = AppLang.Lang("MESSAGE_WINDOW"); break;}
            default: {System.out.println(AppLang.Lang("MESSAGE_INDEX_ERROR"));}
        }

        switch (Category)
        {
            case 1: {CategoryStr = AppLang.Lang("MESSAGE_DONE"); break;}
            case 2: {CategoryStr = AppLang.Lang("MESSAGE_INFO"); break;}
            case 3: {CategoryStr = AppLang.Lang("MESSAGE_WARN"); break;}
            case 4: {CategoryStr = AppLang.Lang("MESSAGE_ERROR"); break;}
            default: {System.out.println(AppLang.Lang("MESSAGE_INDEX_ERROR"));}
        }

        TerminalMessage = Time.format(Date) + " " + TypeStr + " " +  CategoryStr  + " " + Message + "\n";

        if (Category == 4)
        {
            JOptionPane.showMessageDialog(
                    null,
                    Message,
                    AppLang.Lang("MESSAGE_PROCEDURE_CLOSE_QUESTION_NAME"),
                    JOptionPane.ERROR_MESSAGE);
            System.out.println(TerminalMessage);
        }
        else
        {
            try
            {
                WindowMain.statusBar.setMessage(TerminalMessage);
                WindowMain.debugLog.append(TerminalMessage);
                System.out.print(TerminalMessage);
            }
            catch (NullPointerException nex)
            {
                System.out.print(TerminalMessage);
            }
        }
        if (ErrorMessage != null)
        {
            ErrorMessage.printStackTrace();
        }
    }
}
