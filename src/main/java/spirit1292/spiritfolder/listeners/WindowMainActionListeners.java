package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.*;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import java.awt.event.ActionListener;

public class WindowMainActionListeners extends WindowMain
{
    public static ActionListener openFolder = ae1 -> FolderOpen.main(null);

    public static ActionListener changePassword = e -> ProjectInfi.windowPassword.setVisible(true);

    public static ActionListener refreshList = ae2 -> FolderMonitoring.UpdateFolderTree();

    public static ActionListener logout = e -> {
        ProjectInfi.windowMain.setVisible(false);
        ProjectInfi.windowLogin.setVisible(true);
    };

    public static ActionListener debugMode = e -> {
        try
        {
            if (WindowMain.debugMode.isSelected())
            {
                ProjectInfi.SaveConfig(Reference.SETTING_DEBUG, "true");
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_ACTION_DEBUG_ON"), null);
            }
            else
            {
                ProjectInfi.SaveConfig(Reference.SETTING_DEBUG, "false");
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_ACTION_DEBUG_OFF"), null);
            }
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_ACTION_DEBUG_MODE_ERROR"), ex);
        }
    };

    public static ActionListener addFile = e -> FolderAdd.main(null);

    public static ActionListener exit = e -> Close.main(null);
}
