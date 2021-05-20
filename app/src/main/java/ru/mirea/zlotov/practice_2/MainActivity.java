package ru.mirea.zlotov.practice_2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    int selected_hours;
    int selected_minutes;
    int selected_year = Calendar.getInstance().get(Calendar.YEAR);
    int selected_month = Calendar.getInstance().get(Calendar.MONTH);
    int selected_dayofmonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickTimeSet(View view) {
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                selected_hours = hourOfDay;
                selected_minutes = minute;
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, timeSetListener,
                selected_hours, selected_minutes, true);
        timePickerDialog.show();
    }

    public void onClickDateSet(View view) {
        DatePickerDialog.OnDateSetListener dateSetListener = (view1, year, month, dayOfMonth) -> {
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, dateSetListener,
                selected_year, selected_month, selected_dayofmonth);
        datePickerDialog.show();
    }

    public void onClickProgressSet(View view) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Waiting");
        progressDialog.setMessage("...");
        progressDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        progressDialog.show();
    }
}