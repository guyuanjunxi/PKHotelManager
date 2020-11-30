package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class ChangeEmployees extends BaseActivity {

    private InputView etId,etName,etSfzh,etPhone;
    private Button btnSubmit,btnLook,btnAdd,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_employees);

        initView();
    }

    private void initView() {
        initNavBar(true,"员工信息管理",false);

        etId = findViewById(R.id.input_id);
        etName = findViewById(R.id.input_name);
        etSfzh = findViewById(R.id.input_sfzh);
        etPhone = findViewById(R.id.input_phone);
        btnSubmit = findViewById(R.id.submit);
        btnLook = findViewById(R.id.look);
        btnAdd = findViewById(R.id.add);
        btnDelete = findViewById(R.id.delete);

    }

    public void ChangeEmployeesRequest(final String id, final String name,final String sfzh,final String phone) {
        //Toast.makeText(this,id+" "+name+" "+sfzh+" "+phone,Toast.LENGTH_SHORT).show();
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/changeEmployeesServlet";
        String tag = "ChangeEmployees";
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
                                Toast.makeText(ChangeEmployees.this, "修改成功!", Toast.LENGTH_SHORT).show();
                            }else if (result.equals("ChangeFail")) {
                                Toast.makeText(ChangeEmployees.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangeEmployees.this, "修改失败，请重试", Toast.LENGTH_SHORT).show();
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
                params.put("phone", phone);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    public void AddEmployeesRequest(final String id, final String name,final String sfzh,final String phone) {
        //Toast.makeText(this,id+" "+name+" "+sfzh+" "+phone,Toast.LENGTH_SHORT).show();
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/addEmployeesServlet";
        String tag = "ChangeEmployees";
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
                            if (result.equals("AddSucceed")) {
                                Toast.makeText(ChangeEmployees.this, "添加成功!", Toast.LENGTH_SHORT).show();
                                //logout(ChangePassword.this);
                            }else if (result.equals("TheIdAlreadyExists")) {
                                Toast.makeText(ChangeEmployees.this, "id已存在，请重试", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(ChangeEmployees.this, "添加失败，请重试", Toast.LENGTH_SHORT).show();
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
                params.put("phone", phone);
                return params;
            }
        };

        //设置Tag标签
        request.setTag(tag);

        //将请求添加到队列中
        requestQueue.add(request);
    }

    public void DeleteEmployeesRequest(final String id) {
        //Toast.makeText(this,id,Toast.LENGTH_SHORT).show();
        //请求地址
        String url = "http://132.232.81.77:8080/HotelServer/deleteEmployeesServlet";
        String tag = "ChangeEmployees";
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
                            if (result.equals("DeleteSucceed")) {
                                Toast.makeText(ChangeEmployees.this, "删除成功!", Toast.LENGTH_SHORT).show();
                                //logout(ChangePassword.this);
                            }else if (result.equals("TheIdNotExists")) {
                                Toast.makeText(ChangeEmployees.this, "id不存在，请重试", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ChangeEmployees.this, "删除失败，请重试", Toast.LENGTH_SHORT).show();
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
        String phone = etPhone.getInputStr();

        ChangeEmployeesRequest(id,name,sfzh,phone);

    }

    public void onLookClick(View view) {

        startActivity(new Intent(this,LookEmployees.class));

    }

    public void onAddClick(View view) {

        String id = etId.getInputStr();
        String name = etName.getInputStr();
        String sfzh = etSfzh.getInputStr();
        String phone = etPhone.getInputStr();

        if(!id.isEmpty() && !name.isEmpty() && !sfzh.isEmpty() && !phone.isEmpty()){
            AddEmployeesRequest(id,name,sfzh,phone);
        }else {
            Toast.makeText(this,"请确认信息输入完整",Toast.LENGTH_SHORT).show();
        }


    }

    public void onDeleteClick(View view) {

        String id = etId.getInputStr();

        if(!id.isEmpty()){
            DeleteEmployeesRequest(id);
        }else {
            Toast.makeText(this,"请输入要删除目标的id",Toast.LENGTH_SHORT).show();
        }


        
    }
}