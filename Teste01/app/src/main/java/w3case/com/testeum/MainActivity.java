package w3case.com.testeum;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
private static final String TAG = "hello webview";
    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG,"onCreate");
        wv = (WebView) findViewById(R.id.webView1);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.loadUrl("http://www.novanews.com.br");

        final ProgressBar progess = (ProgressBar) findViewById(R.id.ProgressBar);

        wv.setWebViewClient(new WebViewClient(){
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                progess.setVisibility(View.VISIBLE);
            }
            public void onPageFinished(WebView view, String url) {
                progess.setVisibility(View.GONE);
            }
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
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