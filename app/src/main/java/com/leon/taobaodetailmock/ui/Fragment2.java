package com.leon.taobaodetailmock.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.joanzapata.android.BaseAdapterHelper;
import com.joanzapata.android.QuickAdapter;
import com.leon.taobaodetailmock.R;
import com.leon.taobaodetailmock.utils.MyImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * <br> ClassName: Fragment2
 * <br> Description: 内容为listview 被BottomScrollView包裹
 *
 * <br> Author: hemin
 * <br> Date: 2017/11/20 17:18
 */
public class Fragment2 extends Fragment {

    View rootView;

    @Bind(R.id.nlv_good_detial_imgs)
    ListView nlvImgs;//图片详情

    private QuickAdapter<String> imgAdapter;
    private List<String> imgsUrl;

    private int width;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_container2,container,false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,rootView);
        initImgDatas();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(rootView);
    }

    public static Fragment2 newInstance() {
        Bundle args = new Bundle();
//        args.putInt(ID,id);
        Fragment2 fragment = new Fragment2();
        fragment.setArguments(args);
        return fragment;
    }

    //模拟图片假数据
    private void initImgDatas(){
        width = getScreenWidth(getActivity());
        imgsUrl = new ArrayList<>();
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/714288429/TB2dLhGaVXXXXbNXXXXXXXXXXXX-714288429.jpg");
        imgsUrl.add("https://img.alicdn.com/imgextra/i3/726966853/TB2vhJ6lXXXXXbJXXXXXXXXXXXX_!!726966853.jpg");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgsUrl.add("https://img.alicdn.com/imgextra/i4/2081314055/TB2FoTQbVXXXXbuXpXXXXXXXXXX-2081314055.png");
        imgAdapter = new QuickAdapter<String>(getActivity(),R.layout.adapter_good_detail_imgs) {
            @Override
            protected void convert(BaseAdapterHelper helper, String item) {
                ImageView iv = helper.getView(R.id.iv_adapter_good_detail_img);
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
                params.width = width;
                params.height = width/2;
                iv.setLayoutParams(params);
                MyImageLoader.getInstance().displayImageCen(getActivity(),item,iv,width,width/2);
            }
        };
        imgAdapter.addAll(imgsUrl);
        nlvImgs.setAdapter(imgAdapter);
    }

    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

}
