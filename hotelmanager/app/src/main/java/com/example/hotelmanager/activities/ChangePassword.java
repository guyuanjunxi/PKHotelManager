package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blankj.utilcode.util.EncryptUtils;
import com.example.hotelmanager.R;
import com.example.hotelmanager.help.UserHelp;
import com.example.hotelmanager.utils.SPUtils;
import com.example.hotelmanager.views.InputView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ChangePassword extends BaseActivity{

    private InputView mPassword,mPasswordConfirm;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        username = getIntent().getStringExtra("username");
        initView();
    }

    private void initView() {
        initNavBar(true,"修改密码",false);

        mPassword = findViewById(R.id.input_password);
        mPasswordConfirm = findViewById(R.id.input_password_confirm);

    }

    public void onChangePasswordClick(View v){
        String password = mPassword.getInputStr();
        String passwordConfirm = mPasswordConfirm.getInputStr();

        boolean result = changePassword(password,passwordConfirm);
        if(!result){
            return;
        }
        //Toast.makeText(this,username+" "+password,Toast.LENGTH_SHORT).show();
        ChangePasswordRequest(username,password);

    }

    public boolean changePassword(String password, String passwordConfirm){

        if(TextUtils.isEmpty(password) || !password.equals(passwordConfirm)){
            Toast.makeText(this,"请确认新密码",Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
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

    public void ChangePasswordRequest(final String username, final String password) {
        //Toast.makeText(this,username+" "+password,Toast.LENGTH_SHORT).show();
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/changePasswordServlet";
        String tag = "ChangePassword";
        //取得请求队列
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        //防止重复请求，所以先取消tag标识的请求队列
        requestQueue.cancelAll(tag);
        //创建StringRequest，定义字符串请求的请求方式为POST(省略第一个参数会默认为GET方式)

        final StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = (JSONObject) new JSONObject(response).get("params");
                            String result = jsonObject.getString("Result");
                            if (result.equals("ChangeSucceed")) {
                                Toast.makeText(ChangePassword.this, "修改成功!", Toast.LENGTH_SHORT).show();
                                logout(ChangePassword.this);
                            }else if (result.equals("ChangeFail")) {
                                Toast.makeText(ChangePassword.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangePassword.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            //做自己的请求异常操作，如Toast提示（“无网络连接”等）
                            Log.e("TAG", e.getMessage(), e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //做自己的响应错误操作，如Toast提示（“请稍后重试”等）
                Log.e("TAG", error.getMessage(), error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }
}