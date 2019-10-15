package za.co.boxstudio.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(RegistrationActivity.this);
        Boolean isLoggedIn = sharedPref.getBoolean(getString(R.string.box_studio_shared_pref_user_logged_in), false);

        if(isLoggedIn){

            Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }

        setContentView(R.layout.activity_registration);

        final EditText firstNameTextView = findViewById(R.id.textViewRegisterFirstName);
        final EditText lastNameTextView = findViewById(R.id.textViewRegisterLastName);
        final EditText usernameNameTextView = findViewById(R.id.textViewRegisterUsername);
        final EditText emailTextView = findViewById(R.id.textViewRegisterEmail);
        final EditText passwordTextView = findViewById(R.id.textViewRegisterPassword);
        final Button submitButton = findViewById(R.id.buttonRegisterSubmit);



        /*final Member member1 = new Member("jamesbond0010", "james", "bond",
                "jbond10@james.com", "bond");*/

        final Retrofit client = ClientSingleton.getRetrofitInstance();
        final MemberService service = client.create(MemberService.class);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d(this.getClass().getSimpleName(), usernameNameTextView.getText().toString());

                Log.d(this.getClass().getSimpleName(), usernameNameTextView.getText().toString()+firstNameTextView.getText().toString()+
                        lastNameTextView.getText().toString()+emailTextView.getText().toString()+passwordTextView.getText().toString());


                final Member member1 = new Member(usernameNameTextView.getText().toString(), firstNameTextView.getText().toString(),
                        lastNameTextView.getText().toString(), emailTextView.getText().toString(), passwordTextView.getText().toString());

                Call<Member> call = service.register(member1.getMemberEmail(), member1.getMemberName(),
                        member1.memberSurname, member1.getMembershipID(), member1.getMemberID(), member1.getPassword());

                call.enqueue(new Callback<Member>() {

                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {
                        Log.d(this.getClass().getSimpleName(), new Gson().toJson(response.body()));

                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(RegistrationActivity.this);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean(getString(R.string.box_studio_shared_pref_user_logged_in), true);
                        editor.putString(getString(R.string.box_studio_shared_pref_user), new Gson().toJson(response.body()));
                        editor.commit();

                        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Member> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
