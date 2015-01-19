package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.procedures.OpenFolder;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowActionListeners
{
    public static ActionListener openFolder = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                OpenFolder.main(null);
            }
            catch (IOException f)
            {
                System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                            TerminalMessages.MESSAGE_ERROR +
                            TerminalMessages.TITLE_WINDOW_ACTION_FOLDER_OPEN_ERROR);
            }
        }
    };

    public static ActionListener exit = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            Close.main(null);
        }
    };

    public static ActionListener folderMonitoring = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            new FolderMonitoring().folderMonitoring();
        }
    };
}
