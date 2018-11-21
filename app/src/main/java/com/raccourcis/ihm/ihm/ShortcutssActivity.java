package com.raccourcis.ihm.ihm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ShortcutssActivity extends AppCompatActivity {
    Button btn_shortcut ;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shortcut);
        btn_shortcut = (Button)findViewById(R.id.btn_shortcut);
        intent=null;
        btn_shortcut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent = new Intent(ShortcutssActivity.this, ApplicationsActivity.class);
                startActivity(intent);
            }
        });


    }
}
