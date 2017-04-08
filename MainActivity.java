package ru.alex_pst.criminalintentanvil;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.app.FragmentManager;

import java.io.FileDescriptor;
import java.io.PrintWriter;

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crime);
        getFragmentManager().beginTransaction().add(R.id.fragment_activity, new CrimeFragment()).commit();
    }



}


