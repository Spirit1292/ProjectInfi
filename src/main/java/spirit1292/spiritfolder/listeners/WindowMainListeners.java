package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowMainListeners implements WindowListener
{
    @Override
    public void windowOpened(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_OPENED"), null);
        }
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_CLOSING"), null);
        }
        Close.main(null);
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_CLOSED"), null);
        }
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_ICONFIED"), null);
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_DEICONFIED"), null);
        }
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_ACTIVATED"), null);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_DEACTIVATED"), null);
        }
    }
}
