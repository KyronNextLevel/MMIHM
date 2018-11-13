package com.example.ahmed.testapp1;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
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
    private ListView wordsList;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voice_recog);
        Button speakButton = (Button) findViewById(R.id.speakButton);
        wordsList = (ListView) findViewById(R.id.list);
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
            wordsList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                    matches));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
