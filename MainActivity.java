package ru.alex_pst.criminalintentanvil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_crime);
        getFragmentManager().beginTransaction().add(R.id.fragment_crime, new CrimeFragment()).commit();
    }
}
