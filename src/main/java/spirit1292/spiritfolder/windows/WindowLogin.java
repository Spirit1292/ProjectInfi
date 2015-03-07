package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.listeners.WindowLoginActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowLoginListeners;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import javax.swing.*;
import java.awt.*;

public class WindowLogin extends JFrame
{
    public static JTextField textFieldPassword;
    public static JPanel panelMain;
    public static JPanel panelButtons;
    public static JLabel labelPassword;
    public static JButton buttonEnter;
    public static JButton buttonExit;

    public WindowLogin()
    {
        super(Reference.APP_NAME + ": " + Names.WINDOWLOGIN_NAME);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(Reference.APP_ICON_LOCATION + Reference.APP_ICON_NAME).getImage());

        try
        {
            textFieldPassword = new JTextField(20);
            panelMain = new JPanel(new FlowLayout());
            panelButtons = new JPanel(new FlowLayout());
            labelPassword = new JLabel(Names.WINDOWLOGIN_LABEL_PASSWORD_NAME);
            buttonEnter = new JButton(Names.WINDOWLOGIN_BUTTON_ENTER_NAME);
            buttonExit = new JButton(Names.WINDOWLOGIN_BUTTON_EXIT_NAME);
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWLOGIN_INIT_CREATEITEMS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_INIT_CREATEITEMS_ERROR, true);
        }

        try
        {
            panelMain.add(labelPassword, BorderLayout.WEST);
            panelMain.add(textFieldPassword);
            panelButtons.add(buttonEnter);
            panelButtons.add(buttonExit);
            add(panelMain, BorderLayout.NORTH);
            add(panelButtons, BorderLayout.SOUTH);
            pack();
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDITEMS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDITEMS_ERROR, true);
        }

        ActionListeners();
        WindowListeners();

        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void ActionListeners()
    {
        try
        {
            buttonEnter.addActionListener(WindowLoginActionListeners.enter);
            buttonExit.addActionListener(WindowLoginActionListeners.exit);
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDACTIONLISTENERS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDACTIONLISTENERS_ERROR, true);
        }
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowLoginListeners());
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDWINDOWLISTENERS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_INIT_ADDWINDOWLISTENERS_ERROR, true);
        }
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            new Message().ShowMessage(1, 2, TerminalMessages.TITLE_WINDOWLOGIN_OPEN_MESSAGE, false);
            new WindowLogin();
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_OPEN_ERROR, true);
        }
    }
}
