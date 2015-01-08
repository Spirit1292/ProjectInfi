package core.procedures;

import reference.Reference;
import reference.TerminalMessages;
import settings.AppSettings;

import javax.swing.*;
import java.io.File;

public class ProcedureOpenFolder extends JFrame
{
    private static String FolderDestination = AppSettings.LoadSettings("UserFolderDestination");

    public static void main(String[] args)
    {
        JFileChooser folderChooser = new JFileChooser(FolderDestination);
        folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        folderChooser.setAcceptAllFileFilterUsed(false);

        int ret = folderChooser.showDialog(null, TerminalMessages.TITLE_PROCEDURE_FOLDER_OPEN);
        if (ret == JFileChooser.APPROVE_OPTION)
        {
            String folderDestination = folderChooser.getSelectedFile().toString() + Reference.APPLICATION_NAME;
            {
                try
                {
                    File folderCreating = new File(folderDestination);
                    if (folderCreating.exists())
                    {
                        JOptionPane.showMessageDialog(
                                null,
                                TerminalMessages.TITLE_PROCEDURE_FOLDER_EXISTS,
                                TerminalMessages.TITLE_PROCEDURE_MESSAGE_TITLE,
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
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


