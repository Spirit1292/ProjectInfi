package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowMain;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowMainMouseListeners extends MouseAdapter
{
    public static JTree tree = WindowMain.folderTree;
    public static int selRow;
    public static TreePath selPath;

    public static JPopupMenu popupMenu;
    public static JMenuItem menuItemFirst;
    public static JMenuItem menuItemSecond;

    public void mousePressed(MouseEvent me)
    {
        selRow = tree.getRowForLocation(me.getX(), me.getY());
        selPath = tree.getPathForLocation(me.getX(), me.getY());

        if (SwingUtilities.isRightMouseButton(me))
        {
            if (selRow != -1)
            {
                MouseRightClick(me);
            }
        }
    }

    public static void PopupMenu(MouseEvent me)
    {
        popupMenu = new JPopupMenu();
        menuItemFirst = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_ADD_FILES_NAME"));
        menuItemSecond = new JMenuItem(AppLang.Lang("WINDOW_MAIN_MENU_REFRESH_NAME"));

        menuItemFirst.addActionListener(WindowMainActionListeners.addFile);
        menuItemSecond.addActionListener(WindowMainActionListeners.refreshList);

        popupMenu.add(menuItemFirst);
        popupMenu.addSeparator();
        popupMenu.add(menuItemSecond);


        popupMenu.show(tree, me.getX(), me.getY());
    }

    public static void MouseRightClick(MouseEvent mouseEvent)
    {
        //tree.setSelectionRow(selRow);
        PopupMenu(mouseEvent);
    }
}

