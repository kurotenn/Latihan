package com.example.kuroten.latihan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private  CustomListViewAdapter customListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] bookTitles = new String[]{
            "The Alchemist",
                "Si Biji",
                "Titanic",
                "Abrakadabra",
                "GO die",
                "attacker",
                "Sampoerna",
                "Wismilak",
        };
        final String[] bookpages = new String[]{
                "360",
                "250",
                "192",
                "568",
                "120",
                "175",
                "185",
                "250",

        };

        final String[] authors = new String[]{
                "Madafaka",
                "Shit lah",
                "Mempos",
                "Pikri",
                "Mentok",
                "bacol",
                "kotor",
                "Pikri",
                "naryo",
        };

        ArrayList<HashMap<String , String>> authorlist = new ArrayList<>();

        for (int i = 0; i <8; i++){
            HashMap<String, String> data = new HashMap<>();
            data.put("title", bookTitles[i]);
            data.put("pages", bookpages[i]);
            data.put("author", authors[i]);

            authorlist.add(data);
        }

        listView = (ListView) findViewById(R.id.list);

        // setup[ adapter
        customListViewAdapter = new CustomListViewAdapter(getApplicationContext(),authorlist);
        listView.setAdapter(customListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {

                int myposition = position;

                String itemClickedId = listView.getItemAtPosition(myposition).toString();

                Toast.makeText(getApplicationContext(), "Id Clicked" + itemClickedId, Toast.LENGTH_LONG).show();

            }
        });


    }
}
