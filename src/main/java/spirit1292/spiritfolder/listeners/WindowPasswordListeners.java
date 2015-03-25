package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowPassword;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowPasswordListeners implements WindowListener
{
    @Override
    public void windowOpened(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_OPENED"), null);
        }
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_CLOSING"), null);
                    ProjectInfi.windowPassword.setVisible(false);
            WindowPassword.fieldCurrentPassword.setText(null);
            WindowPassword.fieldNewPassword.setText(null);
            WindowPassword.fieldNewPasswordConfirm.setText(null);
        }
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_CLOSED"), null);
        }
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ICONFIED"), null);
        }
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_DEICONFIED"), null);
        }
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTIVATED"), null);
        }
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        if (ProjectInfi.debugMode)
        {
            new Message().ShowMessage(2, 2, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_DEACTIVATED"), null);
        }
    }
}
