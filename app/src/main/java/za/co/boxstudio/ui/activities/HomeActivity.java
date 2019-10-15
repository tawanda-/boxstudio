package za.co.boxstudio.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import za.co.boxstudio.R;
import za.co.boxstudio.webservices.models.Member;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button profileButton = findViewById(R.id.profileButton);
        final Button scheduleButton = findViewById(R.id.scheduleButton);
        final Button bookingButton = findViewById(R.id.bookingButton);
        final Button aboutUsButton = findViewById(R.id.aboutUsButton);
        final Button logoutButton = findViewById(R.id.logoutButton);


        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        bookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, BookingActivity.class);
                startActivity(intent);
            }
        });

        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(HomeActivity.this);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean(getString(R.string.box_studio_shared_pref_user_logged_in), false);
                editor.putString(getString(R.string.box_studio_shared_pref_user), new Gson().toJson(new Member()));
                editor.commit();

                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
