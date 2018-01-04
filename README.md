仿照淘宝和聚美优品，在商品详情页，向上拖动时，可以加载下一页。使用ViewDragHelper，滑动比较流畅。<br><br>

解决问题：<br>
1.ScrollView嵌套WebView导致的高度无法自适应，h5页面显示混乱，无法滑动。<br>
&nbsp;&nbsp;&nbsp;&nbsp;解决办法：去掉嵌套，自定义WebView处理滑动，具体参考CustWebView<br>
2.自定义ScrollView，处理第二页内容很多，需要滑动的情况，具体参考BottomScrollView<br>
3.自定义listView，处理第二页内容为listView的情况。具体参考CustListView<br>


![PREVIEW](doc/capture.gif)

参考项目：
https://github.com/Hankkin/TaoBaoDetailDemo
https://github.com/xmuSistone/VerticalSlideFragment
