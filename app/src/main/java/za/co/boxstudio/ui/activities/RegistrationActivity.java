package za.co.boxstudio.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import za.co.boxstudio.R;
import za.co.boxstudio.webservices.ClientSingleton;
import za.co.boxstudio.webservices.models.Member;
import za.co.boxstudio.webservices.services.MemberService;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        final TextView firstNameTextView = findViewById(R.id.textViewRegisterFirstName);
        final TextView lastNameTextView = findViewById(R.id.textViewRegisterLastName);
        final TextView usernameNameTextView = findViewById(R.id.textViewRegisterUsername);
        final TextView emailTextView = findViewById(R.id.textViewRegisterEmail);
        final TextView passwordTextView = findViewById(R.id.textViewRegisterPassword);
        final TextView submitButton = findViewById(R.id.buttonRegisterSubmit);

        final Member member = new Member(usernameNameTextView.getText().toString(), firstNameTextView.getText().toString(),
                lastNameTextView.getText().toString(), emailTextView.getText().toString(), passwordTextView.getText().toString());

        /*final Member member = new Member("bond007", "james", "bond",
                "james@bond.com", "bond");*/

        final Retrofit client = ClientSingleton.getRetrofitInstance();
        final MemberService service = client.create(MemberService.class);

        Log.d(this.getClass().getSimpleName(), new Gson().toJson(member));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<List<Member>> call = service.register(member);
                call.enqueue(new Callback<List<Member>>() {

                    @Override
                    public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                        Log.d(this.getClass().getSimpleName(), new Gson().toJson(response));
                        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<List<Member>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

            }
        });
    }
}
