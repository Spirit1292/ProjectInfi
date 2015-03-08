package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppConfig;
import main.java.spirit1292.spiritfolder.windows.WindowPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static main.java.spirit1292.spiritfolder.reference.TerminalMessages.*;

public class WindowPasswordActionListeners
{
    public static String passwordProgram;
    public static String passwordInputOne;
    public static String passwordInputTwo;
    public static String passwordInputThree;

    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
            passwordProgram = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_PASSWORD_TITLE);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void SaveConfig(String name, String value)
    {
        try
        {
            AppConfig.put(name, value);
            AppConfig.save(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static ActionListener changePassword = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                LoadConfig();

                if (passwordProgram != null)
                {
                    passwordInputOne = WindowPassword.field1.getText();
                    passwordInputTwo = WindowPassword.field2.getText();
                    passwordInputThree = WindowPassword.field3.getText();

                    if (passwordInputOne.equals(passwordProgram))
                    {
                        if (passwordInputTwo.equals(passwordInputThree))
                        {
                            SaveConfig(Names.SETTING_SPIRITFOLDER_PASSWORD_TITLE, passwordInputThree);
                            new Message().ShowMessage(1, 1, TITLE_WINDOWPASSWORD_ACTION_PASSWORD_CHANGED, false);
                            ProjectInfi.windowPassword.setVisible(false);
                        }
                        else new Message().ShowMessage(1, 4 , TITLE_WINDOWPASSWORD_ACTION_PASSWORD_MATCH_ERROR, false);
                    }
                    else new Message().ShowMessage(1, 4 , TITLE_WINDOWPASSWORD_ACTION_PASSWORD_VERIFY_ERROR, false);
                }
                else
                {
                    passwordInputTwo = WindowPassword.field2.getText();
                    passwordInputThree = WindowPassword.field3.getText();

                    if (passwordInputTwo.equals(passwordInputThree))
                    {
                        SaveConfig(Names.SETTING_SPIRITFOLDER_PASSWORD_TITLE, passwordInputThree);
                        new Message().ShowMessage(1, 1, TITLE_WINDOWPASSWORD_ACTION_PASSWORD_CREATED, false);
                        ProjectInfi.windowPassword.setVisible(false);
                    }
                    else new Message().ShowMessage(1, 3 , TITLE_WINDOWPASSWORD_ACTION_PASSWORD_MATCH_ERROR, true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    };

    public static ActionListener exit = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            ProjectInfi.windowPassword.setVisible(false);
        }
    };
}
