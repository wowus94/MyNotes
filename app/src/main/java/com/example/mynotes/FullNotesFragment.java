package com.example.mynotes;

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

public class FullNotesFragment extends Fragment {

    public static final String TASK_WEEK = "task";
    private Week currentWeek;

    public static FullNotesFragment newInstance(Week week) {
        FullNotesFragment fragment = new FullNotesFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TASK_WEEK, week);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_full_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            currentWeek = getArguments().getParcelable(TASK_WEEK);
            initList(view);
        }
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.task);
        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            TextView tv = new TextView(getContext());
            tv.setText(note);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int fi = i;
            tv.setOnClickListener(v -> {
                currentWeek = new Week(fi);
                shouldShowRequestPermissionRationale(currentWeek);
            });
        }
    }

    private void shouldShowRequestPermissionRationale(Week currentWeek) {
        this.currentWeek = currentWeek;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("mylogs", "F2 onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("mylogs", "F2 onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("mylogs", "F2 onResume");
        super.onResume();
    }

    @Override
    public void onStop() {
        Log.d("mylogs", "F2 onStop");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.d("mylogs", "F2 onPause");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d("mylogs", "F2 onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("mylogs", "F2 onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("mylogs", "F2 onDetach");
        super.onDetach();
    }
}