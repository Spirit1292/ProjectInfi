package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import javax.swing.*;
import java.io.File;

public class FolderLocation extends JFrame
{
    public static JFileChooser folderChooser;
    public static File folderDestination;

    public static void SpiritFolder()
    {
        int ret = folderChooser.showDialog(null, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_SET"));
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                folderDestination = new File (folderChooser.getSelectedFile().toString()
                        + Reference.APP_FOLDER_NAME);
                folderDestination.mkdirs();
                ProjectInfi.SaveConfig(Reference.SETTING_FOLDER_DESTINATION, folderDestination.toString());
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_SELECTED_DONE"), null);
            }
            catch (Exception ex)
            {
                new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_SELECTED_ERROR"), ex);
            }
        }
        else
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_SELECTED_CANCEL"), null);
            System.exit(0);
        }
    }

    public static void main(String[] args) throws Exception
    {
        folderChooser = new JFileChooser();
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        if (ProjectInfi.folderDestination.exists())
            new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_EXISTS_YES"), null);
        else if (!ProjectInfi.folderDestination.exists()
                && !ProjectInfi.folderDestination.equals(Reference.SETTING_FOLDER_DESTINATION_NULL))
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_EXISTS_NO"), null);
            SpiritFolder();
        }
        else
        {
            new Message().ShowMessage(1, 3, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_LOCATION_SELECT"), null);
            SpiritFolder();
        }
    }
}


