package com.example.english_for_hotel_managment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Reception extends AppCompatActivity {

    TextToSpeech textToSpeech;
    ImageView buttonspeech,buttonspeech1,buttonspeech2,buttonspeech3;
    TextView textView,textViewone,textViewtwo,textViewthree;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recption_activity);

        toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" English for Hotel ");
        toolbar.setTitleTextColor(getResources().getColor(R.color.yello));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonspeech = findViewById(R.id.bttspeech);
        buttonspeech1 = findViewById(R.id.bttspeech1);
        buttonspeech2 = findViewById(R.id.bttspeech2);
        buttonspeech3 = findViewById(R.id.bttspeech3);

        textView = findViewById(R.id.textvo);
        textViewone = findViewById(R.id.textvo1);
        textViewtwo = findViewById(R.id.textvo2);
        textViewthree = findViewById(R.id.textvo3);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status ==TextToSpeech.SUCCESS){
                    int ttsLang = textToSpeech.setLanguage(Locale.US);

                    if (ttsLang == TextToSpeech.LANG_MISSING_DATA
                    || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","The Language is not supported!");
                    }else {
                        Log.i("TTS", "Language Supported.");
                    }
                    Log.i("TTS", "Initialization success.");
                }
                else {
                    Toast.makeText(getApplicationContext(),"TTS Initialization failed!",Toast.LENGTH_SHORT).show();
                }

            }
        });
              buttonspeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textView.getText().toString();
                Log.i("TTS", "button clicked: " + data);
                int speechStatus = textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);

                if (speechStatus ==TextToSpeech.ERROR){
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
                Toast.makeText(getApplicationContext(),"TTS Initialization failed!",Toast.LENGTH_SHORT).show();
            }
        });
        buttonspeech1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textViewone.getText().toString();
                Log.i("TTS", "button clicked: " + data);
                int speechStatus = textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);

                if (speechStatus ==TextToSpeech.ERROR){
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
                Toast.makeText(getApplicationContext(),"TTS Initialization failed!",Toast.LENGTH_SHORT).show();
            }
        });
        buttonspeech2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textViewtwo.getText().toString();
                Log.i("TTS", "button clicked: " + data);
                int speechStatus = textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);

                if (speechStatus ==TextToSpeech.ERROR){
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
                Toast.makeText(getApplicationContext(),"TTS Initialization failed!",Toast.LENGTH_SHORT).show();
            }
        });

        buttonspeech3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = textViewthree.getText().toString();
                Log.i("TTS", "button clicked: " + data);
                int speechStatus = textToSpeech.speak(data,TextToSpeech.QUEUE_FLUSH,null);

                if (speechStatus ==TextToSpeech.ERROR){
                    Log.e("TTS", "Error in converting Text to Speech!");
                }
                Toast.makeText(getApplicationContext(),"TTS Initialization failed!",Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (textToSpeech != null){
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
