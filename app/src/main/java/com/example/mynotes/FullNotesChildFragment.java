package com.example.mynotes;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FullNotesChildFragment extends Fragment {

    public static final String TASK_WEEK = "task";
    private Week currentWeek;


    public static FullNotesChildFragment newInstance(Week week) {
        FullNotesChildFragment fragment = new FullNotesChildFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TASK_WEEK, week);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_full_notes_child, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            currentWeek = getArguments().getParcelable(TASK_WEEK);


            ImageView imageView = view.findViewById(R.id.full_notes_child);
            TypedArray images = getResources().obtainTypedArray(R.array.pic);
            imageView.setImageResource(images.getResourceId(currentWeek.getIndex(), R.drawable.pic));

            view.findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getParentFragmentManager().popBackStack();
                }
            });
        }
    }
}