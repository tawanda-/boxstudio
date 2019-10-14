package za.co.boxstudio.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import za.co.boxstudio.R;
import za.co.boxstudio.webservices.ClientSingleton;
import za.co.boxstudio.webservices.services.MemberService;

public class BookingActivity extends AppCompatActivity {

    final Retrofit client = ClientSingleton.getRetrofitInstance();
    final MemberService service = client.create(MemberService.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final CoordinatorLayout layout = findViewById(R.id.layoutBooking);
        final EditText phoneNumber = findViewById(R.id.editTextBookingPhoneNumber);
        final EditText email = findViewById(R.id.editTextBookingEmailAddress);
        final EditText notes = findViewById(R.id.editTextBookingNotes);
        final CheckBox cardio = findViewById(R.id.checkBoxBookingCardio);
        final CheckBox boxing = findViewById(R.id.checkBoxBookingBoxing);
        final CheckBox karate = findViewById(R.id.checkBoxBookingKarate);
        final CheckBox yoga = findViewById(R.id.checkBoxBookingYoga);
        final CheckBox stretch = findViewById(R.id.checkBoxBookingStretch);
        final Button submit = findViewById(R.id.buttonBookingSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String activities = cardio.isChecked() ? "cardio, ": "";
                activities += boxing.isChecked() ? "boxing, ": "";
                activities += karate.isChecked() ? "karate, ": "";
                activities += yoga.isChecked() ? "yoga, ": "";
                activities += stretch.isChecked() ? "stretch, ": "";

                Map<String, String> bookingFields = new HashMap<>();
                bookingFields.put("email", email.getText().toString());
                bookingFields.put("phone", phoneNumber.getText().toString());
                bookingFields.put("activity", activities);
                bookingFields.put("additional_notes", notes.getText().toString());

                Call<Object> call = service.booking(bookingFields);
                call.enqueue(new Callback<Object>() {

                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {

                        Log.d(this.getClass().getSimpleName(), new Gson().toJson(response.body()));

                        Intent intent = new Intent(BookingActivity.this, HomeActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                        t.printStackTrace();

                        Snackbar.make(layout, R.string.error_messge, Snackbar.LENGTH_LONG).show();
                    }
                });
            }
        });

    }

}
