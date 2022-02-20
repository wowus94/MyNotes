package com.example.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NotesFragment extends Fragment {
    public static final String CURRENT_WEEK = "week_current";
    public Week currentWeek;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(CURRENT_WEEK, currentWeek);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            currentWeek = savedInstanceState.getParcelable(CURRENT_WEEK);

        } else {
            currentWeek = new Week(0);
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            showLand();
        }
        initView(view);

    }

    private void initView(View view) {
        String[] week = getResources().getStringArray(R.array.week);
        for (int i = 0; i < week.length; i++) {
            String weekName = week[i];
            TextView textView = new TextView(getContext());
            textView.setTextSize(35f);
            textView.setText(weekName);
            ((LinearLayout) view).addView(textView);
            final int finalI = i;
            textView.setOnClickListener(view1 -> {
                currentWeek = new Week(finalI);
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                    showLand();
                } else {
                    showPort();
                }
            });
        }
    }

    private void showLand() {
        FullNotesFragment fullNotesFragment = FullNotesFragment.newInstance(currentWeek);
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.full_notes, fullNotesFragment).commit();
    }

    private void showPort() {
        FullNotesFragment fullNotesFragment = FullNotesFragment.newInstance(currentWeek);
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.list_notes, fullNotesFragment).addToBackStack("").commit();
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("mylogs", "F1 onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("mylogs", "F1 onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("mylogs", "F1 onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.d("mylogs", "F1 onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.d("mylogs", "F1 onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("mylogs", "F1 onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("mylogs", "F1 onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("mylogs", "F1 onDetach");
        super.onDetach();
    }
}