package com.github.aistomin.incleaner;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.github.aistomin.incleaner.api.Constants;

/**
 * Created by aistomin on 06.03.18.
 */
public class AuthenticationDialog extends Dialog {

    private final AuthenticationListener listener;
    private Context context;

    public AuthenticationDialog(@NonNull Context context, AuthenticationListener listener) {
        super(context);
        this.context = context;
        this.listener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.auth_dialog);
        initializeWebView();
    }

    private void initializeWebView() {
        WebView web_view = (WebView) findViewById(R.id.web_view);
        String url = Constants.BASE_URL
            + "oauth/authorize/?client_id="
            + Constants.CLIENT_ID
            + "&redirect_uri="
            + Constants.REDIRECT_URI
            + "&response_type=token"
            + "&display=touch&scope=public_content";
        web_view.loadUrl(url);
        web_view.setWebViewClient(new WebViewClient() {

            boolean authComplete = false;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            String access_token;

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (url.contains("#access_token=") && !authComplete) {
                    Uri uri = Uri.parse(url);
                    access_token = uri.getEncodedFragment();
                    // get the whole token after the '=' sign
                    access_token = access_token.substring(access_token.lastIndexOf("=") + 1);
                    Log.i("", "CODE : " + access_token);
                    authComplete = true;
                    listener.onCodeReceived(access_token);
                    dismiss();

                } else if (url.contains("?error")) {
                    Toast.makeText(context, "Error Occured", Toast.LENGTH_SHORT).show();
                    dismiss();
                }
            }
        });
    }
}
