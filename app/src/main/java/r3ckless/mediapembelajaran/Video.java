package r3ckless.mediapembelajaran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class Video extends AppCompatActivity {

    private MyWebChromeClient mWebChromeClient = null;
    private WebView wv;
    private FrameLayout mCustomViewContainer;
    private LinearLayout mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        wv = (WebView) findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.getSettings().setUseWideViewPort(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.setWebChromeClient(new MyWebChromeClient());
// string url which you have to load into a web view
        String url = "file:///android_asset/video.html";
        wv.loadUrl(url); // load the url on the web view
    }

    private class MyWebChromeClient extends WebChromeClient {
        private View myCustomView = null;
        private CustomViewCallback myCallback = null;
        FrameLayout.LayoutParams LayoutParameters = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            if (myCustomView != null) {
                callback.onCustomViewHidden();
                return;
            }
            mContentView = (LinearLayout) findViewById(R.id.LineLay);
            mContentView.setVisibility(View.GONE);
            mCustomViewContainer = new FrameLayout(Video.this);
            mCustomViewContainer.setLayoutParams(LayoutParameters);
            mCustomViewContainer.setBackgroundResource(android.R.color.black);
            view.setLayoutParams(LayoutParameters);
            mCustomViewContainer.addView(view);
            myCustomView = view;
            myCallback = callback;
            mCustomViewContainer.setVisibility(View.VISIBLE);
            setContentView(mCustomViewContainer);
        }

        @Override
        public void onHideCustomView() {
            if (myCustomView == null) {
            return;
            }
            else {
                // Hide the custom view.
                myCustomView.setVisibility(View.GONE);
                // Remove the custom view from its container.
                mCustomViewContainer.removeView(myCustomView);
                myCustomView = null;
                mCustomViewContainer.setVisibility(View.GONE);
                myCallback.onCustomViewHidden();
                // Show the content view.
                mContentView.setVisibility(View.VISIBLE);
                setContentView(mContentView);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (wv.canGoBack())
            wv.goBack();
        else
            onNavigateUp();
    }

}
