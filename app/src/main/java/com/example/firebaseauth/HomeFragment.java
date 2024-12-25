package com.example.firebaseauth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


public class HomeFragment extends Fragment {

    WebView web_view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        web_view = view.findViewById(R.id.web_view);
        // Configure related browser settings
        web_view.getSettings().setLoadsImagesAutomatically(true);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.getSettings().setSupportZoom(true);
        web_view.getSettings().setBuiltInZoomControls(true); // allow pinch to zoom
        web_view.getSettings().setUseWideViewPort(true);
        // Zoom out if the content width is greater than the width of the viewport
        web_view.getSettings().setLoadWithOverviewMode(true);
        web_view.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        web_view.setWebViewClient(new WebViewClient());
        // Load the initial URL
        web_view.loadUrl("http://192.168.254.160:5000/video_feed");

        return view;
    }
}