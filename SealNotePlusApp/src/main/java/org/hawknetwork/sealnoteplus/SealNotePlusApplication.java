package org.hawknetwork.sealnoteplus;

import android.app.Application;
import android.view.ViewConfiguration;
import org.hawknetwork.sealnoteplus.data.DatabaseHandler;
import net.sqlcipher.database.SQLiteDatabase;

import java.lang.reflect.Field;

public class SealNotePlusApplication extends Application {
    public final static String TAG = "SealNotePlusApplication";

    private static DatabaseHandler mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        // load sqlite-cipher native libraries
        SQLiteDatabase.loadLibs(this);
        mDatabase = new DatabaseHandler(this);

        // Force show overflow button on Action Bar
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");

            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        }
        catch (Exception e) {
            // presumably, not relevant
        }
    }

    public static DatabaseHandler getDatabase() {
        return mDatabase;
    }
}
