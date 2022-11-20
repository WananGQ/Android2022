package com.example.notepad;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.InputType;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EditActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView iv_back,iv_sure;
    private ImageView iv_text,iv_cemera,iv_music,iv_video,iv_write;
    private LineEditText et_Notes;
    private List<Map<String,String>> imgList = new ArrayList<Map<String,String>>();
    InputMethodManager imm;
    private EditText et_title;
    private NoteDatabase noteDatabase;
    private DataDao dataDao;
    private String editModel;
    private int item_Id;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        intent = getIntent();
        editModel = intent.getStringExtra("editModel");
        item_Id = intent.getIntExtra("noteId", 0);
        initview();
        noteDatabase=NoteDatabase.getDatabase(this);
        dataDao=noteDatabase.getDataDao();
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(et_Notes.getWindowToken(),0);
        initdata();
    }

    private void initdata() {
        if(editModel!=null){
            Data nowd=dataDao.findById(item_Id);
            et_title.setText(nowd.getTitle());
            String context=nowd.getContent();
            Pattern p=Pattern.compile("/([^\\.]*)\\.\\w{3}");
            Matcher m=p.matcher(context);
            int startIndex = 0;
            while(m.find()){
                if(m.start() > 0){
                    et_Notes.append(context.substring(startIndex, m.start()));
                }
                SpannableString ss = new SpannableString(m.group().toString());
                String path = m.group().toString();
                String type = path.substring(path.length() - 3, path.length());
                Bitmap bm = null;
                Bitmap rbm = null;
                if(type.equals("amr")){
                    bm = BitmapFactory.decodeResource(getResources(), R.drawable.iv_music);
                    rbm = resize(bm,200);
                }
                else{
                    bm = BitmapFactory.decodeFile(m.group());
                    rbm = resize(bm,480);
                }
                rbm = getBitmapHuaSeBianKuang(rbm);
                ImageSpan span = new ImageSpan(this, rbm);
                ss.setSpan(span,0, m.end() - m.start(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                System.out.println(m.start()+"-------"+m.end());
                et_Notes.append(ss);
                startIndex = m.end();
                Map<String,String> map = new HashMap<String,String>();
                map.put("location", m.start()+"-"+m.end());
                map.put("path", path);
                imgList.add(map);
            }
            et_Notes.append(context.substring(startIndex,context.length()));
        }
    }

    //为EidtText设置监听器
    class TextClickEvent implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Spanned s = et_Notes.getText();
            ImageSpan[] imageSpans;
            imageSpans = s.getSpans(0, s.length(), ImageSpan.class);

            int selectionStart = et_Notes.getSelectionStart();
            System.out.println(selectionStart);
            for(ImageSpan span : imageSpans){
                int start = s.getSpanStart(span);
                int end = s.getSpanEnd(span);
                System.out.println(start+"++++++++++++++++"+end);
                //找到图片
                if(selectionStart >= start && selectionStart < end){
                    //Bitmap bitmap = ((BitmapDrawable)span.getDrawable()).getBitmap();
                    //查找当前单击的图片是哪一个图片
                    System.out.println(start+"-----------"+end);
                    String path = null;
                    for(int i = 0;i < imgList.size();i++){
                        Map map = imgList.get(i);
                        //找到了
                        if(map.get("location").equals(start+"-"+end)){
                            path = imgList.get(i).get("path");
                            break;
                        }
                    }
                    System.out.println(path);
                    if(path==null) break;
                    //接着判断当前图片是否是录音，如果为录音，则跳转到试听录音的Activity，如果不是，则跳转到查看图片的界面
                    //录音，则跳转到试听录音的Activity
                    if(path.substring(path.length()-3, path.length()).equals("amr")){
                        Intent intent = new Intent(EditActivity.this,ShowRecord.class);
                        intent.putExtra("audioPath", path);
                        startActivity(intent);
                    }
                    //图片，则跳转到查看图片的界面
                    else{
                        Intent intent = new Intent(EditActivity.this,ShowPicture.class);
                        intent.putExtra("imgPath", path);
                        startActivity(intent);
                    }
                }
                else
                    //如果单击的是空白出或文字，则获得焦点，即打开软键盘
                    imm.showSoftInput(et_Notes, 0);
            }
        }
    }
    private  void initview(){
        et_title=findViewById(R.id.edit_et_title);
        et_Notes=(LineEditText)findViewById(R.id.Edit_iv);
        iv_back=findViewById(R.id.edit_iv_back);
        iv_sure=findViewById(R.id.edit_iv_true);
        iv_text=findViewById(R.id.main_bottom_iv_text);
        iv_cemera=findViewById(R.id.main_bottom_iv_cemera);
        iv_music=findViewById(R.id.main_bottom_iv_music);
        iv_video=findViewById(R.id.main_bottom_iv_video);
        iv_write=findViewById(R.id.main_bottom_iv_write);
        et_Notes.setOnClickListener(new TextClickEvent());
        iv_back.setOnClickListener(this);
        iv_sure.setOnClickListener(this);
        iv_text.setOnClickListener(this);
        iv_cemera.setOnClickListener(this);
        iv_music.setOnClickListener(this);
        iv_video.setOnClickListener(this);
        iv_write.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.edit_iv_back://返回
                EditActivity.this.finish();
                break;

            case R.id.edit_iv_true://保存数据库
                String context=et_Notes.getText().toString();
                String title=et_title.getText().toString();
                if(context.isEmpty()||title.isEmpty()){
                    Toast.makeText(EditActivity.this, "记事为空,请先输入内容", Toast.LENGTH_LONG).show();
                }
                else{
                    SimpleDateFormat formatter=new   SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date curDate=new Date(System.currentTimeMillis());
                    String time =formatter.format(curDate);
                    if(editModel!=null){//修改记事
                        Data dd=dataDao.findById(item_Id);
                        dd.setContent(context);
                        dd.setData(time);
                        dd.setTitle(title);
                        System.out.println(dataDao.update_all(dd));
                    }
                    else{
                        Data td=new Data(title,context,time);
                        dataDao.insertData(td);
                    }
                    EditActivity.this.finish();
                }
                break;
            case R.id.main_bottom_iv_text:

                break;
            case R.id.main_bottom_iv_cemera:
                intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,1);
                break;
            case R.id.main_bottom_iv_music:
                intent=new Intent(EditActivity.this,RecordActivity.class);
                startActivityForResult(intent,2);
                break;
            case R.id.main_bottom_iv_video:
                intent=new Intent(EditActivity.this,VideoActivity.class);
                startActivityForResult(intent,2);
                break;
            case R.id.main_bottom_iv_write:
                intent=new Intent(EditActivity.this,PaintActivity.class);
                startActivityForResult(intent,4);
                break;
        }
    }
//1拍照 2录音 3录像 4手写板
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri uri=data.getData();//获得取回的数据
            ContentResolver cr=EditActivity.this.getContentResolver();///内容提供者
            Bitmap bitmap=null;
            Bundle extras=null;//1拍照 2录音 3录像 4手写板
            if(requestCode==1){//拍照
                try {
                    if(uri!=null){
                        bitmap=MediaStore.Images.Media.getBitmap(cr,uri);}
                    else{
                        extras=data.getExtras();
                        bitmap=extras.getParcelable("data");
                    }
                    SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyyMMddHHmmss");
                    Date   curDate   =   new Date(System.currentTimeMillis());//获取当前时间
                    String   str   =   formatter.format(curDate);
                    String paintPath = "";
                    str = str + "paint.png";
                    File dir = new File("/sdcard/notes/");
                    File file = new File("/sdcard/notes/",str);
                    if (!dir.exists()) {
                        dir.mkdir();}
                    else{
                        if(file.exists()){
                            file.delete();
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(file);
                    // 将 bitmap 压缩成其他格式的图片数据
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.flush();
                    fos.close();
                    String path = "/sdcard/notes/" + str;
                    //插入图片
                    System.out.println(path);
                    InsertBitmap(bitmap,480,path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(requestCode==2){//录音
                extras = data.getExtras();
                String path = extras.getString("audio");
                bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.iv_music);
                //插入录音图标
                InsertBitmap(bitmap,400,path);
            }
            else if(requestCode==3){//录像

            }
            else if(requestCode==4){//手写板
                extras=data.getExtras();
                String path=extras.getString("paintPath");
                bitmap= BitmapFactory.decodeFile(path);
                InsertBitmap(bitmap,400,path);
            }
        }
    }

    private void InsertBitmap(Bitmap bitmap, int S, String imgPath) {
        bitmap = resize(bitmap,S);
        //添加边框效果
        bitmap = getBitmapHuaSeBianKuang(bitmap);
        //bitmap = addBigFrame(bitmap,R.drawable.line_age);
        final ImageSpan imageSpan = new ImageSpan(this,bitmap);
        SpannableString spannableString = new SpannableString(imgPath);
        spannableString.setSpan(imageSpan, 0, spannableString.length(), SpannableString.SPAN_MARK_MARK);
        //光标移到下一行
        //et_Notes.append("\n");
        Editable editable = et_Notes.getEditableText();
        int selectionIndex = et_Notes.getSelectionStart();
        spannableString.getSpans(0, spannableString.length(), ImageSpan.class);

        //将图片添加进EditText中
        editable.insert(selectionIndex, spannableString);
        //添加图片后自动空出两行
        et_Notes.append("\n");

        //用List记录该录音的位置及所在路径，用于单击事件
        Map<String,String> map = new HashMap<String,String>();
        map.put("location", selectionIndex+"-"+(selectionIndex+spannableString.length()));
        map.put("path", imgPath);
        imgList.add(map);
    }
    //等比例缩放图片
    private Bitmap resize(Bitmap bitmap,int S){
        int imgWidth = bitmap.getWidth();
        int imgHeight = bitmap.getHeight();
        double partion = imgWidth*1.0/imgHeight;
        double sqrtLength = Math.sqrt(partion*partion + 1);
        //新的缩略图大小
        double newImgW = S*(partion / sqrtLength);
        double newImgH = S*(1 / sqrtLength);
        float scaleW = (float) (newImgW/imgWidth);
        float scaleH = (float) (newImgH/imgHeight);

        Matrix mx = new Matrix();
        //对原图片进行缩放
        mx.postScale(scaleW, scaleH);
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, imgWidth, imgHeight, mx, true);
        return bitmap;
    }
    //给图片加边框，并返回边框后的图片
    public Bitmap getBitmapHuaSeBianKuang(Bitmap bitmap) {
        float frameSize = 0.2f;
        Matrix matrix = new Matrix();

        // 用来做底图
        Bitmap bitmapbg = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);

        // 设置底图为画布
        Canvas canvas = new Canvas(bitmapbg);
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG
                | Paint.FILTER_BITMAP_FLAG));

        float scale_x = (bitmap.getWidth() - 2 * frameSize - 2) * 1f
                / (bitmap.getWidth());
        float scale_y = (bitmap.getHeight() - 2 * frameSize - 2) * 1f
                / (bitmap.getHeight());
        matrix.reset();
        matrix.postScale(scale_x, scale_y);

        // 对相片大小处理(减去边框的大小)
        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                bitmap.getHeight(), matrix, true);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1);
        paint.setStyle(Paint.Style.FILL);

        // 绘制底图边框
        canvas.drawRect(
                new Rect(0, 0, bitmapbg.getWidth(), bitmapbg.getHeight()),
                paint);
        // 绘制灰色边框
        paint.setColor(Color.WHITE);
        canvas.drawRect(
                new Rect((int) (frameSize), (int) (frameSize), bitmapbg
                        .getWidth() - (int) (frameSize), bitmapbg.getHeight()
                        - (int) (frameSize)), paint);

        canvas.drawBitmap(bitmap, frameSize + 1, frameSize + 1, paint);

        return bitmapbg;
    }
}