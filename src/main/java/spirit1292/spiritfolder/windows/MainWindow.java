package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.procedures.FolderLocation;
import main.java.spirit1292.spiritfolder.listeners.WindowActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowListeners;
import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;
import main.java.spirit1292.spiritfolder.settings.LookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class MainWindow extends JFrame
{
    public static JTree folderTree;
    public String spiritFolderLocation = AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
    Image image = new ImageIcon(Reference.APPLICATION_ICON_LOCATION + Reference.APPLICATION_ICON_NAME).getImage();

    public MainWindow()
    {
        super(Reference.APPLICATION_NAME);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconImage(image);

        JPanel panelMain = new JPanel(new FlowLayout());
        JButton buttonOpenFolder = new JButton(Names.MAINWINDOW_BUTTON_OPENFOLDER_NAME);
        JButton buttonRefresh = new JButton(Names.MAINWINDOW_BUTTON_REFRESH_NAME);
        folderTree = new FolderMonitoring().FolderTree();

        add(folderTree,BorderLayout.NORTH);
        add(buttonOpenFolder);
        add(buttonRefresh);

        panelMain.add(buttonOpenFolder);
        panelMain.add(buttonRefresh);

        add(panelMain, BorderLayout.SOUTH);

        setPreferredSize(new Dimension(400, 600));
        pack();
        setLocationRelativeTo(null);

        buttonOpenFolder.addActionListener(WindowActionListeners.openFolder);
        buttonRefresh.addActionListener(WindowActionListeners.folderList);

        addWindowListener(new WindowListeners());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_INFO +
                    TerminalMessages.TITLE_WINDOW_OPEN_MESSAGE);
            LookAndFeel.main(null);

            new MainWindow();

            FolderLocation.main(null);
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_WINDOW_OPEN_ERROR);
        }
    }
}
