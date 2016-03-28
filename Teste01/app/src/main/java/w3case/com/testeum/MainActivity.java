package w3case.com.testeum;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
private static final String TAG = "hello webview";
    private WebView wv;
    private ImageView splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate");

        wv = (WebView) findViewById(R.id.webView1);
        splash = (ImageView)findViewById(R.id.imgloader);

        wv.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        wv.getSettings().setJavaScriptEnabled(true);

         wv.setWebViewClient(new WebViewClient(){
             @Override
             public void onPageStarted(WebView view, String url, Bitmap favicon){

             }

             @Override
             public void onPageFinished(WebView view, String url){
                 //hide loading image
                 splash.setVisibility(View.GONE);
                 //show webview
                 wv.setVisibility(View.VISIBLE);
             }
         });

        if(savedInstanceState != null){
            wv.restoreState(savedInstanceState);
        } else {
            wv.loadUrl("http://www.novanews.com.br");
        }
    }

    @Override
    public void onBackPressed(){
        if(wv.canGoBack()){
            wv.goBack();
        } else {
            super.onBackPressed();
        }
    }
    @Override
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "onStart");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i(TAG, "onRestart");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "onPause");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "onResume");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        wv.saveState(outState);
        Log.i(TAG,"onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        wv.restoreState(savedInstanceState);
        Log.i(TAG,"onRestoreInstanceState");
    }

}