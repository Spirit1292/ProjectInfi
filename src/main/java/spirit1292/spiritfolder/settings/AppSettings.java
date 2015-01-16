package main.java.spirit1292.spiritfolder.settings;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class AppSettings
{
    public static String LoadSettings(String SettingName)
    {
        try
        {
            Properties AppProperties  = new Properties();
            FileInputStream SettingsFile = new FileInputStream(Reference.SETTINGS_LOCATION + Reference.SETTINGS_NAME);
            AppProperties.loadFromXML(SettingsFile);
            AppProperties.list(System.out);
            String SettingKey = AppProperties.getProperty(SettingName);
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_DONE +
                    TerminalMessages.TITLE_SETTINGS_LOAD_DONE);
            return(SettingKey);
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_SETTINGS_LOAD_ERROR);
            return null;
        }
    }

    public static void SaveSettings(String SettingName, String SettingKey) throws Exception
    {
        try
        {
            Properties AppProperties  = new Properties();
            AppProperties.setProperty(SettingName, SettingKey);
            FileOutputStream SettingsFile = new FileOutputStream(Reference.SETTINGS_LOCATION + Reference.SETTINGS_NAME);
            AppProperties.storeToXML(SettingsFile,null);
            SettingsFile.close();
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_DONE +
                    TerminalMessages.TITLE_SETTINGS_SAVE_DONE);
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_SETTINGS_SAVE_ERROR);
        }
    }
}
