package com.huihui.thread;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainActivity extends AppCompatActivity {

    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "主线程：" + Thread.currentThread().getName());


        ExecutorService executorService = Executors.newFixedThreadPool(10);


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                Log.e(TAG, Thread.currentThread().getName());
            }
        });


        executorService.shutdown();


        ExecutorService executorService1 = Executors.newFixedThreadPool(10);

        Future<String> submit = executorService1.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                Log.e(TAG, Thread.currentThread().getName());


                return "执行完毕";
            }
        });

        try {
            Log.e(TAG, submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executorService1.shutdown();

    }

    /****
     * 获取缓存路径
     * @param context
     * @param uniqueName
     * @return
     */
    public File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }
}
