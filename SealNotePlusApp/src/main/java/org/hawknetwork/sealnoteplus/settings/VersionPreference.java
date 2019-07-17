package org.hawknetwork.sealnoteplus.settings;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.Preference;
import android.util.AttributeSet;
import org.hawknetwork.sealnoteplus.R;

public class VersionPreference extends Preference {
    public VersionPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        String version = "";

        final PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                version = String.format("%s (#%d)", packageInfo.versionName, packageInfo.versionCode);
            } catch (PackageManager.NameNotFoundException e) {
                //
            }
            setSummary(version);
            setTitle(R.string.version);
            setPersistent(false);
        }
    }
}
