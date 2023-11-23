package kr.ac.duksung.cookey_bottom;

import android.os.Bundle;
import android.widget.CalendarView;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalendarView calendarView = findViewById(R.id.calendarView);

        // Set the header text color programmatically
        setCalendarHeaderTextColor(calendarView, android.R.color.primary_text_light);
    }

    private void setCalendarHeaderTextColor(CalendarView calendarView, @ColorRes int colorRes) {
        int color = ContextCompat.getColor(this, colorRes);
        try {
            java.lang.reflect.Field field = calendarView.getClass().getDeclaredField("mHeaderTextColor");
            field.setAccessible(true);
            field.set(calendarView, color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
