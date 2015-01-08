package listeners;

import core.tray.AppTrayIcon;
import reference.TerminalMessages;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TrayMouseListeners extends MouseAdapter
{
    private static int counter;

    public static int counter()
    {
        counter = counter + 1;
        return counter;
    }

    public static void main(String[] args)
    {
        AppTrayIcon.trayMouseListener = new MouseListener()
        {
            public void mouseClicked(MouseEvent e)
            {
                String counterString = String.valueOf(counter()) + ")";
                System.out.println(counterString +
                        TerminalMessages.MESSAGE_TRAY +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_MOUSE_CLICKED);
            }

            public void mouseEntered(MouseEvent e)
            {
                String counterString = String.valueOf(counter()) + ")";
                System.out.println(counterString +
                        TerminalMessages.MESSAGE_TRAY +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_MOUSE_ENTERED);
            }

            public void mouseExited(MouseEvent e)
            {
                String counterString = String.valueOf(counter()) + ")";
                System.out.println(counterString +
                        TerminalMessages.MESSAGE_TRAY +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_MOUSE_EXITED);
            }

            public void mousePressed(MouseEvent e)
            {
                String counterString = String.valueOf(counter()) + ")";
                System.out.println(counterString +
                        TerminalMessages.MESSAGE_TRAY +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_MOUSE_PRESSED);
            }

            public void mouseReleased(MouseEvent e)
            {
                String counterString = String.valueOf(counter()) + ")";
                System.out.println(counterString +
                        TerminalMessages.MESSAGE_TRAY +
                        TerminalMessages.MESSAGE_INFO +
                        TerminalMessages.TITLE_MOUSE_RELEASED);
            }
        };
    }
}
