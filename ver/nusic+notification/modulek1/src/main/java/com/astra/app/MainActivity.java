package com.astra.app;
/**
 *
 * @author Astramarii
 * */

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;


public class MainActivity extends Activity implements View.OnTouchListener {//implements View.OnTouchListener

//    float x;
//    float y;
    //private GestureDetector gestureScanner;
    //protected TextView tvName;
    //protected EditText editTex
    // t;
    ViewFlipper flipper;
    protected ListView lvMain;
//    protected Button button, button1,button2,button3,button4,button5;
    protected EditText etName,editText1,editText2,editText3,editText4,editText5;
    int counter = 0;
    String[] outRes;
    ArrayAdapter<String> adapter;
    float fromPosition;
    LayoutInflater inflater;
    private SoundPool soundPool;
    private int soundID;
    MediaPlayer mediaPlayer;
    NotificationManager mNotificationManager;
    private static final int NOTIFY_ID = 1; // Уникальный индификатор вашего уведомления в пределах класса
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Context.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Устанавливаем listener касаний, для последующего перехвата жестов
        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.layout);
        mainLayout.setOnTouchListener(this);
        // Получаем объект ViewFlipper
        flipper = (ViewFlipper) findViewById(R.id.flipper);
        // Создаем View и добавляем их в уже готовый flipper
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        int layouts[] = new int[]{ R.layout.inputform1, R.layout.inputform2, R.layout.inputform3, R.layout.inputform4, R.layout.inputform5, R.layout.voidform};
        for (int layout : layouts)
            flipper.addView(inflater.inflate(layout, null));
        soundID=0;
        //Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();//всплывающее окно
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        lvMain = (ListView) findViewById(R.id.lvMain);
        outRes=new String[5];
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // Создаем экземпляр менеджера уведомлений

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buttonClicked(View view)  {
        outRes[0]=editText1.getText().toString();
        outRes[1]=editText2.getText().toString();
        outRes[2]=editText3.getText().toString();
        outRes[3]=editText4.getText().toString();
        outRes[4]=editText5.getText().toString();
        //setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, outRes);
        lvMain.setAdapter(adapter);

        if(soundID==0){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.b80bf280be27); // создаём новый объект mediaPlayer
            mediaPlayer.start(); // запускаем воспроизведение
            soundID = (soundID + 1) ;
        }
        if(soundID% 2==0 && soundID!=0){
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.b80bf280be27); // создаём новый объект mediaPlayer
            mediaPlayer.start(); // запускаем воспроизведение
            soundID = (soundID + 1) ;
        } else {
            mediaPlayer.stop();
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fefcfcf4e61c); // создаём новый объект mediaPlayer
            mediaPlayer.start(); // запускаем воспроизведение
            soundID = (soundID + 1) ;
        }
        int icon = R.drawable.c4; // Иконка для уведомления, я решил воспользоваться стандартной иконкой для Email
        CharSequence tickerText = "Astrak1 wait"; // Подробнее под кодом
        long when = System.currentTimeMillis(); // Выясним системное время
        Notification notification = new Notification(icon, tickerText, when); // Создаем экземпляр уведомления, и передаем ему наши параметры
        Context context = getApplicationContext();
        //
        CharSequence contentTitle = "Astramarii presents"; // Текст заголовка уведомления при развернутой строке статуса
        CharSequence contentText = outRes[0]+":"+outRes[1]+":"+outRes[2]+":"+outRes[3]+":"+outRes[4]; //Текст под заголовком уведомления при развернутой строке статуса
        Intent notificationIntent = new Intent(this, MainActivity.class); // Создаем экземпляр Intent
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);// Подробное описание в UPD к статье
        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent); // Передаем в наше уведомление параметры вида при развернутой строке состояния
        mNotificationManager.notify(NOTIFY_ID, notification); // И наконец показываем наше уведомление через менеджер передав его ID

    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        float MOVE_LENGTH = 150;
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN: // Пользователь нажал на экран, т.е. начало движения
                // fromPosition - координата по оси X начала выполнения операции
                fromPosition = event.getX();
                break;
            // Вместо ACTION_UP
            case MotionEvent.ACTION_MOVE:
                float toPosition = event.getX();
                // MOVE_LENGTH - расстояние по оси X, после которого можно переходить на след. экран
                // В моем тестовом примере MOVE_LENGTH = 150
                if ((fromPosition - MOVE_LENGTH) > toPosition)
                {
                    fromPosition = toPosition;
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_next_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.go_next_out));
                    flipper.showNext();
                }
                else if ((fromPosition + MOVE_LENGTH) < toPosition)
                {
                    fromPosition = toPosition;
                    flipper.setInAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_in));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this,R.anim.go_prev_out));
                    flipper.showPrevious();
                }
                break;
            default:
                break;
        }
        return true;
    }

}