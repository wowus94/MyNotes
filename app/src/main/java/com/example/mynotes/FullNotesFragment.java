package com.example.mynotes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
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
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_full_notes_fragment, menu);
        menu.findItem(R.id.action_about).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_toast: {
                Toast.makeText(requireContext(), "Привет!", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_full_notes, container, false);
    }

    @SuppressLint("ResourceType")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            currentWeek = getArguments().getParcelable(TASK_WEEK);
            initList(view);
            initPopupMenu(view);

            getChildFragmentManager().beginTransaction().replace(R.id.container_child, FullNotesChildFragment.newInstance(currentWeek))
                    .addToBackStack("").commit();

            view.findViewById(R.id.hello_btn).setOnClickListener(v -> showPushNotification());

            /*view.findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    requireActivity().getSupportFragmentManager().popBackStack();
                }
            });*/
        }
    }
    public final String CHANNEL_ID = "1";

    void showPushNotification() {
        NotificationManager notificationManager =(NotificationManager) requireActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "CHANNEL1", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Это канал для то-то и то-то");
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Notification notification = new NotificationCompat.Builder(requireContext(),CHANNEL_ID)
                .setContentTitle("Привет!")
                .setContentText("Как дела?")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setPriority(Notification.PRIORITY_HIGH)
                .build();

        notificationManager.notify(1, notification);
    }

    private void initPopupMenu(View view) {
        view.findViewById(R.id.back_exit).setOnClickListener(v -> showAlertDialog());


        TextView textView = view.findViewById(R.id.tvNote);
        textView.setOnLongClickListener(v -> {
            Activity activity = requireActivity();
            PopupMenu popupMenu = new PopupMenu(activity, v);
            activity.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.action_popup_clear:
                            textView.setText("");
                            return true;
                        case R.id.action_popup_exit:
                            activity.finish();
                            return true;
                    }

                    return true;
                }
            });
            popupMenu.show();
            return true;
        });
    }


    void showAlertDialog() {
        new AlertDialog.Builder(requireContext())
                .setTitle("AlertDialog")
                .setMessage("Выйти из приложения?")
                .setPositiveButton("Да", (dialog, which) -> {
                    requireActivity().finish();
                })
                .setNegativeButton("Нет", (dialog, which) -> {
                    showToast("Нет");
                })
                .setNeutralButton("Я подумаю", (dialog, which) -> {
                    showToast("Ты подумаешь");
                })
                .show();
    }


    private void showToast(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show();
    }


    private void initList(View view) {
        String[] notes = getResources().getStringArray(R.array.task);
        TextView tvNote = view.findViewById(R.id.tvNote);
        tvNote.setText(notes[currentWeek.getIndex()]);
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