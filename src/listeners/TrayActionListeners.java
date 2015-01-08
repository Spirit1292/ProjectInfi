package listeners;

import core.Window;
import core.procedures.ProcedureClose;
import core.tray.AppTrayIcon;
import settings.LookAndFeel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrayActionListeners
{
    public static void main(String[] args)
    {
        //Вызов окна программы
        AppTrayIcon.messageItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                Window.main(null);
            }
        });

        //Выход из программы
        AppTrayIcon.closeItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                ProcedureClose.main(null);
            }
        });

        //Тест LookAndFeel
        AppTrayIcon.lookAndFeelItem.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                LookAndFeel.main(null);
            }
        });
    }
}
