package main.java.spirit1292.spiritfolder.windows;

import main.java.spirit1292.spiritfolder.listeners.WindowPasswordActionListeners;
import main.java.spirit1292.spiritfolder.listeners.WindowPasswordListeners;
import main.java.spirit1292.spiritfolder.reference.Names;
import main.java.spirit1292.spiritfolder.reference.Reference;
import main.java.spirit1292.spiritfolder.settings.AppConfig;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class WindowPassword extends JFrame
{
    public static JPanel panelButtons;
    public static JButton button1;
    public static JButton button2;

    public static JPanel panelFields;
    public static JTextField field1;
    public static JTextField field2;
    public static JTextField field3;

    public static String password;

    public static void LoadConfig()
    {
        try
        {
            AppConfig.load(new File(Reference.APP_CONFIG_FILE_LOCATION + Reference.APP_CONFIG_FILE_NAME));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public WindowPassword()
    {
        super(Reference.APP_NAME + ": " + Names.WINDOWPASSWORD_NAME);
            LoadConfig();
            password = (String) AppConfig.get(Names.SETTING_SPIRITFOLDER_PASSWORD_TITLE);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setIconImage(new ImageIcon(Reference.APP_ICON_LOCATION + Reference.APP_ICON_NAME).getImage());


        try
        {
            panelButtons = new JPanel(new FlowLayout());
            panelButtons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            button1 = new JButton();
            button2 = new JButton("Cancel");

            field1 = new JTextField();
            field2 = new JTextField();
            field3 = new JTextField();

            panelFields = new JPanel()
            {
                public Dimension getMaximumSize()
                {
                    Dimension pref = getPreferredSize();
                    return new Dimension(Integer.MAX_VALUE,
                            pref.height);
                }
            };
            panelFields.setLayout(new BoxLayout(panelFields, BoxLayout.PAGE_AXIS));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        try
        {
            if (password != null)
            {
                setPreferredSize(new Dimension(380, 160));
                button1.setText("Change password");
                panelFields.add(field1, new BoxLayout(this, BoxLayout.LINE_AXIS));
                panelFields.add(Box.createHorizontalStrut(5));
            }
            else
            {
                setPreferredSize(new Dimension(380, 130));
                button1.setText("Create password");
            }
            panelFields.add(field2, new BoxLayout(this, BoxLayout.LINE_AXIS));
            panelFields.add(Box.createHorizontalStrut(5));
            panelFields.add(field3, new BoxLayout(this, BoxLayout.LINE_AXIS));
            panelFields.add(Box.createHorizontalStrut(5));
            add(panelFields);

            panelButtons.add(button1);
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(new JSeparator(SwingConstants.VERTICAL));
            panelButtons.add(Box.createHorizontalStrut(5));
            panelButtons.add(button2);
            add(panelButtons, BorderLayout.SOUTH);

            pack();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        ActionListeners();
        WindowListeners();

        setLocationRelativeTo(null);
        setVisible(false);
    }

    public void ActionListeners()
    {
        button1.addActionListener(WindowPasswordActionListeners.changePassword);
        button2.addActionListener(WindowPasswordActionListeners.exit);
    }

    public void WindowListeners()
    {
        try
        {
            super.addWindowListener(new WindowPasswordListeners());
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        try
        {
            new WindowPassword();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
