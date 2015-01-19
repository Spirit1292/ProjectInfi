package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import java.io.File;

public class FolderMonitoring
{
    public void folderMonitoring()
    {
        File folder = new File(AppSettings.LoadSettings(
                Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE));
        File[] listOfFiles = folder.listFiles();

        try
        {
            for (File file : listOfFiles)
            {
                if (file.isFile())
                {
                    System.out.println(file.getName());

                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_INFO +
                    TerminalMessages.TITLE_MONITORING_ITEMS_MISSING);
        }
    }
}
