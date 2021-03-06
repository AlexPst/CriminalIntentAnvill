package ru.alex_pst.criminalintentanvil;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Alex_ on 01.04.2017.
 */

public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab (Context appContext){ //заполнение списка mCrimes
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        for (int i = 0; i<100; i++){
            Crime crime = new Crime();
            crime.setmTitle("Преступдение №" + i);
            crime.setSolved(i%2 == 0);
            mCrimes.add(crime);
        }

    }

    public static CrimeLab get(Context crime){ // Проверка на наличие и запуск класса
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(crime.getApplicationContext());
        }
        return sCrimeLab;
    }
    public Crime getCrime(UUID id){  // Передача значения mCrimes в Crime
        for (Crime crime : mCrimes){
            if(crime.getmId().equals(id));
            return crime;
        }
        return null;
    }

    public ArrayList<Crime> getmCrimes(){
        return mCrimes;
    }
}
