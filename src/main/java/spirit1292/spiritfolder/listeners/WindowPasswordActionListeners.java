package main.java.spirit1292.spiritfolder.listeners;

import main.java.spirit1292.spiritfolder.ProjectInfi;
import main.java.spirit1292.spiritfolder.procedures.Message;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppLang;
import main.java.spirit1292.spiritfolder.windows.WindowPassword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowPasswordActionListeners
{
    public static String passwordInputOne;
    public static String passwordInputTwo;
    public static String passwordInputThree;

    public static ActionListener changePassword = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                if (ProjectInfi.passwordProgram != null)
                {
                    passwordInputOne = WindowPassword.fieldCurrentPassword.getText();
                    passwordInputTwo = WindowPassword.fieldNewPassword.getText();
                    passwordInputThree = WindowPassword.fieldNewPasswordConfirm.getText();

                    if (passwordInputOne.equals(ProjectInfi.passwordProgram))
                    {
                        if (passwordInputTwo.equals(passwordInputThree))
                        {
                            ProjectInfi.windowPassword.setVisible(false);
                            ProjectInfi.windowMain.setVisible(true);
                            ProjectInfi.SaveConfig(Reference.SETTING_PASSWORD, passwordInputTwo);
                            WindowPassword.fieldCurrentPassword.setText(null);
                            WindowPassword.fieldNewPassword.setText(null);
                            WindowPassword.fieldNewPasswordConfirm.setText(null);
                            new Message().ShowMessage(1, 1,
                                    AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTION_PASSWORD_CHANGED"), null);
                        }
                        else new Message().ShowMessage(1, 4 ,
                                AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTION_PASSWORD_MATCH_ERROR"), null);
                    }
                    else new Message().ShowMessage(1, 4 ,
                            AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTION_PASSWORD_VERIFY_ERROR"), null);
                }
                else
                {
                    passwordInputTwo = WindowPassword.fieldNewPassword.getText();
                    passwordInputThree = WindowPassword.fieldNewPasswordConfirm.getText();

                    if (passwordInputTwo.equals(passwordInputThree))
                    {
                        ProjectInfi.windowLogin.setVisible(true);
                        ProjectInfi.windowPassword.dispose();
                        System.out.println("Done");
                        WindowPassword.fieldCurrentPassword.setText(null);
                        WindowPassword.fieldNewPassword.setText(null);
                        WindowPassword.fieldNewPasswordConfirm.setText(null);
                        ProjectInfi.SaveConfig(Reference.SETTING_PASSWORD, passwordInputTwo);
                        new Message().ShowMessage(1, 1,
                                AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTION_PASSWORD_CREATED"), null);
                    }
                    else new Message().ShowMessage(1, 3 ,
                            AppLang.Lang("MESSAGE_WINDOW_PASSWORD_ACTION_PASSWORD_MATCH_ERROR"), null);
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
        public void actionPerformed(ActionEvent ae)
        {
            ProjectInfi.windowPassword.setVisible(false);
            WindowPassword.fieldCurrentPassword.setText(null);
            WindowPassword.fieldNewPassword.setText(null);
            WindowPassword.fieldNewPasswordConfirm.setText(null);
        }
    };
}
