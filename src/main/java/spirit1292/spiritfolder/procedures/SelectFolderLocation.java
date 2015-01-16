package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import javax.swing.*;
import java.io.File;

public class SelectFolderLocation extends JFrame
{
    private static String FolderDestination = AppSettings.LoadSettings("UserFolderDestination");

    public static void main(String[] args)
    {
        JFileChooser folderChooser = new JFileChooser(FolderDestination);
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        {
            String folderDestination = AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
            File folderCreating = new File(folderDestination);
            if (folderCreating.exists())
            {
                return;
            }
            else
            {
                int ret = folderChooser.showDialog(null, TerminalMessages.TITLE_PROCEDURE_FOLDER_OPEN);
                if (ret == JFileChooser.APPROVE_OPTION)
                folderDestination = folderChooser.getSelectedFile().toString() + Reference.APPLICATION_NAME;
                {
                    try
                    {
                        String SettingsFolderDestionation =
                                AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
                        if (folderCreating.exists() && SettingsFolderDestionation != null)
                        {
                            JOptionPane.showMessageDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_EXISTS,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (!folderCreating.exists() && SettingsFolderDestionation != null)
                        {
                            folderCreating = new File(AppSettings.LoadSettings(
                                    Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE));
                            folderCreating.mkdirs();
                            Object[] options = {TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_1,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_2};
                            int i = JOptionPane.showOptionDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_CREATE,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.YES_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                        }
                        else
                        {
                            folderCreating.mkdirs();
                            AppSettings.SaveSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE,folderDestination);
                            Object[] options = {TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_1,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_2};
                            int j = JOptionPane.showOptionDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_CREATE,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.YES_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                        }
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(
                                null,
                                TerminalMessages.TITLE_PROCEDURE_FOLDER_ERROR,
                                TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
}


