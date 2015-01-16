package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFolder
{
    public static void main(String[] args) throws IOException
    {
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try
        {
            String folder = AppSettings.LoadSettings(
                    Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
            dirToOpen = new File(folder);
            desktop.open(dirToOpen);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println("File Not Found");
        }
    }
}
