package com.consulteer.digital_signage.view.ui.home.vacationReq;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.consulteer.digital_signage.R;
import com.consulteer.digital_signage.data.db.UserDao;
import com.consulteer.digital_signage.data.db.entities.User;
import com.squareup.timessquare.CalendarPickerView;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        int countDays = datePicker.getCount();
        List requestedDates = datePicker.getSelectedDates();



        datePicker.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                //String selectedDate = DateFormat.getDateInstance(DateFormat.FULL).format(date);

                Calendar calSelected = Calendar.getInstance();
                calSelected.setTime(date);

                String selectedDate = "" + calSelected.get(Calendar.DAY_OF_MONTH) + " " + (calSelected.get(Calendar.MONTH) + 1) + "" +
                        calSelected.get(Calendar.YEAR);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });


    }
}
