package com.raccourcis.ihm.ihm;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ReconnaissanceVocale extends AppCompatActivity {

    private static final int REQUEST_CODE = 1234;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recog);
        Button speakButton = (Button) findViewById(R.id.speakButton);
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(
                new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
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
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice recognition Demo...");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK)
        {

            ArrayList<String> matches = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String mAnswer = results.get(0);
            if (mAnswer.equals("alarme")) {

                Intent intent = new Intent(ReconnaissanceVocale.this, AlarmActivity.class);
                //Bundle b = new Bundle();
                // b.putString("shortcut",mAnswer);
                // intent.putExtras(b);
                startActivity(intent);
            }
            if (mAnswer.equals("mes contacts favoris")) {

                Intent intent = new Intent(ReconnaissanceVocale.this, CarteVisite.class);
                //Bundle b = new Bundle();
                // b.putString("shortcut",mAnswer);
                // intent.putExtras(b);
                startActivity(intent);
            }
            if (mAnswer.equals("ouvre traduction ")) {

                String url3 = "https://translate.google.com";
                Intent iiii = new Intent(Intent.ACTION_VIEW);
                iiii.setData(Uri.parse(url3));
                startActivity(iiii);
            }
            if (mAnswer.equals("appeler Achraf")) {

                String telURI = "tel:" + "1234567";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(telURI));
                startActivity(intent);
            }
            if (mAnswer.equals("ouvre Gmail")) {

                String url5 = "http://www.gmail.com";
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(url5));
                startActivity(b);
            }
            if (mAnswer.equals("ouvre google")) {

                String url6 = "https://www.google.com";
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(url6));
                startActivity(c);
            }
            if (mAnswer.equals("ouvre YouTube")) {

                String url2 = "http://www.youtube.com";
                Intent iii = new Intent(Intent.ACTION_VIEW);
                iii.setData(Uri.parse(url2));
                startActivity(iii);

            }
            if (mAnswer.equals("ouvre maps")) {


                String url6 = "https://maps.google.com";
                Intent c = new Intent(Intent.ACTION_VIEW);
                c.setData(Uri.parse(url6));
                startActivity(c);
            }


        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}