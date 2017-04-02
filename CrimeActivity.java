package ru.alex_pst.criminalintentanvil;

import java.util.UUID;

/**
 * Created by Alex_ on 01.04.2017.
 */

public class CrimeActivity extends SingleFragmentActivity{
    public static String EXTRA_CRIME_ID; // создает фрагмент с информацией о преступлении из класса CrimeFragment
    @Override
    protected CrimeFragment createFragment(){
        UUID crimeId = (UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }
}
