package main.java.spirit1292.spiritfolder.settings;

import main.java.spirit1292.spiritfolder.reference.Reference;

import java.util.Locale;
import java.util.ResourceBundle;

public class AppLang
{
    public static Locale currentLocale;
    public static ResourceBundle currentResourceBundle;

    public static StringBuilder langPath = new StringBuilder(Reference.APP_LOCALIZATION_FOLDER_LOCATION);
    public static StringBuilder language;
    public static StringBuilder country;

    public static void LoadConfig()
    {
        try
        {
            language = new StringBuilder(AppConfig.get(Reference.SETTING_LANGUAGE_NAME));
            country = new StringBuilder(AppConfig.get(Reference.SETTING_LANGUAGE_COUNTRY));
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static String Lang(String unlocalizedName)
    {
        LoadConfig();
        try
        {
            currentLocale = new Locale(language.toString(), country.toString());
            currentResourceBundle = ResourceBundle.getBundle(langPath.toString(), currentLocale);
            return currentResourceBundle.getString(unlocalizedName);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return unlocalizedName;
        }
    }
}
