package com.github.aistomin.incleaner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * The main screen of the application which displays "Get Access Token" button.
 */
public class MainActivity extends AppCompatActivity
    implements AuthenticationListener {

    /**
     * Instagram authentication dialog.
     */
    private AuthenticationDialog dialog;

    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btn_get_access_token).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog = new AuthenticationDialog(
                        MainActivity.this, MainActivity.this
                    );
                    dialog.setCancelable(true);
                    dialog.show();
                }
            }
        );
    }

    @Override
    public void onCodeReceived(final String token) {
        if (token == null) {
            dialog.dismiss();
        }
        final Intent intent = new Intent(MainActivity.this, FeedActivity.class);
        intent.putExtra("access_token", token);
        startActivity(intent);
    }
}
