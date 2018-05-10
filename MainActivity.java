package com.galukhin.learningandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Xml;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.xmlpull.v1.XmlPullParser;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    static final String ns = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView t = findViewById(R.id.textView);
       t.setText("test");

    }

}