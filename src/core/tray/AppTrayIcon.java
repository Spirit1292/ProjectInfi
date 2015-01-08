package core.tray;

import core.Window;
import listeners.TrayActionListeners;
import listeners.TrayMouseListeners;
import reference.Reference;
import reference.TerminalMessages;
import settings.LookAndFeel;

import java.awt.*;
import java.awt.event.MouseListener;

public class AppTrayIcon
{
    Image image = Toolkit.getDefaultToolkit().getImage(Reference.ICON_PNG_DESTINATION);

    public static MenuItem messageItem;
    public static MenuItem lookAndFeelItem;
    public static MenuItem closeItem;
    public static MouseListener trayMouseListener;

    public static void WindowRun()
    {
        LookAndFeel.main(null);
        Window.main(null);
    }

    public void TrayRun()
    {
        if (!SystemTray.isSupported())
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_WARN +
                    TerminalMessages.TITLE_TRAY_IS_NOT_SUPPORTED);
            WindowRun();
        }
        else
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_INFO +
                    TerminalMessages.TITLE_TRAY_IS_SUPPORTED);
        }

        final PopupMenu menu = new PopupMenu();
        messageItem = new MenuItem(Reference.TRAY_MENU_WINDOW);
        lookAndFeelItem = new MenuItem(Reference.TRAY_MENU_LOOKANDFEEL);
        closeItem = new MenuItem(Reference.TRAY_MENU_EXIT);
        TrayActionListeners.main(null);
        TrayMouseListeners.main(null);
        menu.add(messageItem);
        menu.add(lookAndFeelItem);
        menu.add(closeItem);

        try
        {
            LookAndFeel.main(null);

            SystemTray tray = SystemTray.getSystemTray();
            TrayIcon icon = new TrayIcon(image, Reference.APPLICATION_NAME, menu);
            icon.setImageAutoSize(true);
            icon.addMouseListener(trayMouseListener);
            tray.add(icon);
            icon.displayMessage(Reference.APPLICATION_NAME, TerminalMessages.TITLE_TRAY_RUN_MESSAGE,
                    java.awt.TrayIcon.MessageType.INFO);
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_DONE +
                    TerminalMessages.TITLE_TRAY_CREATE_DONE);
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_TRAY_CREATE_ERROR);
            WindowRun();
        }
    }

    public static void main(String[] args)
    {
        new AppTrayIcon().TrayRun();
    }
}