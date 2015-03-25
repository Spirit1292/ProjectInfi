package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowLoginActionListeners extends WindowLogin
{
    static String passwordInput;

    public static ActionListener enter = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                passwordInput = WindowLogin.fieldPassword.getText();

                if (passwordInput.equals(ProjectInfi.passwordProgram))
                {
                    new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_LOGIN_PASSWORD_MATCH_YES"), null);
                    WindowLogin.fieldPassword.setText(null);
                    ProjectInfi.windowLogin.setVisible(false);
                    ProjectInfi.windowMain.setVisible(true);
                }
                else
                {
                    new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_PASSWORD_MATCH_NO"), null);
                }
            }
            catch (Exception ex)
            {
                new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_LOGIN_ACTION_ENTER_ERROR"), ex);
            }
        }
    };

    public static ActionListener exit = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            Close.main(null);
        }
    };
}
