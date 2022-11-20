package com.example.notepad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private NoteDatabase noteDatabase;
    private DataDao dataDao;
    private List<Data>mDatas=new ArrayList<>();
    private MainAdapter mainAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.main_ls);
        noteDatabase=NoteDatabase.getDatabase(this);
        dataDao=noteDatabase.getDataDao();
        mDatas=getData();
        mainAdapter=new MainAdapter(this,mDatas);
        lv.setAdapter(mainAdapter);
        lv.setOnItemLongClickListener(new ItemLongClickEvent());
    }
    int ii;
    //记事列表长按监听器
    class ItemLongClickEvent implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       int position, long id) {
            ii=0;
            final String []s={"查看本记事","删除本记事"};
            AlertDialog.Builder DanItem = new AlertDialog.Builder(MainActivity.this);
            DanItem.setTitle("选择想要进行的操作");
            DanItem.setSingleChoiceItems(s, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ii =which;
                }
            });
            DanItem.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which){
                    Toast.makeText(MainActivity.this, "你选择了"+s[ii], Toast.LENGTH_LONG).show();
                    Data tmpd=mDatas.get(position);
                    if(ii==1){
                        dataDao.deleteById(tmpd.getId());
                        mDatas=getData();
                        mainAdapter=new MainAdapter(MainActivity.this,mDatas);
                        lv.setAdapter(mainAdapter);
                    }
                    else if(ii==0){
                        Intent intent = new Intent(MainActivity.this,EditActivity.class);
                        intent.putExtra("editModel", "update");
                        intent.putExtra("noteId", tmpd.getId());
                        startActivity(intent);
                    }
                }
            });
            DanItem.create().show();
            return true;
        }

    }
    @Override
    protected void onStart() {
        super.onStart();
        noteDatabase=NoteDatabase.getDatabase(this);
        dataDao=noteDatabase.getDataDao();
        mDatas=getData();
        MainAdapter mainAdapter=new MainAdapter(this,mDatas);
        lv.setAdapter(mainAdapter);
    }

    public List<Data>getData(){
        return dataDao.findAll();
    }

    public void main_add(View view) {
        Intent intent=new Intent(this,EditActivity.class);
        startActivity(intent);
    }
}