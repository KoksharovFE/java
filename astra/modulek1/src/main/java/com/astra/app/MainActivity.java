package com.astra.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends Activity  {//implements View.OnTouchListener

//    float x;
//    float y;
    //private GestureDetector gestureScanner;
    //protected TextView tvName;
    //protected EditText editText;
    protected ListView lvMain;
//    protected Button button, button1,button2,button3,button4,button5;
    protected EditText etName,editText1,editText2,editText3,editText4,editText5;
    int counter = 0;
    String[] outRes;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        button = (Button) findViewById(R.id.button);
//        button1 = (Button) findViewById(R.id.button1);
//        button2 = (Button) findViewById(R.id.button2);
//        button3 = (Button) findViewById(R.id.button3);
//        button4 = (Button) findViewById(R.id.button4);
//        button5 = (Button) findViewById(R.id.button5);
        //Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show();//всплывающее окно
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        lvMain = (ListView) findViewById(R.id.lvMain);
//        etName = (EditText) findViewById(R.id.editText1);
        outRes=new String[5];
//        button.setWidth(150);
//        button.setOnClickListener(this);
//        button1.setOnClickListener(this);
//        button2.setOnClickListener(this);
//        button3.setOnClickListener(this);
//        button4.setOnClickListener(this);
//        button5.setOnClickListener(this);
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
        setContentView(R.layout.inputform1);
    }
    public void buttonClicked1(View view)  {

        outRes[0]=editText1.getText().toString();
        setContentView(R.layout.inputform2);
    }
    public void buttonClicked2(View view)  {

        outRes[1]=editText2.getText().toString();
        setContentView(R.layout.inputform3);
    }
    public void buttonClicked3(View view)  {

        outRes[2]=editText3.getText().toString();
        setContentView(R.layout.inputform4);
    }
    public void buttonClicked4(View view)  {

        outRes[3]=editText4.getText().toString();
        setContentView(R.layout.inputform5);
    }
    public void buttonClicked5(View view)  {
        outRes[4]=editText5.getText().toString();
        setContentView(R.layout.activity_main);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, outRes);
        lvMain.setAdapter(adapter);
    }














/*
    @Override
    public void onClick(View view) {
       switch(view.getId()){
            case R.id.button: {
                setContentView(R.layout.inputform1);
                break;
            }
            case R.id.button1: {
                setContentView(R.layout.inputform2);
                outRes[0]=editText1.getText().toString();
                break;
            }
            case R.id.button2: {
                setContentView(R.layout.inputform3);
                outRes[1]=editText1.getText().toString();
                break;
            }
            case R.id.button3: {
                setContentView(R.layout.inputform4);
                outRes[2]=editText1.getText().toString();
                break;
            }
            case R.id.button4: {
                setContentView(R.layout.inputform5);
                outRes[3]=editText1.getText().toString();
                break;
            }
            case R.id.button5: {
                outRes[4]=editText1.getText().toString();
                setContentView(R.layout.activity_main);
                adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, outRes);
                lvMain.setAdapter(adapter);
                break;
            }

        }
    }*/
/*//        String[] t = etName.getText().toString().split(" ");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, t);
//        lvMain.setAdapter(adapter);
        //"@string/name: "+etName.getText().toString();
        if(counter==0){
            setContentView(R.layout.inputform1);
            Button button2 = (Button) findViewById(R.id.button2);
//            counter=1;
        } else {
            setContentView(R.layout.activity_main);
            Button button1 = (Button) findViewById(R.id.button);
//            outRes[0]=etName.getText().toString();
//            outRes[1]=etName.getText().toString();
//            outRes[2]=etName.getText().toString();
//            outRes[3]=etName.getText().toString();
//            outRes[4]=etName.getText().toString();
//            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                    android.R.layout.simple_list_item_1, outRes);
//            lvMain.setAdapter(adapter);
//            counter=0;





//        intent = new Intent(this, Questions.class);
//        startActivityForResult(intent, 1);

/*        switch(counter){
            case 0:{
                outRes[0]="@string/name: "+etName.getText().toString();
                counter++;
                setContentView(R.layout.inputform1);
                break;
            }
            case 1:{
                outRes[1]="@string/surname: "+etName.getText().toString();
                counter++;
                setContentView(R.layout.inputform2);
                break;
            }
            case 2:{
                outRes[2]="@string/hobby: "+etName.getText().toString();
                counter++;
                setContentView(R.layout.inputform3);
                break;
            }
            case 3:{
                outRes[3]="@string/education: "+etName.getText().toString();
                counter++;
                setContentView(R.layout.inputform4);
                break;
            }
            case 4:{
                outRes[4]="@string/birth_data: "+etName.getText().toString();
                counter++;
                setContentView(R.layout.inputform5);
                break;
            }
            case 5:{
                setContentView(R.layout.activity_main);
                counter=0;
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, outRes);
                lvMain.setAdapter(adapter);
                break;
            }

        }
        */


    /*@Override
    public boolean onTouch(View view, MotionEvent event) {
        x = event.getX();
        y = event.getY();
        //imageN=imageN%5+1;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {// нажатие
                break;
            }
            case MotionEvent.ACTION_MOVE: // движение
                break;
            case MotionEvent.ACTION_UP: // отпускание
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }*/
    /*@Override
       protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {return;}
        //String name = data.getStringExtra("name");
        String[] output ;
        output =data.getStringArrayExtra("name");
        //tvName.setText("Your name is " + name);
        //String[] t = editText.getText().toString().split(" ");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, output);
        lvMain.setAdapter(adapter);

    }*/
}