package com.astra.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class MainActivity extends Activity implements View.OnTouchListener {

//    private static final int MILLIS_PER_SECOND = 1000;
//    private static final int SECONDS_TO_COUNTDOWN = 30;
//    private TextView countdownDisplay;
//    private CountDownTimer timer;
//    protected WebView webView;
    float x;
    float y;
    public int imageN;
    private ImageView mImageView;
    private GestureDetector gestureScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final Button button = (Button) findViewById(R.id.SwapImage);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView1);
        mImageView.setImageResource(R.drawable.c1);
        imageN=1;
        mImageView.setOnTouchListener(this);
//        gestureScanner = new GestureDetector(getBaseContext(), (GestureDetector.OnGestureListener) this);

//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                // Perform action on click
//                imageN=imageN%5+1;
//                switch (imageN){
//                    case 1: {
//                        mImageView.setImageResource(R.drawable.c1);
//                    }
//                    case 2: {
//                        mImageView.setImageResource(R.drawable.c2);
//                    }
//                    case 3: {
//                        mImageView.setImageResource(R.drawable.c3);
//                    }
//                    case 4: {
//                        mImageView.setImageResource(R.drawable.c4);
//                    }
//                    case 5: {
//                        mImageView.setImageResource(R.drawable.c5);
//                    }
//
//                }
//            }
//            }
//        );
//        webView = (WebView) findViewById(R.id.webView1);
//        webView.setBackgroundColor(android.R.color.black);
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setBuiltInZoomControls(true);
//        webView.setPadding(0, 0, 0, 0);

        //setListAdapter(new MyAdapter(this, android.R.layout.simple_list_item_1,R.id.textView, getResources().getStringArray(R.array.wallpapers)));
//        countdownDisplay = (TextView) findViewById(R.id.time_display_box);
//        Button startButton = (Button) findViewById(R.id.startbutton);
//         startButton.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    try {
//                        showTimer(SECONDS_TO_COUNTDOWN * MILLIS_PER_SECOND);
//                    } catch (NumberFormatException e) {
//                        // method ignores invalid (non-integer) input and waits
//                        // for something it can use
//                    }
//                }
//         });
//
    }
//    public void click_swap_button(View view){
//                imageN=imageN%5+1;
//                switch (imageN){
//                    case 1: {
//                        mImageView.setImageResource(R.drawable.c1);
//                        break;
//                    }
//                    case 2: {
//                        mImageView.setImageResource(R.drawable.c2);
//                        break;
//                    }
//                    case 3: {
//                        mImageView.setImageResource(R.drawable.c3);
//                        break;
//                    }
//                    case 4: {
//                        mImageView.setImageResource(R.drawable.c4);
//                        break;
//                    }
//                    case 5: {
//                        mImageView.setImageResource(R.drawable.c5);
//                        break;
//                    }
//
//                }
//    }

//    private void showTimer(int countdownMillis) {
//        if(timer != null) { timer.cancel(); }
//        timer = new CountDownTimer(countdownMillis, MILLIS_PER_SECOND) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//                countdownDisplay.setText("counting down: " +
//                        millisUntilFinished / MILLIS_PER_SECOND);
//            }
//            @Override
//            public void onFinish() {
//                countdownDisplay.setText("End");
//            }
//        }.start();
//    }
//    private class MyAdapter extends ArrayAdapter<String>{
//        public MyAdapter(Context context, int resource, int textView, String[] strings) {
//            super(context, resource, textView, strings);
//        }
//        public View GetView(int position, View convertView, ViewGroup parent){
//            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            View row = inflater.inflate(R.layout.list_item, parent, false);
//            String[] items = getResources().getStringArray(R.array.wallpapers);
//            ImageView image1 = (ImageView) row.findViewById(R.id.imageView);
//            TextView text1 = (TextView) row.findViewById(R.id.textView);
//            text1.setText(items[position]);
//
//            if(items[position].equals("c1")){
//                image1.setImageResource(R.drawable.c1);
//            } else if (items[position].equals("c2")){
//                image1.setImageResource(R.drawable.c2);
//            } else if (items[position].equals("c3")){
//                image1.setImageResource(R.drawable.c3);
//            } else if (items[position].equals("c4")){
//                image1.setImageResource(R.drawable.c4);
//            } else if (items[position].equals("c5")){
//                image1.setImageResource(R.drawable.c5);
//            }
//
//            return row;
////            String sst = items[position].substring(1);
////            Integer sstI = Integer.parseInt(sst);
//
//        }
//
//
//    }


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

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        imageN=imageN%5+1;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {// нажатие
                switch (imageN){
                    case 1: {
                        mImageView.setImageResource(R.drawable.c1);
                        break;
                    }
                    case 2: {
                        mImageView.setImageResource(R.drawable.c2);
                        break;
                    }
                    case 3: {
                        mImageView.setImageResource(R.drawable.c3);
                        break;
                    }
                    case 4: {
                        mImageView.setImageResource(R.drawable.c4);
                        break;
                    }
                    case 5: {
                        mImageView.setImageResource(R.drawable.c5);
                        break;
                    }

                }
                break;
            }
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
