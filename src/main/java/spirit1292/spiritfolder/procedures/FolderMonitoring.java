package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppSettings;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class FolderMonitoring
{
    public String spiritFolderLocation = AppSettings.LoadSettings(Reference.SETTING_SPIRITFOLDER_DESTINATION_TITLE);

    public void GetList(DefaultMutableTreeNode node, File file) {
        if (!file.isDirectory()) {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_INFO +
                    "Found file: " + file.getName());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
            node.add(child);
        } else {
            System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                    TerminalMessages.MESSAGE_INFO +
                    "Found folder: " + file.getName());
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
            node.add(child);
            File fList[] = file.listFiles();
            for (int i = 0; i < fList.length; i++)
                GetList(child, fList[i]);
        }
    }

    public JTree FolderTree()
    {
            DefaultMutableTreeNode root = new DefaultMutableTreeNode("root", true);
            new FolderMonitoring().GetList(root, new File(spiritFolderLocation));
            JTree treeFolder = new JTree(root);
            treeFolder.setRootVisible(false);
            return treeFolder;
    }
}
