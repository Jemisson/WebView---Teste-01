package w3case.com.testeum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


/**
 * Created by Jemison on 08/02/2016.
 */
public class Splash extends Activity implements Runnable {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Handler handler = new Handler();
        handler.postDelayed(this, 3000);
    }

    public void run(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}