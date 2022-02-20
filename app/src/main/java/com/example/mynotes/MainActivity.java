package com.example.mynotes;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();

        if (savedInstanceState == null) {
            NotesFragment notesFragment = new NotesFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.list_notes, notesFragment).commit();

        }
    }


    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about:{
                getSupportFragmentManager().beginTransaction().replace(R.id.list_notes, new AboutFragment()).addToBackStack("").commit();
                return true;
            }
            case (R.id.action_exit):{
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = getSupportFragmentManager()
                .findFragmentById(R.id.list_notes);
        if (backStackFragment != null && backStackFragment instanceof FullNotesFragment) {
            onBackPressed();
        }
    }

}
