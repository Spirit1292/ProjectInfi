package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.FolderOpen;
import main.java.spirit1292.spiritfolder.procedures.TerminalMessage;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowActionListeners extends MainWindow
{
    public static ActionListener openFolder = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                FolderOpen.main(null);
            }
            catch (IOException f)
            {
                new TerminalMessage().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOW_ACTION_FOLDER_OPEN_ERROR);
            }
        }
    };

    public static ActionListener folderList = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                folderTree.updateUI();
                new TerminalMessage().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOW_ACTION_FOLDER_LIST_REFRESH_DONE);
            }
            catch (Exception g)
            {
                new TerminalMessage().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOW_ACTION_FOLDER_LIST_REFRESH_ERROR);
            }
        }
    };
}
