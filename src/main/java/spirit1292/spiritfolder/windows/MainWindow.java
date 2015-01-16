package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.procedures.FolderMonitoring;
import main.java.spirit1292.spiritfolder.procedures.SelectFolderLocation;
import main.java.spirit1292.spiritfolder.listeners.WindowActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowListeners;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.LookAndFeel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainWindow extends JFrame
{
    public JPanel panelMain;
    public JButton buttonOpenFolder;
    public JButton buttonExit;
    public JTextPane folderList;
    private JButton buttonRefresh;
    public JTextField folderDestination;

    public static File[] listOfFiles;

    public MainWindow()
    {
        super(Reference.APPLICATION_NAME);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setContentPane(panelMain);

        setPreferredSize(new Dimension(600, 400));
        pack();
        setLocationRelativeTo(null);

        buttonOpenFolder.addActionListener(WindowActionListeners.openFolder);
        buttonExit.addActionListener(WindowActionListeners.exit);
        buttonRefresh.addActionListener(WindowActionListeners.folderMonitoring);

        addWindowListener(new WindowListeners());
        setVisible(true);
    }

    public void Monitoring()
    {
        new FolderMonitoring();
        folderList.setText(listOfFiles.toString());
    }

    public static void main(String[] args)
    {
        try
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_INFO +
                    TerminalMessages.TITLE_WINDOW_OPEN_MESSAGE);
            LookAndFeel.main(null);
            new MainWindow();
            SelectFolderLocation.main(null);
        }
        catch (Exception e)
        {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM + TerminalMessages.MESSAGE_ERROR +
                    TerminalMessages.TITLE_WINDOW_OPEN_ERROR);
        }
    }
}
