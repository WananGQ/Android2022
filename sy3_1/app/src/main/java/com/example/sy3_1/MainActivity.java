package com.example.sy3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private String[] names=new String[]{"Lion","Tiger","Monkey","Dog","Cat","Elephant"};
    private int[] imgs=new int[]{R.drawable.lion,R.drawable.tiger,R.drawable.monkey,R.drawable.dog,R.drawable.cat,R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Map<String,Object>> listItems=new ArrayList<>();
        for (int i=0;i<names.length;i++){
            Map<String,Object> listItem =new HashMap<>();
            listItem.put("name",names[i]);
            listItem.put("img",imgs[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter =new SimpleAdapter(this,listItems,R.layout.simple_item,new String[]{"name","img"},new int[]{R.id.name,R.id.img});
        ListView list=findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView=view.findViewById(R.id.name);
                Toast.makeText(MainActivity.this,textView.getText(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}