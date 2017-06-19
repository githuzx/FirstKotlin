package com.kotlin.test.origin.test.java;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.kotlin.test.R;

/**
 * Created by Administrator on 2017/6/2.
 */

public class JActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        init();
        ext();
    }

    private void init() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("TAG", "click");
            }
        });
        btn2.setOnClickListener(view -> onBtn2());
    }

    private void onBtn2() {
        Runnable runnable = () -> Toast.makeText(this, "Hello world", Toast.LENGTH_SHORT).show();
        runnable.run();
    }

    private void ext() {
        View.OnClickListener oneArgument, multiline;
        oneArgument = view -> Log.e("TAG", "");
        oneArgument = (View view) -> Log.e("TAG", "");
        multiline = (View view) -> {//void
            Log.e("TAG", "");
            Log.e("TAG", "");
        };
        //(int x) -> x + 1;//int

    }
}
