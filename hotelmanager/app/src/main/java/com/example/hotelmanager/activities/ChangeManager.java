package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.hotelmanager.R;
import com.example.hotelmanager.views.InputView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ChangeManager extends BaseActivity {

    private InputView etId,etName,etSfzh,etPhone;
    private Button btnSubmit,btnLook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_manager);

        initView();
    }

    private void initView() {
        initNavBar(true,"经理信息管理",false);

        etId = findViewById(R.id.input_id);
        etName = findViewById(R.id.input_name);
        etSfzh = findViewById(R.id.input_sfzh);
        etPhone = findViewById(R.id.input_phone);
        btnSubmit = findViewById(R.id.submit);
        btnLook = findViewById(R.id.look);

    }

    public void ChangeManagerRequest(final String id, final String name,final String sfzh) {
        //Toast.makeText(this,id+" "+name+" "+sfzh,Toast.LENGTH_SHORT).show();
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/changeManagerServlet";
        String tag = "ChangeManager";
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
                                Toast.makeText(ChangeManager.this, "修改成功!", Toast.LENGTH_SHORT).show();
                                //logout(ChangePassword.this);
                            }else if (result.equals("ChangeFail")) {
                                Toast.makeText(ChangeManager.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangeManager.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
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
                params.put("id", id);
                params.put("name", name);
                params.put("sfzh", sfzh);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    public void onSubmitClick(View view) {

        String id = etId.getInputStr();
        String name = etName.getInputStr();
        String sfzh = etSfzh.getInputStr();

        if(id.isEmpty()){
            Toast.makeText(this,"请输入目标id",Toast.LENGTH_SHORT).show();
        }else {
            ChangeManagerRequest(id,name,sfzh);
        }

    }

    public void onLookClick(View view) {
        startActivity(new Intent(this,LookManager.class));
    }
}