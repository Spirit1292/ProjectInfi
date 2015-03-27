package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Message
{
    public static Date Date = new Date( );
    public static SimpleDateFormat Time = new SimpleDateFormat ("hh:mm:ss");
    public static String TypeStr;
    public static String CategoryStr;
    public static String TerminalMessage;

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

        //ProgramLog(TerminalMessage);

        if (Category == 4)
        {
            JOptionPane.showMessageDialog(
                    null,
                    Message,
                    AppLang.Lang("MESSAGE_PROCEDURE_CLOSE_QUESTION_NAME"),
                    JOptionPane.ERROR_MESSAGE);
        }

        try
        {
            WindowMain.statusBar.setMessage(TerminalMessage);
            if (ProjectInfi.debugMode) WindowMain.debugLog.append(TerminalMessage);
            System.out.print(TerminalMessage);
        }
        catch (NullPointerException nex)
        {
            System.out.print(TerminalMessage);
        }

        if (ErrorMessage != null)
        {
            ErrorMessage.printStackTrace();
        }
    }

    public static void ProgramLog(String terminalMessage)
    {
        try
        {
            Logger log = Logger.getLogger(Message.class.getName());
            log.log(Level.ALL, terminalMessage);

            new Message().ShowMessage(1, 1, "Log saved", null);
        }
        catch (Exception ex)
        {
            System.out.println("Logging failed!!!");
        }
    }
}
