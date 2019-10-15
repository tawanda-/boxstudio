package za.co.boxstudio.ui.activities;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.widget.TextView;

import za.co.boxstudio.R;
import za.co.boxstudio.webservices.models.Member;

public class ProfileActivity extends AppCompatActivity {

    private Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final TextView nameTextView = findViewById(R.id.textViewProfileName);
        final TextView emailTextView = findViewById(R.id.textViewProfileEmail);
        final TextView phoneTextView = findViewById(R.id.textViewProfilePhone);
        final TextView usernameNameTextView = findViewById(R.id.textViewProfileUsername);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(ProfileActivity.this);

        String json = sharedPref.getString(getString(R.string.box_studio_shared_pref_user), "");
        member = new Gson().fromJson(json, Member.class);

        String name = member.getMemberName()+" "+member.getMemberSurname();

        nameTextView.setText(name);
        emailTextView.setText(member.getMemberEmail());
        usernameNameTextView.setText(member.getMemberID());
        phoneTextView.setText(member.getMemberContact());

    }
}
