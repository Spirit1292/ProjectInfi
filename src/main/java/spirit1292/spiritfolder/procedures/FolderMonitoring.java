package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.reference.TerminalMessages;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class FolderMonitoring
{
    static String spiritFolderDestination;
    public DefaultMutableTreeNode root;

    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
            spiritFolderDestination = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_DESTINATION_TITLE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void GetList(DefaultMutableTreeNode node, File file) throws Exception
    {
        LoadConfig();
        if (!file.isDirectory())
        {
            new Message().ShowMessage(1, 2, TerminalMessages.TITLE_MONITORING_ITEMS_TYPE_FILE + file.getName(), false);
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
            node.add(child);
        }
        else
        {
            new Message().ShowMessage(1, 2, TerminalMessages.TITLE_MONITORING_ITEMS_TYPE_FOLDER + file.getName(), false);
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file);
            node.add(child);
            File fList[] = file.listFiles();
            for (File aFList : fList) GetList(child, aFList);
        }
    }

    public JTree FolderTree()
    {
        LoadConfig();

        try
        {
            root = new DefaultMutableTreeNode("root", true);
            new FolderMonitoring().GetList(root, new File(spiritFolderDestination));
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_MONITORING_INIT_FILELIST_DONE, false);
        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_MONITORING_INIT_FILELIST_ERROR, true);
        }

        try
        {
            JTree treeFolder = new JTree(root);
            treeFolder.setRootVisible(false);
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_MONITORING_INIT_TREE_DONE, false);
            return treeFolder;

        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_MONITORING_INIT_TREE_ERROR, true);
            return null;
        }
    }

    public static void UpdateFolderTree()
    {
        try
        {
            DefaultTreeModel model = (DefaultTreeModel)WindowMain.folderTree.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
            new FolderMonitoring().GetList(root, new File(spiritFolderDestination));
            new Message().ShowMessage(1, 1, TerminalMessages.TITLE_WINDOWMAIN_ACTION_FOLDER_LIST_REFRESH_DONE, false);
            model.reload(root);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, TerminalMessages.TITLE_WINDOWMAIN_ACTION_FOLDER_LIST_REFRESH_ERROR, true);
        }
    }
}
