package com.example.bigcash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class contactUs extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        webView = (WebView) findViewById(R.id.webviewCu);
        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdpd2nc_59k4xQoPL9eHhIT0k-WlxE2PR4DT83lAgLYH7XqSw/viewform");
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
