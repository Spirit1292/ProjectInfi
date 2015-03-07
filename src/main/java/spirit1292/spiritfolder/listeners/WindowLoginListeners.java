package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class WindowLoginListeners implements WindowListener
{
    public boolean DebugMode;

    public void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
            DebugMode = AppConfig.getBoolean(Names.SETTING_SPIRITFOLDER_DEBUG_TITLE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_OPENED, false);
        }
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_CLOSING, false);
        }
        Close.main(null);
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_CLOSED, false);
        }
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_ICONFIED, false);
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_DEICONFIED, false);
        }
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_ACTIVATED, false);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        LoadConfig();
        if (DebugMode)
        {
            new Message().ShowMessage(2, 2, TerminalMessages.TITLE_WINDOWLOGIN_DEACTIVATED, false);
        }
    }
}
