package com.example.gymmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webviewactivity extends AppCompatActivity {
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webviewactivity);
        webview=findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().getJavaScriptEnabled();
        webview.loadUrl("https://uwaterloo.ca/");


    }

    @Override
    public void onBackPressed() {
        if(webview.canGoBack()){
            webview.goBack();
        }else{
            super.onBackPressed();
        }
    }
}