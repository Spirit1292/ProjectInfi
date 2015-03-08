package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.*;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class WindowMainActionListeners extends WindowMain
{
    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void SaveConfig(String name, String value)
    {
        try
        {
            AppConfig.put(name, value);
            AppConfig.save(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static ActionListener openFolder = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae1)
        {
            try
            {
                FolderOpen.main(null);
            }
            catch (Exception ex1)
            {
                new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_ACTION_FOLDER_OPEN_ERROR, true);
            }
        }
    };

    public static ActionListener changePassword = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ProjectInfi.windowPassword.setVisible(true);
        }
    };

    public static ActionListener folderList = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae2)
        {
            try
            {
                FolderMonitoring.UpdateFolderTree();
            }
            catch (Exception ex2)
            {
                new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_ACTION_FOLDER_LIST_REFRESH_ERROR, true);
            }
        }
    };

    public static ActionListener logout = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ProjectInfi.windowMain.setVisible(false);
            ProjectInfi.windowLogin.setVisible(true);
        }
    };

    public static ActionListener debugMode = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (WindowMain.debugMode.isSelected())
            {
                SaveConfig(Names.SETTING_SPIRITFOLDER_DEBUG_TITLE, "true");
                new Message().ShowMessage(1, 2, TerminalMessages.TITLE_WINDOWMAIN_ACTION_DEBUG_ON, false);
            }
            else
            {
                SaveConfig(Names.SETTING_SPIRITFOLDER_DEBUG_TITLE, "false");
                new Message().ShowMessage(1, 2, TerminalMessages.TITLE_WINDOWMAIN_ACTION_DEBUG_OFF, false);
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
}
