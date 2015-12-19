package com.cuiweiyou.allsidesscrolllistview;

/**
 * <b>类名</b>: ScrollChangedListener，滚动控件的监听器 <br/> 
 * <b>说明</b>: 用于自定义的 UHorizontalScrollView <br/>
 * <b>创建</b>: 2015年12月17日 下午1:31:05 <br/> 
 * 
 * @author cuiweiyou.com <br/> 
 * @version  1 <br/>
 */
public interface ScrollChangedListener {
	/**
	 * <b>功能</b>：onScrollChanged，执行监听 <br/> 
	 * <b>创建</b>：2015年12月17日,下午1:31:26
	 * @param view 滚动控件 <br/>
	 * @param l 左新位置 <br/>
	 * @param t 顶新位置 <br/>
	 * @param oldl 左原位置 <br/>
	 * @param oldt 顶原位置  <br/> 
	 * 
	 * @author cuiweiyou.com
	 */
	public void onScrollChanged(UHorizontalScrollView view, int l, int t, int oldl, int oldt);
}