package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.listeners.WindowMainActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowMainListeners;
import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.procedures.ScreenResolution;
import main.java.spirit1292.spiritfolder.procedures.StatusBar;
import main.java.spirit1292.spiritfolder.settings.AppLang;

import javax.swing.*;
import java.awt.*;

import static main.java.spirit1292.spiritfolder.reference.Reference.*;

public class WindowMain extends JFrame
{
    public static int windowWidth = ScreenResolution.GetHorizontalRes()/2;
    public static int windowHeight = ScreenResolution.GetVerticalRes()/2;

    public static JMenuBar menuBar;
    public static JMenu file, edit, tools;
    public static JMenuItem addFile, openFolder, logout, changePassword, refresh, exit;
    public static JRadioButtonMenuItem debugMode;
    public static JTree folderTree;
    public static StatusBar statusBar;
    public static JTextArea debugLog;

    public WindowMain()
    {
        super();
        setTitle(APP_NAME + " " + APP_VERSION + "." +ProjectInfi.versionDev.toString()
                + " - [" + ProjectInfi.folderDestination + "]");
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        setFont(new Font(ProjectInfi.fontName, Font.PLAIN, ProjectInfi.fontSize));
        setResizable(true);
        setIconImage(new ImageIcon(APP_ICON_LOCATION + APP_ICON_NAME).getImage());

        try
        {
            folderTree = new FolderMonitoring().FolderTree();
            statusBar = new StatusBar();

            menuBar = new JMenuBar();
            file = new JMenu(AppLang.Lang("WINDOW_MAIN_MENU_FILE_NAME"));
            edit = new JMenu(AppLang.Lang("WINDOW_MAIN_MENU_EDIT_NAME"));
            tools = new JMenu(AppLang.Lang("WINDOW_MAIN_MENU_TOOLS_NAME"));

            addFile = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ADD_FILES_NAME"));
            openFolder = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_OPENFOLDER_NAME"));
                if (ProjectInfi.debugMode)
                    debugMode = new JRadioButtonMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_DEBUG_NAME"), true);
                else
                    debugMode = new JRadioButtonMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_DEBUG_NAME"), false);
            changePassword = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_CHANGE_PASSWORD_NAME"));
            refresh = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_REFRESH_NAME"));
            logout = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_LOGOUT_NAME"));
            exit = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ITEM_EXIT_NAME"));

            debugLog = new JTextArea(null, null, 0, 70);

            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_MAIN_CREATE_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_CREATE_ITEMS_ERROR"), ex);
        }

        try
        {
            menuBar.add(file);
            menuBar.add(edit);
            menuBar.add(tools);
            file.add(addFile);
            file.add(openFolder);
            file.addSeparator();
            file.add(logout);
            file.add(exit);
            tools.add(debugMode);
            tools.addSeparator();
            tools.add(changePassword);
            edit.add(refresh);

            debugLog.setOpaque(true);
            debugLog.setEditable(false);

            add(folderTree, BorderLayout.CENTER);
            add(debugLog, BorderLayout.EAST);
            setJMenuBar(menuBar);
            getContentPane().add(statusBar, java.awt.BorderLayout.SOUTH);
            pack();
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_ITEMS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_ITEMS_ERROR"), ex);
        }

        ActionListeners();
        WindowListeners();
        //MouseListeners();

        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void ActionListeners()
    {
        try
        {
            debugMode.addActionListener(WindowMainActionListeners.debugMode);
            addFile.addActionListener(WindowMainActionListeners.addFile);
            openFolder.addActionListener(WindowMainActionListeners.openFolder);
            logout.addActionListener(WindowMainActionListeners.logout);
            exit.addActionListener(WindowMainActionListeners.exit);
            refresh.addActionListener(WindowMainActionListeners.folderList);
            changePassword.addActionListener(WindowMainActionListeners.changePassword);
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_ACTION_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_ACTION_LISTENERS_ERROR"), ex);
        }
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowMainListeners());
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_WINDOW_LISTENERS_DONE"), null);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_ADD_WINDOW_LISTENERS_ERROR"), ex);
        }
    }

    public void MouseListeners()
    {
        //folderTree.addMouseListener(new WindowMainMouseListeners());
    }


    public static void main(String[] args)
    {
        try
        {
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_WINDOW_MAIN_OPEN_MESSAGE"), null);
            new WindowMain();
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_WINDOW_MAIN_OPEN_ERROR"), ex);
        }
    }
}
