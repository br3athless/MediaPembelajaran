package r3ckless.mediapembelajaran;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

/**
 * Created by r3ckless on 7/15/2017.
 */

public class Preferences extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        Preference listPreference = getPreferenceManager().findPreference("fSize");

        //penyimpanan data ukuran font dari user
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                String userSelectedValue = (String) newValue;
                SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("fSize",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("fSize", Float.parseFloat(userSelectedValue));
                editor.commit();
                Toast.makeText(getApplicationContext(), "Ukuran font tersimpan", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}
