package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;

import java.awt.Desktop;
import java.io.File;

public class FolderOpen
{
    static String spiritFolderDestination;

    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
            spiritFolderDestination = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception
    {
        LoadConfig();
        Desktop desktop = Desktop.getDesktop();

        try
        {
            desktop.open(new File(spiritFolderDestination));
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_ACTION_FOLDER_OPEN_DONE, false);
        }
        catch (IllegalArgumentException iae)
        {
            new Message().ShowMessage(1, 4 ,TerminalMessages.TITLE_PROCEDURE_FOLDER_MISSING, true);
        }
    }
}
