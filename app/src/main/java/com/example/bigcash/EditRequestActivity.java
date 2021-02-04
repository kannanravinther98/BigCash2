package com.example.bigcash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class EditRequestActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_request);

        webView = findViewById(R.id.webviewCu4);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSe0b1iVWbi8zDriHW-eWXjCE1I_ihjRQEQpBLhMZXmeft9vPA/viewform");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }

    }
}
