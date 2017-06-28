package com.huihui.senior;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.huihui.senior.utils.ThreadPoolManager;

import java.util.concurrent.FutureTask;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        
        /*****
         * 应用层调用
         */
        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
//                    Log.e("jjjjjj", "runnable---->"+ finalI);
                }
            };
            ThreadPoolManager.getInstance().execute(new FutureTask<Object>(thread, null), null);
        }
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                Log.e("jjjjjj", "runnable---->finalIrunnable");
            }
        };
        ThreadPoolManager.getInstance().execute(new FutureTask<Object>(thread, null), (long) 10000);//延时执行
    }
}
