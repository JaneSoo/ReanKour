package com.example.janesoo.reankour;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView count;
    ProgressBar progressBar;
    CountNumberHandler handler = new CountNumberHandler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = (TextView) findViewById(R.id.loading);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        CountNumberThread thread = new CountNumberThread(100);
        thread.start();
    }


    //create multi process
    class CountNumberThread extends Thread{

        int num;

        public CountNumberThread(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            super.run();
            for(int i=0;i<=num;i++){
                //create bundle to store data
                Bundle bundle = new Bundle();
                bundle.putInt("number", i);
                Message message = new Message();
                message.setData(bundle);

                handler.sendMessage(message);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //showing on GUI
    class CountNumberHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Bundle b = msg.getData();
            int data = b.getInt("number");
            progressBar.setProgress(data);
            count.setText("Loading "+data+"%");

            if(data==100){
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }

        }
    }
}
