package com.example.hotelmanager.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.hotelmanager.R;

public class MainActivity extends BaseActivity {

    private ImageView logo;
    private Button manager,employee,room,order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        initNavBar(false,"胖葵酒店管理系统",true);

        logo = findViewById(R.id.iv_logo);
        manager = findViewById(R.id.btn_manager);
        employee = findViewById(R.id.btn_employee);
        room = findViewById(R.id.btn_room);
        order = findViewById(R.id.btn_order);
    }

    public void onManagerClick(View view) {
        startActivity(new Intent(this,ChangeManager.class));
    }

    public void onEmployeeClick(View view) {
        startActivity(new Intent(this,ChangeEmployees.class));
    }

    public void onRoomClick(View view) {
        startActivity(new Intent(this,ChangeRoom.class));
    }

    public void onOrderClick(View view) {
        startActivity(new Intent(this,LookOrder.class));
    }
}