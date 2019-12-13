package com.xtooltech.aptstep;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.xtooltech.ann.LogTag;

public class MainActivity extends AppCompatActivity {

    @LogTag
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
