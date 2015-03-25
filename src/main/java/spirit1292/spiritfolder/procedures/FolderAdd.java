package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import javax.swing.*;
import java.io.File;

public class FolderAdd extends JFrame
{
    public static JFileChooser fileChooser;
    public static File[] fileList;

    public static void SpiritFolderFiles()
    {
        int ret = fileChooser.showDialog(null, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_TITLE"));
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            try
            {
                fileList = fileChooser.getSelectedFiles();
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_BEGIN"), null);
                        System.out.println("-----------------------------------------------------------------------");
                for (File file : fileList)
                {
                    new File(String.valueOf(file)).renameTo(new File(String.valueOf(ProjectInfi.folderDestination) + "\\" + file.getName()));
                    new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_FILE_NAME") + file.getName(), null);
                }
                System.out.println("-----------------------------------------------------------------------");
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_DONE"), null);
                        FolderMonitoring.UpdateFolderTree();
            }
            catch (Exception ex)
            {
                new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_ERROR"), ex);
            }
        }
        else
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_PROCEDURE_FOLDER_ADD_CANCEL"), null);
        }
    }

    public static void main(String[] args)
    {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setAcceptAllFileFilterUsed(false);

        SpiritFolderFiles();
    }
}
