package app;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageUtil {
    private static Locale currentLocale = new Locale("id", "ID");

    public static ResourceBundle getBundle() {
        return ResourceBundle.getBundle("app.messages", currentLocale);
    }

    public static void setLocale(String languageCode) {
        switch (languageCode) {
            case "en":
                currentLocale = new Locale("en", "US");
                break;
            case "id":
            default:
                currentLocale = new Locale("id", "ID");
                break;
        }
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }
}
