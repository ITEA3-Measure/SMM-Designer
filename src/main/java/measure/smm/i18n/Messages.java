package measure.smm.i18n;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import com.modeliosoft.modelio.javadesigner.annotations.objid;

@objid ("de78bc88-c43d-4db2-8203-bc48b3377f75")
public class Messages {
    @objid ("d4575ca7-7522-4d91-ad71-3d4c9d409c53")
    private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle ("measure.smm.i18n.messages");

    @objid ("041d4a6e-de0b-48d6-a7b8-f20e2e6b50a1")
    private Messages() {
    }

    @objid ("d8f3ff97-96a7-481e-8869-fb2b574ebd12")
    public static String getString(final String key) {
        try {
            return RESOURCE_BUNDLE.getString (key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    @objid ("28a59136-9278-48fa-bbcc-c9f6a2491579")
    public static String getString(final String key, final String... params) {
        try {
            return MessageFormat.format (RESOURCE_BUNDLE.getString (key),(Object[]) params);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

}
