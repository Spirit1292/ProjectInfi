package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.listeners.WindowLoginActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowLoginListeners;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import javax.swing.*;
import java.awt.*;

public class WindowLogin extends JFrame
{
    public static int windowWidth = 350;
    public static int windowHeight = 180;
    public static int fieldPasswordSize = 30;
    public static int fieldFolderLocationSize = 23;

    public static JTextField fieldPassword;
    public static JPanel panelMain;
    public static JPanel panelButtons;
    public static JLabel labelPassword;
    public static JButton buttonEnter;
    public static JButton buttonExit;

    public static JLabel labelFolderLocation;
    public static JTextField fieldFolderLocation;
    public static JButton buttonFolderLocation;

    public WindowLogin()
    {
        super();
        setTitle(AppLang.Lang("WINDOW_LOGIN_NAME"));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setFont(new Font(ProjectInfi.fontName, Font.PLAIN, ProjectInfi.fontSize));
        setResizable(false);
        setIconImage(new ImageIcon(Reference.APP_ICON_LOCATION + Reference.APP_ICON_NAME).getImage());

        try
        {
            fieldPassword = new JPasswordField(fieldPasswordSize);
            panelMain = new JPanel(new FlowLayout());
            panelButtons = new JPanel(new FlowLayout());
            labelPassword = new JLabel(AppLang.Lang("WINDOW_LOGIN_LABEL_PASSWORD_NAME"));
            buttonEnter = new JButton(AppLang.Lang("WINDOW_LOGIN_BUTTON_ENTER_NAME"));
            buttonExit = new JButton(AppLang.Lang("WINDOW_LOGIN_BUTTON_EXIT_NAME"));
            labelFolderLocation = new JLabel("Select folder destination");
            fieldFolderLocation = new JTextField(fieldFolderLocationSize);
            buttonFolderLocation = new JButton("Select");
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_LOGIN_CREATE_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_CREATE_ITEMS_ERROR"), ex);
        }

        try
        {
            fieldFolderLocation.setText(String.valueOf(ProjectInfi.folderDestination));
            fieldFolderLocation.setEditable(false);
            buttonFolderLocation.setEnabled(false);

            buttonEnter.setContentAreaFilled(false);
            buttonExit.setContentAreaFilled(false);

            panelMain.add(labelPassword, BorderLayout.NORTH);
            panelMain.add(fieldPassword, BorderLayout.AFTER_LINE_ENDS);
            panelMain.add(labelFolderLocation, BorderLayout.NORTH);
            panelMain.add(fieldFolderLocation,BorderLayout.AFTER_LINE_ENDS);
            panelMain.add(buttonFolderLocation, BorderLayout.BEFORE_LINE_BEGINS);
            add(panelMain, BorderLayout.CENTER);

            panelButtons.add(buttonEnter);
            panelButtons.add(Box.createHorizontalStrut(15));
            panelButtons.add(new JSeparator(SwingConstants.VERTICAL));
            panelButtons.add(Box.createHorizontalStrut(15));
            panelButtons.add(buttonExit);
            add(panelButtons, BorderLayout.SOUTH);

            pack();
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_ITEMS_ERROR"), ex);
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
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_ACTION_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_ACTION_LISTENERS_ERROR"), ex);
        }
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowLoginListeners());
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_WINDOW_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ADD_WINDOW_LISTENERS_ERROR"), ex);
        }
    }

    public static void main(String[] args) throws Exception
    {
        try
        {
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_WINDOW_LOGIN_OPEN_MESSAGE"), null);
            new WindowLogin();
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_OPEN_ERROR"), ex);
        }
    }
}
