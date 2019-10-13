package za.co.boxstudio.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.preference.PreferenceManager;

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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
        Boolean isLoggedIn = sharedPref.getBoolean(getString(R.string.box_studio_shared_pref_user_logged_in), false);

        if(isLoggedIn){

            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }

        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button loginButton = findViewById(R.id.buttonLoginSubmit);
        final Button registerButton = findViewById(R.id.buttonRegister);
        final TextView emailTextView = findViewById(R.id.textViewLoginEmail);
        final TextView passwordTextView = findViewById(R.id.textViewLoginPassword);

        final Retrofit client = ClientSingleton.getRetrofitInstance();
        final MemberService service = client.create(MemberService.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Call<Member> call = service.login(emailTextView.getText().toString(), passwordTextView.getText().toString());
                call.enqueue(new Callback<Member>() {

                    @Override
                    public void onResponse(Call<Member> call, Response<Member> response) {

                        Log.d(this.getClass().getSimpleName(), new Gson().toJson(response.body()));

                        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(LoginActivity.this);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean(getString(R.string.box_studio_shared_pref_user_logged_in), true);
                        editor.putString(getString(R.string.box_studio_shared_pref_user), new Gson().toJson(response.body()));
                        editor.commit();


                        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
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

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
