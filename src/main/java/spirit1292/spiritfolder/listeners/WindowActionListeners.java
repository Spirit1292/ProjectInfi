package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.procedures.Close;
import main.java.spirit1292.spiritfolder.procedures.FolderOpen;
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

    public static ActionListener folderList = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                folderTree.update(null);
                System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                        TerminalMessages.MESSAGE_DONE +
                        "FolderList is refreshing");
            }
            catch (Exception g)
            {
                System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                        TerminalMessages.MESSAGE_ERROR +
                        "Something wrong in refreshing of FolderList!!!");
            }
        }
    };
}
