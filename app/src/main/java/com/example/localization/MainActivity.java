package com.example.localization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Menu menu;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.hindi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.english:
                Toast.makeText(this, "English", Toast.LENGTH_SHORT).show();
                setLocale1("en");
                recreate();
                return true;
            case R.id.hindi:
                Toast.makeText(this, "Hindi", Toast.LENGTH_SHORT).show();
                setLocale1("hi");
                recreate();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setLocale1(String en) {
        Locale locale = new Locale(en);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        }
        getBaseContext().
                getResources().
                updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}