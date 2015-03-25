package main.java.spirit1292.spiritfolder.procedures;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.io.File;

public class FolderMonitoring
{
    public static DefaultMutableTreeNode root;

    public static int folderCount;
    public static int fileCount;

    public void GetList(DefaultMutableTreeNode node, File file) throws Exception
    {
        if (!file.isDirectory())
        {
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_MONITORING_ITEM_TYPE_FILE")
                    + " " + file.getName(), null);
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file.getName());
            node.add(child);
            fileCount = fileCount+1;
        }

        else
        {
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_MONITORING_ITEM_TYPE_FOLDER")
                        + " " + file.getName(), null);
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(file.getName());
            node.add(child);
            File fList[] = file.listFiles();
            for (File aFList : fList) GetList(child, aFList);
            folderCount = folderCount+1;
        }
    }

    public JTree FolderTree()
    {
        try
        {
            root = new DefaultMutableTreeNode("root", true);
            if (ProjectInfi.debugMode)
            {
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_MONITORING_FILE_LIST_START"), null);
                System.out.println("-----------------------------------------------------------------------");
            }
            Thread.sleep(1500);
            new FolderMonitoring().GetList(root, new File(String.valueOf(ProjectInfi.folderDestination)));
            if (ProjectInfi.debugMode)
            {
                System.out.println("-----------------------------------------------------------------------");
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_MONITORING_FILE_LIST_DONE"), null);
                new Message().ShowMessage(1, 2, String.valueOf(folderCount - 1 + " folders / "
                        + fileCount + " files"), null);
            }
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_MONITORING_FILE_LIST_ERROR"), ex);
        }

        try
        {
            JTree treeFolder = new JTree(root);
            treeFolder.setRootVisible(false);
            treeFolder.setScrollsOnExpand(true);
            if (ProjectInfi.debugMode)
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_MONITORING_TREE_DONE"), null);
            return treeFolder;

        }
        catch (Exception e)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_MONITORING_TREE_ERROR"), null);
            return null;
        }
    }

    public static void UpdateFolderTree()
    {
        try
        {
            DefaultTreeModel model = (DefaultTreeModel)WindowMain.folderTree.getModel();
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
            if (ProjectInfi.debugMode)
            {
                new Message().ShowMessage(1, 2, AppLang.Lang("MESSAGE_MONITORING_FOLDER_LIST_REFRESH_BEGIN"), null);
                System.out.println("-----------------------------------------------------------------------");
            }
                Thread.sleep(1500);
                root.removeAllChildren();
                new FolderMonitoring().GetList(root, new File(String.valueOf(ProjectInfi.folderDestination)));
            if (ProjectInfi.debugMode)
            {
                System.out.println("-----------------------------------------------------------------------");
                new Message().ShowMessage(1, 1, AppLang.Lang("MESSAGE_MONITORING_FOLDER_LIST_REFRESH_DONE"), null);
            }
            model.reload(root);
        }
        catch (Exception ex)
        {
            new Message().ShowMessage(1, 4, AppLang.Lang("MESSAGE_MONITORING_FOLDER_LIST_REFRESH_ERROR"), ex);
        }
    }
}
