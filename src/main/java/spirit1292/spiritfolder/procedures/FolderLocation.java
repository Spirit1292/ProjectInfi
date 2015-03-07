package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;

import javax.swing.*;
import java.io.File;

public class FolderLocation extends JFrame
{
    public static void main(String[] args) throws Exception
    {
        File fileConfig = new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME);
        AppConfig.load(fileConfig);
        String spiritFolderDestination = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_DESTINATION_TITLE);

        JFileChooser folderChooser = new JFileChooser(spiritFolderDestination);
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        {
            if (spiritFolderDestination != null)
            {
                new Message().ShowMessage(1, 2, TerminalMessages.TITLE_PROCEDURE_FOLDER_EXISTS, false);
            }
            else
            {
                File folderCreating = new File(spiritFolderDestination);
                int ret = folderChooser.showDialog(null, TerminalMessages.TITLE_PROCEDURE_FOLDER_OPEN);
                if (ret == JFileChooser.APPROVE_OPTION)
                    spiritFolderDestination = folderChooser.getSelectedFile().toString() + Reference.APP_NAME;
                {
                    try
                    {
                        if (folderCreating.exists())
                        {
                            JOptionPane.showMessageDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_EXISTS,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (!folderCreating.exists())
                        {
                            folderCreating = new File(
                                    (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_DESTINATION_TITLE));
                            folderCreating.mkdirs();
                            Object[] options = {
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_1,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_2
                            };
                            JOptionPane.showOptionDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_CREATE,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.OK_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                        }
                        else
                        {
                            folderCreating.mkdirs();
                            AppConfig.put(Names.SETTING_SPIRITFOLDER_DESTINATION_TITLE, spiritFolderDestination);
                            AppConfig.save(fileConfig);
                            Object[] options = {TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_1,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_BUTTON_2};
                            JOptionPane.showOptionDialog(
                                    null,
                                    TerminalMessages.TITLE_PROCEDURE_FOLDER_CREATE,
                                    TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                    JOptionPane.OK_OPTION,
                                    JOptionPane.INFORMATION_MESSAGE,
                                    null,
                                    options,
                                    options[0]);
                        }
                    }
                    catch (Exception e)
                    {
                        new Message().ShowMessage(1, 4, TerminalMessages.TITLE_PROCEDURE_FOLDER_ERROR, true);
                    }
                }
            }
        }
    }
}


