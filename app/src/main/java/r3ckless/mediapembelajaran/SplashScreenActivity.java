package r3ckless.mediapembelajaran;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //redirect to MainActivity after 2 seconds
        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent
                            (SplashScreenActivity.this,MainActivity.class);
                    SplashScreenActivity.this.finish();
                    startActivity(intent);
                }
            }
        };
        timerThread.start();

    }
}
