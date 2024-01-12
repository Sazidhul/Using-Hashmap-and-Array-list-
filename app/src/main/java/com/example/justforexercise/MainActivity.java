package com.example.justforexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ListView myListView ;
    ArrayList <HashMap < String, String> > arrayList = new ArrayList<>(); // new table reday hobe
    HashMap < String, String > hashMap; // 1 ta key arata value

     @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListView = findViewById(R.id.listView);

        hashMap = new HashMap<>();
        hashMap.put("Name","Tony Stark");
        hashMap.put("Mobile","999");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Bil Gates");
        hashMap.put("Mobile","111");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","Elone mask ");
        hashMap.put("mobile","333");
        arrayList.add(hashMap);


        MyAdapter myAdapter = new MyAdapter();

        myListView.setAdapter(myAdapter);

    }
    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             View myView = layoutInflater.inflate(R.layout.item,viewGroup,false);

            ImageView imageView = myView.findViewById(R.id.imageView);
            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvMobile = myView.findViewById(R.id.tvMobile);

            HashMap<String, String> hashMap = arrayList.get(position);

            tvName.setText(hashMap.get("name"));
            tvMobile.setText(hashMap.get("mobile"));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(),"Hello\nItem number: "+position, Toast.LENGTH_SHORT).show();

                }
            });

            return myView;
        }
    }

}