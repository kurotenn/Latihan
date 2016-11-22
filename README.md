# Latihan
Android Studio Tutorial - 56 ListView Customized

CustomListViewAdapter 
package com.example.kuroten.latihan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Kuroten on 11/20/2016.
 */

public class CustomListViewAdapter extends BaseAdapter {

    public Context mContext;
    private ArrayList<HashMap<String,String>> books;
    private LayoutInflater inflater = null;

    public CustomListViewAdapter(Context context, ArrayList<HashMap<String, String>>data){

        mContext = context;
        books = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(convertView == null){

            view = inflater.inflate(R.layout.list_row, null );

            TextView title = (TextView) view.findViewById(R.id.title);
            TextView author = (TextView) view.findViewById(R.id.authors);
            TextView pages = (TextView) view.findViewById(R.id.pages);
            ImageView image = (ImageView) view.findViewById(R.id.list_image);

            HashMap<String, String> mBook = new HashMap<>();

            mBook = books.get(position);

            title.setText(mBook.get("title"));
            author.setText(mBook.get("author"));
            pages.setText(mBook.get("pages"));
            image.setImageDrawable(mContext.getResources().getDrawable(R.mipmap.ic_launcher));

        }

        return view;
    }
}

MainActivity
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

res/drawable gradient_bg.xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <gradient
        android:startColor="#f1f1f2"
        android:centerColor="#e7e7e8"
        android:endColor="#cfcfcf"
        android:angle="270">

    </gradient>
</shape>

res/drawable gradient_bg_hover.xml
<?xml version="1.0" encoding="utf-8"?>
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">

    <gradient
        android:startColor="#ff50e552"
        android:centerColor="#ff18db34"
        android:endColor="#ff88b983"
        android:angle="270"></gradient>
    
</shape>

res/drawable list_selector.xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">

    <item
        android:state_selected="false"
        android:state_pressed="false"
        android:drawable="@drawable/gradient_bg"
        ></item>

    <item
        android:state_selected="false"
        android:drawable="@drawable/gradient_ng_hover"
        ></item>

    <item
        android:state_selected="false"
        android:drawable="@drawable/gradient_ng_hover"
        ></item>
</selector>

activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/activity_main"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:paddingBottom="@dimen/activity_vertical_margin"
    android:paddingLeft="@dimen/activity_horizontal_margin"
    android:paddingRight="@dimen/activity_horizontal_margin"
    android:paddingTop="@dimen/activity_vertical_margin"
    tools:context="com.example.kuroten.latihan.MainActivity">

    <ListView
        android:id="@+id/list"
        android:divider="#ff7ab59c"
        android:dividerHeight="1dp"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:listSelector="@drawable/list_selector"
        android:layout_alignParentTop="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true" />
</RelativeLayout>

list_row.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="fill_parent"
    android:background="@drawable/list_selector"
    android:layout_height="wrap_content"
    android:padding="5dp">

    <LinearLayout
        android:id="@+id/thumbnail"
        android:padding="32dp"
        android:background="#ffeeeade"
        android:layout_alignParentLeft="true"
        android:layout_marginRight="5dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="vertical">
            <ImageView
                android:id="@+id/list_image"
                android:layout_width="50dp"
                android:src="@mipmap/ic_launcher"
                android:layout_height="50dp" />
    </LinearLayout>
    <TextView
        android:id="@+id/title"
        android:layout_alignTop="@+id/thumbnail"
        android:text="The Alchemist"
        android:textStyle="bold"
        android:textColor="#040404"
        android:textSize="14sp"
        android:layout_toRightOf="@+id/thumbnail"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <TextView
        android:id="@+id/authors"
        android:layout_below="@+id/title"
        android:layout_toRightOf="@+id/thumbnail"
        android:text="Kuroten"
        android:layout_marginTop="2dp"
        android:textColor="#ffde3a3d"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
    <TextView
        android:id="@+id/pages"
        android:text="234 pages"
        android:layout_alignParentRight="true"
        android:layout_alignTop="@+id/title"
        android:gravity="right"
        android:layout_marginRight="10dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

</RelativeLayout>
