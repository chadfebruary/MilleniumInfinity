package com.milleniuminfinity.app.milleniuminfinity.activity.internet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.milleniuminfinity.app.milleniuminfinity.R;
import com.milleniuminfinity.app.milleniuminfinity.domain.internet.Internet;
import com.milleniuminfinity.app.milleniuminfinity.repository.internet.Impl.InternetRepositoryImpl;
import com.milleniuminfinity.app.milleniuminfinity.repository.internet.InternetRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ViewInternet extends AppCompatActivity {

    ArrayAdapter adapter;
    ListView listView;
    String[]objects;
    Set<Internet> internetSet = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_internet);

        InternetRepository internetRepository = new InternetRepositoryImpl(this.getApplicationContext());

        internetSet = new HashSet<>();
        internetSet = internetRepository.findAll();

        Iterator<Internet>internetIterator = internetSet.iterator();

        if(internetSet.size() > 0)
        {
            objects = new String[internetSet.size()];
            int i = 0;

            while(internetIterator.hasNext())
            {
                objects[i] = internetIterator.next().toString();
                i++;
            }

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, objects);
            listView = (ListView) findViewById(R.id.listView2);
            listView.setAdapter(adapter);
        }
        else
        {
            Toast.makeText(ViewInternet.this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}
