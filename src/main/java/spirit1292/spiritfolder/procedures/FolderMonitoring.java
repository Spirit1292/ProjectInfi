package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.windows.MainWindow;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import java.io.File;

public class FolderMonitoring
{
    public static void main(String[] args)
    {
        File folder = new File(AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE));
        File[] listOfFiles = folder.listFiles();
        MainWindow.listOfFiles = listOfFiles;

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
