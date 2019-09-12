package com.consulteer.digital_signage.view.ui.home.vacationReq;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.consulteer.digital_signage.R;
import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static android.graphics.Color.parseColor;

public class VacCalendarFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_vacation);

        Date today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView datePicker = findViewById(R.id.calendarVac);
        datePicker.init(today, nextYear.getTime())
                .inMode(CalendarPickerView.SelectionMode.RANGE)
                .withSelectedDate(today);
       final int countDays = datePicker.getCount();
        List requestedDates = datePicker.getSelectedDates();



        /// showing dialog by button
        findViewById(R.id.reqleave).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(VacCalendarFragment.this);
                builder.setTitle("Your Request");
                builder.setMessage("Are you sure you want to send request for vacation for:" +countDays+"\n");
                builder.setPositiveButton("Send Request", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(VacCalendarFragment.this, "You successfully sent the request for revision", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(VacCalendarFragment.this, "You request was canceled", Toast.LENGTH_SHORT).show();
                    }
                });

            }


        });

        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate1 = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH) + " " + (calSelected.get(Calendar.MONTH) + 1) + "" +
                        calSelected.get(Calendar.YEAR);
            }
            @Override
            public void onDateUnselected(Date date) {
                Calendar calUnselected = Calendar.getInstance();
                calUnselected.setTime(date);
            }

        });
    }
}
