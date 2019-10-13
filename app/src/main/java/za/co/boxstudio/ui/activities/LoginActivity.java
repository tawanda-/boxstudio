package za.co.boxstudio.ui.activities;

import android.content.Intent;
import android.os.Bundle;

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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

                Call<List<Member>> call = service.login(emailTextView.getText().toString(), passwordTextView.getText().toString());
                call.enqueue(new Callback<List<Member>>() {

                    @Override
                    public void onResponse(Call<List<Member>> call, Response<List<Member>> response) {
                        Log.d(this.getClass().getSimpleName(), new Gson().toJson(response));
                    }

                    @Override
                    public void onFailure(Call<List<Member>> call, Throwable t) {
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
}
