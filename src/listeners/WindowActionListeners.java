package listeners;

import core.Window;
import core.procedures.ProcedureClose;
import core.procedures.ProcedureOpenFolder;
import reference.Reference;
import reference.TerminalMessages;
import settings.AppSettings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowActionListeners
{
    public static ActionListener openFolder = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ProcedureOpenFolder.main(null);
        }
    };

    public static ActionListener exit = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ProcedureClose.main(null);
        }
    };

        public static ActionListener save = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String Setting = new Window().textFieldValue;
                    AppSettings.SaveSettings("TextFieldValue", Setting);
                    System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                            TerminalMessages.MESSAGE_INFO +
                            "Text: " + Setting);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                            TerminalMessages.MESSAGE_ERROR +
                            TerminalMessages.TITLE_SETTINGS_SAVE_ERROR);
                }
            }
        };
/*
        ActionListener load = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String Setting = AppSettings.LoadSettings("TextFieldValue");
                    System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                            TerminalMessages.MESSAGE_INFO +
                            "Text: " + Setting);
                    Window.textField1.setText(Setting);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                    System.out.println(TerminalMessages.MESSAGE_SYSTEM +
                            TerminalMessages.MESSAGE_ERROR +
                            TerminalMessages.TITLE_SETTINGS_LOAD_ERROR);
                }
            }
        };
        */
}
