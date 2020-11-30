package com.example.hotelmanager.activities;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.hotelmanager.R;

public class LookRoom extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_room);

        initView();
    }

    private void initView() {

        initNavBar(true,"客房信息管理",false);

        //获得控件
        WebView webView = (WebView) findViewById(R.id.wv_webview);
        //访问网页
        webView.loadUrl("http://132.232.81.77:8080/HotelServer/lookroom.jsp");
        //系统默认会通过手机浏览器打开网页，为了能够直接通过WebView显示网页，则必须设置
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用WebView加载显示url
                view.loadUrl(url);
                //返回true
                return true;
            }
        });
    }

}