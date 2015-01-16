package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListeners implements WindowListener
{
    @Override
    public void windowOpened(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_OPENED);
    }

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_CLOSING);
    }

    @Override
    public void windowClosed(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_CLOSED);
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_ICONFIED);
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_DEICONFIED);
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_ACTIVATED);
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println(TerminalMessages.MESSAGE_WINDOW + TerminalMessages.MESSAGE_INFO
                + TerminalMessages.TITLE_WINDOW_DEACTIVATED);
    }
}
