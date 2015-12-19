package com.cuiweiyou.allsidesscrolllistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;

/**
 * <b>类名</b>: UHorizontalScrollView 自定义的水平滚动控件 <br/> 
 * <b>说明</b>: 提供类内置方法 setOnScrollChangedListener 指定滚动监听器 <br/>
 * <b>创建</b>: 2015年12月17日 下午1:32:55 <br/> 
 * 
 * @author TS-YFZX-CWY , cuiweiyou.com <br/> 
 * @version  1 <br/>
 */
public class UHorizontalScrollView extends HorizontalScrollView{

	private ScrollChangedListener scrollChangedListener;

	public UHorizontalScrollView(Context context) {
		super(context);
	}
	
	public UHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public UHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}
	
	/**
	 * onScrollChanged，内置的滚动监听功能<br/> 
	 * @param l ： 新位置x <br/>
	 * @param t ： 新位置y <br/>
	 * @param oldl ： 原位置x <br/>
	 * @param oldt ： 原位置y <br/>
	 * @see android.view.View#onScrollChanged(int, int, int, int)
	 */
	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		if (scrollChangedListener != null) {
			scrollChangedListener.onScrollChanged(this, l, t, oldl, oldt);
		}

	}
	
	/**
	 * <b>功能</b>：setOnScrollChangedListener，为滚动控件指定一个滚动监听器 <br/> 
	 * <b>创建</b>：2015年12月17日,下午1:25:02  <br/> 
	 * 
	 * @param scrollChangedListener 监听器
	 * 
	 * @author TS-YFZX-CWY, cuiweiyou.com
	 */
	public void setOnScrollChangedListener(ScrollChangedListener scrollChangedListener){
		this.scrollChangedListener = scrollChangedListener;
	}
}