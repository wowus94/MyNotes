package com.example.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            NotesFragment notesFragment = new NotesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.list_notes, notesFragment).commit();


            }
        }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment)getSupportFragmentManager()
                .findFragmentById(R.id.list_notes);
        if(backStackFragment!=null&&backStackFragment instanceof FullNotesFragment){
            onBackPressed();
        }
    }
    }