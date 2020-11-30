package com.example.hotelmanager.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.blankj.utilcode.util.RegexUtils;
import com.example.hotelmanager.R;
import com.example.hotelmanager.help.UserHelp;
import com.example.hotelmanager.utils.SPUtils;
import com.example.hotelmanager.views.InputView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends BaseActivity {

    private InputView mInputId, mInputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    //初始化View
    private void initView() {
        initNavBar(false, "登录", false);

        mInputId = findViewById(R.id.input_phone);
        mInputPassword = findViewById(R.id.input_password);
    }


    //登录点击事件
    public void onCommitClick(View v) {
        String id = mInputId.getInputStr();
        String password = mInputPassword.getInputStr();

        //验证输入是否合法
        if (!validateLogin(this, id, password)) {
            return;
        }

        SignInRequest(id, password);

    }

    //验证用户输入合法性
    public static boolean validateLogin(Context context, String phone, String password) {
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "用户id无效", Toast.LENGTH_SHORT).show();
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }


        //保存用户登录标记
        boolean isSaved = SPUtils.saveUser(context, phone);
        if (!isSaved) {
            Toast.makeText(context, "系统错误，请稍后重试", Toast.LENGTH_SHORT).show();
            return false;
        }

        UserHelp.getInstance().setPhone(phone);

        return true;
    }

    public void onForgetClick(View view) {
        String id = mInputId.getInputStr();

        //验证输入是否合法
        if (!validateForget(this, id)) {
            return;
        }
        UserHelp.getInstance().setPhone(id);
        //startActivity(new Intent(this,ChangePassword.class));
        ForgetRequest(id,"****");
    }

    private boolean validateForget(Login login, String phone) {
        if (!RegexUtils.isMobileExact(phone)) {
            Toast.makeText(this, "手机号无效", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void SignInRequest(final String username, final String password) {
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/loginServlet";
        String tag = "Login";
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
                            if (result.equals("TheUserDoesNotExist")) {
                                Toast.makeText(Login.this, "用户不存在", Toast.LENGTH_SHORT).show();
                            } else if (result.equals("PasswordError")) {
                                Toast.makeText(Login.this, "密码错误", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "登录成功", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                intent.putExtra("username", username);
                                startActivity(intent);
                                finish();
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

    public void ForgetRequest(final String username, final String password){
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/loginServlet";
        String tag = "Login";
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
                            if (result.equals("TheUserDoesNotExist")) {
                                Toast.makeText(Login.this, "用户不存在", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Login.this, "用户验证通过", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Login.this, ForgetPassword.class);
                                intent.putExtra("username",username);
                                startActivity(intent);
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