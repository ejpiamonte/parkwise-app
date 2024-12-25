package com.example.firebaseauth;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import okhttp3.OkHttpClient;

public class Home extends AppCompatActivity {

    WebView web_view;
    OkHttpClient client;


    protected void onViewCreated(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        web_view = findViewById(R.id.web_view);
        // Configure related browser settings
        web_view.getSettings().setLoadsImagesAutomatically(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setSupportZoom(true);
        web_view.getSettings().setBuiltInZoomControls(true); // allow pinch to zoom
        web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        web_view.setWebViewClient(new WebViewClient());
        // Load the initial URL
        web_view.loadUrl("http://192.168.254.160:5000/video_feed");
    }
}
