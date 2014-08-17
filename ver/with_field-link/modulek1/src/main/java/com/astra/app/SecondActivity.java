package com.astra.app;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class SecondActivity extends Activity implements ActionBar.OnNavigationListener, View.OnTouchListener {//,View.OnClickListener

    /**
     * The serialization (saved instance state) Bundle key representing the
     * current dropdown position.
     */
    private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
    float fromPosition;
    int counter = 0;
    protected TextView texts;
    protected EditText editText;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Set up the action bar to show a dropdown list.
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        // Set up the dropdown list navigation in the action bar.
        actionBar.setListNavigationCallbacks(
                // Specify a SpinnerAdapter to populate the dropdown list.
                new ArrayAdapter<String>(
                        actionBar.getThemedContext(),
                        android.R.layout.simple_list_item_1,
                        android.R.id.text1,
                        new String[] {
                                getString(R.string.title_section1),
                                getString(R.string.title_section2),
                                getString(R.string.title_section3),
                        }),
                this);

//        button3=(Button)findViewById(R.id.button3);
//        //button3.setOnClickListener(this);
//        button3.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String s;
//                s = editText.getText().toString();
//                if (s != null) {
//                    texts.setText(s);
//                } else {
//                    texts.setText("null");
//                }
//            }
//        });
        //texts = (TextView)findViewById(R.id.texts);
        texts = (TextView) findViewById(R.id.textViewS);
        editText = (EditText) findViewById(R.id.editTextS);
        texts.setLinksClickable(true);
        texts.setMovementMethod(new LinkMovementMethod());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Restore the previously serialized current dropdown position.
        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
            getActionBar().setSelectedNavigationItem(
                    savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Serialize the current dropdown position.
        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM,
                getActionBar().getSelectedNavigationIndex());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
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
    public boolean onNavigationItemSelected(int position, long id) {
        // When the given dropdown item is selected, show its contents in the
        // container view.
        getFragmentManager().beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
        return true;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
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
                    counter++;
                }
                else if ((fromPosition + MOVE_LENGTH) < toPosition)
                {
                    fromPosition = toPosition;
                    counter--;
                }
                break;
            default:
                break;
        }

        switch (counter%5){
            case 0:{
                //texts.setText(editText.getText().toString());
                texts.setBackgroundResource(R.color.bcWhite); // первый вариант
                break;
            }
            case 1:{
                texts.setBackgroundResource(R.color.bcBlue);
                break;
            }
            case 2:{
                texts.setBackgroundResource(R.color.bcGreen);
                break;
            }
            case 3:{
                texts.setBackgroundResource(R.color.bcRed);
                break;
            }
            case 4:{
                texts.setBackgroundResource(R.color.bcStrange);
                break;
            }
        }

        return true;
    }

    public void buttonClicked2(View view)  {
        switch (view.getId()) {
            case R.id.button3:{
                try {
                    String s;
                    s = editText.getText().toString();
                    if (s != null) {
                        texts.setText(s);
                        //texts.setText("Text Changed");
                    }
                } catch (NullPointerException e1){
                    texts.setText("null");
                }
                break;
            }
            case R.id.button4:{
                this.finish();
                break;
            }
        }

    }


    }