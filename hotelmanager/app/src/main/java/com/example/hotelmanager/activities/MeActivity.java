package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hotelmanager.R;
import com.example.hotelmanager.help.UserHelp;
import com.example.hotelmanager.utils.SPUtils;

public class MeActivity extends BaseActivity {

    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);


        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
        initNavBar(true,"个人中心",false);

        TextView mTvUser = findViewById(R.id.tv_user);
        mTvUser.setText("用户名："+ UserHelp.getInstance().getPhone());
    }

    //修改密码点击事件
    public void onChangeClick(View v){
        username = UserHelp.getInstance().getPhone();
        Intent intent = new Intent(this,ChangePassword.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    //退出登录点击事件
    public void onLogoutClick(View v){
        logout(this);
    }

    //退出登录
    public static void logout(Context context){

        //删除SP保存的用户标记
        boolean isRemove = SPUtils.removeUser(context);

        if(!isRemove){
            Toast.makeText(context,"系统错误，请稍后重试",Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(context, Login.class);
        //添加 intent标识符，清理 task栈，并且新生成一个 task栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

    }
}