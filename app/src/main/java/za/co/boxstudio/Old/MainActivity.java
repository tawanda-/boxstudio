package za.co.boxstudio.Old;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Button _btnlogin;
    EditText email, password;
    ConnectionClass connectionClass;
    private ConstraintLayout constraintLayout;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        // init constraintLayout
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        // initializing animation drawable by getting background from constraint layout
        animationDrawable = (AnimationDrawable) constraintLayout.getBackground();

        // setting enter fade animation duration to 5 seconds
        animationDrawable.setEnterFadeDuration(5000);

        // setting exit fade animation duration to 2 seconds
        animationDrawable.setExitFadeDuration(2000);

        connectionClass = new ConnectionClass();
        email = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        _btnlogin = (Button) findViewById(R.id.btnLogin);

        _btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DoLogin doLogin = new DoLogin();
                doLogin.execute("");

            }
        });
         */
    }

    public class DoLogin extends AsyncTask<String, String, String> {

        String z = "";
        Boolean isSuccess = false;

        String Email = email.getText().toString();
        String Password = password.getText().toString();

        @Override
        protected String doInBackground(String... params) {
            if (Email.trim().equals("") || Password.trim().equals(""))
                z = "Please enter Email & Password";
            else {
                try {
                    Connection con = connectionClass.con();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
                        String query = "SELECT * FROM tbl_SysUsers WHERE UserName = '" + Email + "' AND UserPass = '" + password + "'";
                        Statement stat = con.createStatement();
                        ResultSet rs = stat.executeQuery(query);

                        if (rs.next()) {
                            z = "Login Successful";
                            isSuccess = true;

                            Intent intent = new Intent(MainActivity.this, mainpage.class);
                            startActivity(intent);


                        } else {
                            z = "Invalid credentials";
                            isSuccess = false;
                        }
                    }
                } catch (Exception e) {
                    isSuccess = false;
                    z = "Exception";
                }
            }
            return z;
        }
    }

    protected void onResume() {
        super.onResume();
        /*if (animationDrawable != null && !animationDrawable.isRunning()) {
            // start the animation
            animationDrawable.start();
        }*/

    }

    protected void onPause() {

        super.onPause();
        /*if (animationDrawable != null && animationDrawable.isRunning()) {
            // stop the animation
            animationDrawable.stop();
        }*/
    }
}
