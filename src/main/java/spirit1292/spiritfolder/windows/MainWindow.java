package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.procedures.FolderLocation;
import main.java.spirit1292.spiritfolder.listeners.WindowActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowListeners;
import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.procedures.TerminalMessage;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;
import main.java.spirit1292.spiritfolder.settings.LookAndFeel;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
    public static JTree folderTree;
    public static JButton buttonOpenFolder;
    public static JButton buttonRefresh;
    public static JTextArea debug;
    public String spiritFolderLocation = AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
    Image image = new ImageIcon(Reference.APPLICATION_ICON_LOCATION + Reference.APPLICATION_ICON_NAME).getImage();

    public MainWindow()
    {
        super(Reference.APPLICATION_NAME);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(image);

        JPanel panelButtons = new JPanel(new FlowLayout());
        buttonOpenFolder = new JButton(Names.MAINWINDOW_BUTTON_OPENFOLDER_NAME);
        buttonRefresh = new JButton(Names.MAINWINDOW_BUTTON_REFRESH_NAME);
        debug = new JTextArea(10, 80);

        folderTree = new FolderMonitoring().FolderTree();

        panelButtons.add(buttonOpenFolder);
        panelButtons.add(buttonRefresh);

        add(folderTree, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.SOUTH);
        add(debug, BorderLayout.EAST);

        setPreferredSize(new Dimension(800, 600));
        pack();
        setLocationRelativeTo(null);

        ActionListeners();
        addWindowListener(new WindowListeners());
        FolderLocation.main(null);
        setVisible(true);
    }

    public void ActionListeners()
    {
        buttonOpenFolder.addActionListener(WindowActionListeners.openFolder);
        buttonRefresh.addActionListener(WindowActionListeners.folderList);
    }

    public static void main(String[] args)
    {
        try
        {
            new TerminalMessage().ShowMessage(1, 2, TerminalMessages.TITLE_WINDOW_OPEN_MESSAGE);

            LookAndFeel.main(null);

            new MainWindow();
        }
        catch (Exception e)
        {
            new TerminalMessage().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOW_OPEN_ERROR);
        }
    }
}
