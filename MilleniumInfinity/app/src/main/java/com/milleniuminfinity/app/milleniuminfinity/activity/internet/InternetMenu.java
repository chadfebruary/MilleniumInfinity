package com.milleniuminfinity.app.milleniuminfinity.activity.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;

public class InternetMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_menu);
    }

    public void addInternet(View v)
    {
        Intent intent = new Intent(this, AddInternet.class);
        startActivity(intent);
    }

    public void viewInternet(View v)
    {
        Intent intent = new Intent(this, ViewInternet.class);
        startActivity(intent);
    }
}
