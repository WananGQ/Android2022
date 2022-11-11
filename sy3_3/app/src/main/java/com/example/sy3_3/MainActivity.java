package com.example.sy3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    字体大小
    private static final int FONT_S = 0x111;
    private static final int FONT_M = 0x112;
    private static final int FONT_L = 0x113;
    //    字体颜色
    private static final int FONT_RED = 0x114;
    private static final int FONT_BLACK = 0x115;
    //    普通菜单项
    private static final int PLAIN_ITEM = 0x116;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.txt);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        SubMenu fontMenu =menu.addSubMenu("字体大小");
        fontMenu.add(0,FONT_S,0,"小号字体");
        fontMenu.add(0,FONT_M,0,"中号字体");
        fontMenu.add(0,FONT_L,0,"大号字体");
        menu.add(0,PLAIN_ITEM,0,"普通菜单项");
        SubMenu colorMenu =menu.addSubMenu("字体颜色");
        colorMenu.add(0,FONT_RED,0,"红色");
        colorMenu.add(0,FONT_BLACK,0,"黑色");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case FONT_S:text.setTextSize(30); break;
            case FONT_M:text.setTextSize(40); break;
            case FONT_L:text.setTextSize(50); break;
            case PLAIN_ITEM:
                Toast.makeText(MainActivity.this,"普通菜单项",Toast.LENGTH_SHORT).show(); break;
            case FONT_RED:text.setTextColor(getResources().getColor(R.color.RED)); break;
            case FONT_BLACK:text.setTextColor(getResources().getColor(R.color.BLACK)); break;
        }
        return true;
    }
}