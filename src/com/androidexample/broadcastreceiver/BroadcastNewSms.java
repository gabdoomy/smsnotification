package com.androidexample.broadcastreceiver;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;


public class BroadcastNewSms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.androidexample_broadcast_newsms);
		
		Button clickButton = (Button) findViewById(R.id.button1);
		 clickButton.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 startsend(getApplicationContext(), "test", "google" );
             }
         });
		
	}
	
	public void startsend(Context context, String senderNum ,String message) {
		// TODO Auto-generated method stub
		WebView mWebview ;
		mWebview  = new WebView(this);

        mWebview.getSettings().setJavaScriptEnabled(true); // enable javascript

        final Activity activity = this;

        mWebview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

       // Intent i = getIntent();
        //String message = i.getStringExtra("message");
        //String name = i.getStringExtra("sender");
        mWebview.loadUrl("https://www.alexdumitrescu.com");
        setContentView(mWebview );
	}

}
