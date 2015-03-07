package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.windows.WindowLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WindowLoginActionListeners extends WindowLogin
{
    static String passwordProgram;
    static String passwordInput;

    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
            passwordProgram = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_PASSWORD_TITLE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static ActionListener enter = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                LoadConfig();
                passwordInput = WindowLogin.textFieldPassword.getText();

                if (passwordInput.equals(passwordProgram))
                {
                    new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWLOGIN_PASSWORD_MATCH_YES , false);
                    WindowLogin.textFieldPassword.setText(null);
                    ProjectInfi.windowLogin.setVisible(false);
                    ProjectInfi.windowMain.setVisible(true);
                }
                else
                {
                    new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_PASSWORD_MATCH_NO, false);
                }
            }
            catch (Exception f)
            {
                new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWLOGIN_ACTION_ENTER_ERROR, true);
            }
        }
    };

    public static ActionListener exit = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Close.main(null);
        }
    };
}
