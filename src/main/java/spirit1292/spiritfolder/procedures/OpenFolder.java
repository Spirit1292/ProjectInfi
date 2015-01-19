package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class OpenFolder
{
    public static void main(String[] args) throws IOException
    {
        Desktop desktop = Desktop.getDesktop();
        File dirToOpen;
        try
        {
            String folder = AppSettings.LoadSettings(
                    Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
            dirToOpen = new File(folder);
            desktop.open(dirToOpen);
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_DONE +
                    TerminalMessages.TITLE_WINDOW_ACTION_FOLDER_OPEN_DONE);
        }
        catch (IllegalArgumentException iae)
        {
            System.out.println(
                    TerminalMessages.TITLE_PROCEDURE_FOLDER_MISSING);
        }
    }
}
