package ru.alex_pst.criminalintentanvil;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

/**
 * Created by Alex_ on 02.04.2017.
 */

public abstract class SingleFragmentActivity extends FragmentActivity {
    protected abstract CrimeFragment createFragment();

    @Override
    public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity);
        FragmentManager manager = getSupportFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.fragment_activity);

        if(fragment == null){
            fragment = createFragment();
            manager.beginTransaction().add(R.id.fragment_crime, fragment).commit();
        }
    }
}
