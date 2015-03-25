package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import java.awt.Desktop;
import java.io.File;

public class FolderOpen
{
    public static Desktop desktop;

    public static void main(String[] args)
    {
        desktop = Desktop.getDesktop();

        try
        {
            new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_OPEN_BEGIN"), null);
            desktop.open(new File(String.valueOf(ProjectInfi.folderDestination)));
            new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_OPEN_DONE"), null);
        }
        catch (IllegalArgumentException iae)
        {
            new Message().ShowMessage(1, 4 ,AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_OPEN_MISSING"), iae);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_OPEN_ERROR"), ex);
        }
    }
}
