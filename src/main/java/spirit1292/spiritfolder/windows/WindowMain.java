package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.listeners.WindowMainActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowMainListeners;
import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class WindowMain extends JFrame
{
    public static JMenuBar menuBar;
    public static JMenu file, edit, tools;
    public static JMenuItem openFolder, logout, changePassword, refresh, exit;
    public static JRadioButtonMenuItem debugMode;

    public static JTree folderTree;
    public static JPanel panelButtons;
    public static JButton buttonOpenFolder;
    public static JButton buttonRefresh;

    public static Boolean debug;

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

    public WindowMain()
    {
        super(Reference.APP_NAME + ": " + Names.WINDOWMAIN_NAME);
            LoadConfig();
            debug = AppConfig.getBoolean(Names.SETTING_SPIRITFOLDER_DEBUG_TITLE);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new Dimension(600, 300));
        setResizable(true);
        setIconImage(new ImageIcon(Reference.APP_ICON_LOCATION + Reference.APP_ICON_NAME).getImage());

        try
        {
            menuBar = new JMenuBar();
            file = new JMenu(Names.WINDOWMAIN_MENU_FILE_NAME);
            edit = new JMenu(Names.WINDOWMAIN_MENU_EDIT_NAME);
            tools = new JMenu(Names.WINDOWMAIN_MENU_TOOLS_NAME);

            openFolder = new JMenuItem(Names.WINDOWMAIN_MENUITEM_OPENFOLDER_NAME);
            if (debug) debugMode = new JRadioButtonMenuItem(Names.WINDOWMAIN_MENUITEM_DEBUG_NAME, true);
            else debugMode = new JRadioButtonMenuItem(Names.WINDOWMAIN_MENUITEM_DEBUG_NAME, false);
            changePassword = new JMenuItem(Names.WINDOWMAIN_MENUITEM_CHANGEPASSWORD_NAME);
            refresh = new JMenuItem(Names.WINDOWMAIN_MENUITEM_REFRESH_NAME);
            logout = new JMenuItem(Names.WINDOWMAIN_MENUITEM_LOGOUT_NAME);
            exit = new JMenuItem(Names.WINDOWMAIN_MENUITEM_EXIT_NAME);

            menuBar.add(file);
            menuBar.add(edit);
            menuBar.add(tools);

            file.add(openFolder);
            file.addSeparator();
            file.add(logout);
            file.add(exit);

            tools.add(debugMode);
            tools.addSeparator();
            tools.add(changePassword);

            edit.add(refresh);

            panelButtons = new JPanel(new FlowLayout());
            buttonOpenFolder = new JButton(Names.WINDOWMAIN_BUTTON_OPENFOLDER_NAME);
            buttonRefresh = new JButton(Names.WINDOWMAIN_BUTTON_REFRESH_NAME);
            folderTree = new FolderMonitoring().FolderTree();
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_INIT_CREATEITEMS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_INIT_CREATEITEMS_ERROR, true);
        }

        try
        {
            add(folderTree, BorderLayout.NORTH);
            panelButtons.add(buttonOpenFolder);
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(new JSeparator(SwingConstants.VERTICAL));
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(buttonRefresh);
            add(panelButtons, BorderLayout.SOUTH);
            setJMenuBar(menuBar);
            pack();
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDITEMS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDITEMS_ERROR, true);
        }

        ActionListeners();
        WindowListeners();

        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void ActionListeners()
    {
        try
        {
            debugMode.addActionListener(WindowMainActionListeners.debugMode);
            openFolder.addActionListener(WindowMainActionListeners.openFolder);
            logout.addActionListener(WindowMainActionListeners.logout);
            exit.addActionListener(WindowMainActionListeners.exit);
            refresh.addActionListener(WindowMainActionListeners.folderList);
            changePassword.addActionListener(WindowMainActionListeners.changePassword);

            buttonOpenFolder.addActionListener(WindowMainActionListeners.openFolder);
            buttonRefresh.addActionListener(WindowMainActionListeners.folderList);
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDACTIONLISTENERS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDACTIONLISTENERS_ERROR, true);
        }
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowMainListeners());
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDWINDOWLISTENERS_DONE, false);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_INIT_ADDWINDOWLISTENERS_ERROR, false);
        }
    }

    public static void main(String[] args)
    {
        try
        {
            new Message().ShowMessage(1, 2, TerminalMessages.TITLE_WINDOWMAIN_OPEN_MESSAGE, false);
            new WindowMain();
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_OPEN_ERROR, true);
        }
    }
}
