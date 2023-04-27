package it.spacecoding.twoactivities;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = (EditText) findViewById(R.id.editText_Main);
        mReplyHeadTextView = (TextView) findViewById(R.id.text_header_reply);
        mReplyTextView = (TextView) findViewById(R.id.text_message_reply);
    }

    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }
    public void onRestart(){
        super.onRestart();
        Log.d(LOG_TAG,"onRestart");
    }
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG,"Button main clicked");
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);
        Log.d(LOG_TAG,"Ecco il messaggio => " +message);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }

    }
}