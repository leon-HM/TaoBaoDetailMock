package com.leon.taobaodetailmock.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.leon.taobaodetailmock.R;
import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * <br> ClassName: Fragment3
 * <br> Description: 第三页，webview加载网页
 *
 * <br> Author: hemin
 * <br> Date: 2017/11/20 17:19
 */
public class Fragment3 extends Fragment {
    View rootView;

    private Context mContext;

    @Bind(R.id.webview_content)
    WebView mWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_container3,container,false);
        mContext = getActivity();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,rootView);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setDefaultTextEncodingName("utf-8");
        settings.setTextSize(WebSettings.TextSize.NORMAL);
        settings.setBlockNetworkImage(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mWebView.loadUrl("https://github.com/leon-HM/TaoBaoDetailMock");
    }

    public static Fragment3 newInstance() {
        Bundle args = new Bundle();
//        args.putInt(ID,id);
        Fragment3 fragment = new Fragment3();
        fragment.setArguments(args);
        return fragment;
    }
}
