package com.raccourcis.ihm.ihm.home;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.raccourcis.ihm.ihm.contacts.ContactActivity;
import com.raccourcis.ihm.ihm.dailyActivities.AlarmActivity;
import com.raccourcis.ihm.ihm.R;

import java.util.ArrayList;
import java.util.List;

public class ReconnaissanceVocale extends AppCompatActivity {

    private static final int REQUEST_CODE = 1234;
    String phoneNumber;
    Intent intent;
    String url;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recog);
        Button speakButton = (Button) findViewById(R.id.speakButton);
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0)
        {
            speakButton.setEnabled(false);
            speakButton.setText("Recognizer not present");
        }
    }

    public void speakButtonClicked(View v)
    {
        startVoiceRecognitionActivity();
    }

    private void startVoiceRecognitionActivity()
    {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {

            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String mAnswer = results.get(0);
            if (mAnswer.toLowerCase().contains("alarm")) {
                intent = new Intent(ReconnaissanceVocale.this, AlarmActivity.class);
                startActivity(intent);
            }
            if (mAnswer.toLowerCase().contains("contact") ) {
                intent = new Intent(ReconnaissanceVocale.this, ContactActivity.class);
                startActivity(intent);
            }
            if (mAnswer.toLowerCase().contains("traduction ")) {
                url = "https://translate.google.com";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
            if (( mAnswer.toLowerCase().contains("call") || mAnswer.toLowerCase().contains("appel") ) && mAnswer.toLowerCase().contains("achraf") ) {
                phoneNumber = "tel:" + "0725441237";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
            if (( mAnswer.toLowerCase().contains("call") || mAnswer.toLowerCase().contains("appel") ) && mAnswer.toLowerCase().contains("ahmed") ) {
                phoneNumber = "tel:" + "0476881934";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
            if (( mAnswer.toLowerCase().contains("call") || mAnswer.toLowerCase().contains("appel") ) && mAnswer.toLowerCase().contains("rana") ) {
                phoneNumber = "tel:" + "0652421124";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
            if (( mAnswer.toLowerCase().contains("call") || mAnswer.toLowerCase().contains("appel") ) && mAnswer.toLowerCase().contains("peo") ) {
                phoneNumber= "tel:" + "0605899910";
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phoneNumber));
                startActivity(intent);
            }
            if (mAnswer.toLowerCase().contains("gmail")) {
                url = "http://www.gmail.com";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
            if (mAnswer.toLowerCase().contains("google")) {
                url = "https://www.google.com";
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
            if (mAnswer.toLowerCase().contains("youtube")) {
                url= "http://www.youtube.com";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
            if (mAnswer.toLowerCase().contains("map")) {
                url= "https://maps.google.com";
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}