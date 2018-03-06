package com.github.aistomin.incleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AuthenticationListener {

    private AuthenticationDialog auth_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_get_access_token = (Button) findViewById(R.id.btn_get_access_token);

        btn_get_access_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth_dialog = new AuthenticationDialog(LoginActivity.this, LoginActivity.this);
                auth_dialog.setCancelable(true);
                auth_dialog.show();
            }
        });
    }

    @Override
    public void onCodeReceived(String access_token) {
        if (access_token == null) {
            auth_dialog.dismiss();
        }

        Intent i = new Intent(LoginActivity.this, FeedActivity.class);
        i.putExtra("access_token", access_token);
        startActivity(i);

    }
}
