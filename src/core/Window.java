package core;

import core.tray.AppTrayIcon;
import listeners.WindowActionListeners;
import listeners.WindowListeners;
import reference.Reference;
import reference.TerminalMessages;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public JPanel panelMain;
    public JButton buttonOpenFolder;
    public JButton buttonExit;

    public static String textFieldValue;

    public Window()
    {
        super(Reference.WINDOW_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setContentPane(panelMain);

        setPreferredSize(new Dimension(400, 400));
        pack();
        setLocationRelativeTo(null);

        buttonOpenFolder.addActionListener(WindowActionListeners.openFolder);
        buttonExit.addActionListener(WindowActionListeners.exit);

        //buttonOpenFolder.setIcon((Icon) AppTrayIcon.image);

        addWindowListener(new WindowListeners());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_INFO +
                    TerminalMessages.TITLE_WINDOW_OPEN_MESSAGE);
            Window win = new Window();
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_WINDOW_OPEN_ERROR);
        }

    }

}
