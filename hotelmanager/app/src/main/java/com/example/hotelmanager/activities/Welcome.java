package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import com.example.hotelmanager.R;
import com.example.hotelmanager.utils.SPUtils;

import java.util.Timer;
import java.util.TimerTask;

//延迟三秒自动跳转
public class Welcome extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        init();
    }

    private void init() {

        final boolean isLogin = validataUserLogin(this);

        Timer mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(isLogin){
                   toMain();
                }else{
                    toLogin();
                }

            }
        },3000);
    }

    private  void toLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }

    private  void toMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    //判断是否存在已登录用户
    public static boolean validataUserLogin(Context context){
        return SPUtils.isLoginUser(context);
    }

}