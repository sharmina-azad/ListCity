package com.example.simpleparadox.listycity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowActivity extends AppCompatActivity {

    TextView textview;
     Button button;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_activity);
        textview=findViewById(R.id.textView);
        button=findViewById(R.id.button);
        Bundle extra= getIntent().getExtras();
        textview.setText(extra.getString("cityname"));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowActivity.this.finish();
            }
        });
    }
}
