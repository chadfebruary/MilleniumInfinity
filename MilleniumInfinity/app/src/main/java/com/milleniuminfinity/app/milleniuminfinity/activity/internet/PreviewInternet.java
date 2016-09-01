package com.milleniuminfinity.app.milleniuminfinity.activity.internet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;
import com.milleniuminfinity.app.milleniuminfinity.repository.internet.Impl.InternetRepositoryImpl;

public class PreviewInternet extends AppCompatActivity {

    Internet internet;
    TextView isp, planName, price, dataAllowance, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_internet);

        Bundle extras = getIntent().getExtras();
        internet = (Internet)extras.getSerializable("INTERNET");

        isp = ((TextView)findViewById(R.id.textView10));
        isp.setText(internet.getISP());

        planName = ((TextView)findViewById(R.id.textView11));
        planName.setText(internet.getPlanName());

        price = ((TextView)findViewById(R.id.textView12));
        price.setText(internet.getPrice());

        dataAllowance = ((TextView)findViewById(R.id.textView13));
        dataAllowance.setText(internet.getDataAllowance());

        type = ((TextView)findViewById(R.id.textView14));
        type.setText(internet.getType());
    }

    public void addToDatabase(View v){

        InternetRepositoryImpl internetRepository = new InternetRepositoryImpl(this.getApplicationContext());

        Internet internet = new Internet.Builder()
                .ISP(isp.getText().toString())
                .planName(planName.getText().toString())
                .price(price.getText().toString())
                .dataAllowance(dataAllowance.getText().toString())
                .type(type.getText().toString())
                .build();

        internetRepository.save(internet);
        Intent intent = new Intent(this, InternetMenu.class);
        startActivity(intent);
    }
}
