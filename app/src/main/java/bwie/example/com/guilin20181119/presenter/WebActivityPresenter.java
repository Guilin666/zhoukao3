package bwie.example.com.guilin20181119.presenter;

import android.content.Context;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import bwie.example.com.guilin20181119.R;
import bwie.example.com.guilin20181119.mvp.view.DegateImpl;

public class WebActivityPresenter extends DegateImpl {
    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    public void iniData() {
        super.iniData();
        WebView web=(WebView)get(R.id.web);
        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        web.loadUrl("https://wapbaike.baidu.com/item/%E8%85%BE%E8%AE%AF/112204");

    }

    private Context context;
    @Override
    public void setContext(Context context) {
        super.setContext(context);
        this.context=context;
    }
}
