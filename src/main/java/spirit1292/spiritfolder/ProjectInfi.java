package main.java.spirit1292.spiritfolder;

import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.settings.LookAndFeel;
import main.java.spirit1292.spiritfolder.windows.WindowLogin;
import main.java.spirit1292.spiritfolder.windows.WindowMain;
import main.java.spirit1292.spiritfolder.windows.WindowPassword;

import javax.swing.*;
import java.io.File;

public class ProjectInfi
{
    public static JFrame windowMain;
    public static JFrame windowLogin;
    public static JFrame windowPassword;

    public static String passwordProgram;

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

    public static void main(String[] args) throws Exception
    {
        LookAndFeel.main(null);
        LoadConfig();

        windowMain = new WindowMain();
        windowLogin = new WindowLogin();
        windowPassword = new WindowPassword();

        if (passwordProgram == null)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_INFI_DIALOG_PASSWORD_NULL_MESSAGE,false);
            windowPassword.setVisible(true);
        }
        else windowLogin.setVisible(true);
    }
}
