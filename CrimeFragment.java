package ru.alex_pst.criminalintentanvil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.UUID;

import trikita.anvil.RenderableView;

import static trikita.anvil.BaseDSL.MATCH;
import static trikita.anvil.BaseDSL.WRAP;
import static trikita.anvil.BaseDSL.dip;
import static trikita.anvil.BaseDSL.margin;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.BaseDSL.text;
import static trikita.anvil.DSL.button;
import static trikita.anvil.DSL.checkBox;
import static trikita.anvil.DSL.editText;
import static trikita.anvil.DSL.hint;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.textView;

/**
 * Created by Alex_ on 01.04.2017.
 */

public class CrimeFragment extends android.support.v4.app.Fragment {
    public static final String EXTRA_CRIME_ID = "criminal.CRIME_ID";

    Crime mCrime;
    EditText mTitleField;
    Button mDateButton;
    CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){ // Создаем объект CrimeFragment и помещаем в него args
        Bundle args = new Bundle ();
        args.putSerializable(EXTRA_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID)getArguments().getSerializable(EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return new RenderableView(container.getContext()) {
            public void view() {
                linearLayout(() ->{
                    textView(() -> {
                        size(MATCH, WRAP);
                        text("@string/crime_title_label");});
                    editText(()-> {
                        size(MATCH, WRAP);
                        margin(dip(16));
                        hint("@string/crime_title_hint");});
                    textView(()->{
                        size(MATCH, WRAP);
                        text("@string/crime_details_label");});
                    button(()->{
                        size(MATCH, WRAP);});
                    checkBox(() -> {
                        text("@string/crime_solved_label");
                        size(MATCH, WRAP);
                    });


                });
            }
        };
    }



}
