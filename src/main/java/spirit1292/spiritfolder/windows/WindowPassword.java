package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.listeners.WindowPasswordActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowPasswordListeners;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import javax.swing.*;
import java.awt.*;

public class WindowPassword extends JFrame
{
    public static JPanel panelButtons;
    public static JButton buttonChangePassword;
    public static JButton buttonCancel;

    public static JPanel panelFields;
    public static JTextField fieldCurrentPassword;
    public static JTextField fieldNewPassword;
    public static JTextField fieldNewPasswordConfirm;

    public WindowPassword()
    {
        super();
        setTitle(AppLang.Lang("WINDOW_PASSWORD_NAME"));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new Font(ProjectInfi.fontName, Font.PLAIN, ProjectInfi.fontSize));
        setResizable(false);
        setIconImage(new ImageIcon(Reference.APP_ICON_LOCATION + Reference.APP_ICON_NAME).getImage());

        try
        {
            panelButtons = new JPanel(new FlowLayout());
            panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            buttonChangePassword = new JButton();
            buttonCancel = new JButton(AppLang.Lang("WINDOW_PASSWORD_BUTTON_CANCEL_NAME"));

            fieldCurrentPassword = new JPasswordField();
            fieldNewPassword = new JPasswordField();
            fieldNewPasswordConfirm = new JPasswordField();

            panelFields = new JPanel()
            {
                public Dimension getMaximumSize()
                {
                    Dimension pref = getPreferredSize();
                    return new Dimension(Integer.MAX_VALUE, pref.height);
                }
            };
            panelFields.setLayout(new BoxLayout(panelFields, BoxLayout.PAGE_AXIS));
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_CREATE_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_CREATE_ITEMS_ERROR"), ex);
        }

        try
        {
            if (ProjectInfi.passwordProgram == null)
            {
                setPreferredSize(new Dimension(380, 130));
                buttonChangePassword.setText(AppLang.Lang("WINDOW_PASSWORD_BUTTON_PASSWORD_CREATE_NAME"));
            }
            else
            {
                setPreferredSize(new Dimension(380, 160));
                buttonChangePassword.setText(AppLang.Lang("WINDOW_PASSWORD_BUTTON_PASSWORD_CHANGE_NAME"));
                        panelFields.add(fieldCurrentPassword, new BoxLayout(this, BoxLayout.LINE_AXIS));
                panelFields.add(Box.createHorizontalStrut(5));
            }
            
            buttonChangePassword.setContentAreaFilled(false);
            buttonCancel.setContentAreaFilled(false);
            
            panelFields.add(fieldNewPassword, new BoxLayout(this, BoxLayout.LINE_AXIS));
            panelFields.add(Box.createHorizontalStrut(5));
            panelFields.add(fieldNewPasswordConfirm, new BoxLayout(this, BoxLayout.LINE_AXIS));
            panelFields.add(Box.createHorizontalStrut(5));
            add(panelFields);

            panelButtons.add(buttonChangePassword);
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(new JSeparator(SwingConstants.VERTICAL));
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(buttonCancel);
            add(panelButtons, BorderLayout.SOUTH);

            pack();
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_ITEMS_ERROR"), ex);
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
            buttonChangePassword.addActionListener(WindowPasswordActionListeners.changePassword);
            buttonCancel.addActionListener(WindowPasswordActionListeners.exit);
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_ACTION_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_ACTION_LISTENERS_ERROR"), ex);
        }
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowPasswordListeners());
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_WINDOW_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ADD_WINDOW_LISTENERS_ERROR"), ex);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_PASSWORD_OPEN_MESSAGE"), null);
            new WindowPassword();
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4 ,AppLang.Lang("MESSAGE_WINDOW_PASSWORD_OPEN_ERROR"), ex);
        }
    }
}
