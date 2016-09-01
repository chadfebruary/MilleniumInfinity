package com.milleniuminfinity.app.milleniuminfinity.activity.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;

import java.io.Serializable;

public class AddInternet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_internet);
    }

    public void previewInternet(View v)
    {
        Intent intent = new Intent(this, PreviewInternet.class);

        String isp = ((EditText)findViewById(R.id.editText1)).getText().toString();
        String planName = ((EditText)findViewById(R.id.editText2)).getText().toString();
        String price = ((EditText)findViewById(R.id.editText3)).getText().toString();
        String dataAllowance = ((EditText)findViewById(R.id.editText4)).getText().toString();
        String type = ((EditText)findViewById(R.id.editText5)).getText().toString();

        Internet internet = new Internet.Builder()
                .ISP(isp)
                .planName(planName)
                .price(price)
                .dataAllowance(dataAllowance)
                .type(type)
                .build();

        intent.putExtra("INTERNET", internet);
        startActivity(intent);
    }
}
