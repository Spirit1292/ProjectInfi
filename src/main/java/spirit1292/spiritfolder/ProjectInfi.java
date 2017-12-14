package main.java.spirit1292.spiritfolder;

import main.java.spirit1292.spiritfolder.procedures.FolderLocation;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.procedures.ScreenResolution;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.settings.AppLang;
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


    public static String mainConfig = Reference.APP_CONFIGS_LOCATION + Reference.APP_CONFIG_MAIN_FILE_NAME;
    public static String logConfig = Reference.APP_CONFIGS_LOCATION + Reference.APP_CONFIG_LOG_FILE_NAME;
    public static String passwordProgram;
    public static Integer versionDev;
    public static boolean debugMode;
    public static File folderDestination;
    public static String fontName;
    public static Integer fontSize;

    public static void LoadConfig()
    {
        try
        {
            //LogManager.getLogManager().readConfiguration(ProjectInfi.class.getResourceAsStream(logConfig));
            AppConfig.load(new File(mainConfig));
            versionDev = AppConfig.getInt(Reference.SETTING_VERSIONDEV, 0);
            debugMode = AppConfig.getBoolean(Reference.SETTING_DEBUG);
            fontName = AppConfig.get(Reference.SETTING_FONT_NAME);
            fontSize = AppConfig.getInt(Reference.SETTING_FONT_SIZE, 14);
            try {folderDestination = new File(AppConfig.get(Reference.SETTING_FOLDER_DESTINATION));}
            catch (NullPointerException npex) {folderDestination = new File(Reference.SETTING_FOLDER_DESTINATION_NULL);}
            try {passwordProgram = AppConfig.get(Reference.SETTING_PASSWORD);}
            catch (NullPointerException npex) {passwordProgram = null;}
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    public static void SaveConfig(String name, String value)
    {
        try
        {
            AppConfig.put(name, value);
            AppConfig.save(new File(mainConfig));
            LoadConfig();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void CreateWindows(int WindowIndex)
    {
        switch (WindowIndex)
        {
            case 0: {windowMain = new WindowMain(); break;}
            case 1: {windowLogin = new WindowLogin(); break;}
            case 2: {windowPassword = new WindowPassword(); break;}
        }
    }

    public static void main(String[] args) throws Exception
    {
        LoadConfig();
        new Message().ShowMessage(1, 2, ScreenResolution.ScreenResString(), null);
        LookAndFeel.main(null);

        CreateWindows(0);
        CreateWindows(1);
        CreateWindows(2);

        try
        {
            FolderLocation.main(null);
            //SaveConfig(Reference.SETTING_VERSIONDEV, (versionDev += 1) .toString());

            if (passwordProgram == null)
            {
                new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_INFI_DIALOG_PASSWORD_NULL_MESSAGE"), null);
                windowPassword.setVisible(true);
            }
            else windowLogin.setVisible(true);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_INFI_START_ERROR"), ex);
            ex.printStackTrace();
        }

    }
}
