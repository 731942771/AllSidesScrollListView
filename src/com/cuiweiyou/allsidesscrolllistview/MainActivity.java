package com.cuiweiyou.allsidesscrolllistview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity implements ScrollChangedListener{

	private ListView mlv2, mlv1;
	private UHorizontalScrollView mhsv1, mhsv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String[] strArr1 = { "a1", "a2", "aaa", "Hello", "vbniuytr", "1111a2", "2345678", "777777", "e1", "a222", "DFKJJKFL", "d10000", "0000000" };
		String[] strArr2 = { "1234567890098765432112345678900987654321qazwsxedcrfvtgvbyhnujm", "a000gfdjghjhgjdgjdfgjgjdgj2", "aa000gfdjghjhgjdgjdfgjgjdgja", "H000gfdjghjhgjdgjdfgjgjdgjello", "vbniuyt000gfdjghjhgjdgjdfgjgjdgjr", "1111a000gfdjghjhgjdgjdfgjgjdgj2", "2345000gfdjghjhgjdgjdfgjgjdgj678", "777000gfdjghjhgjdgjdfgjgjdgj777", "e000gfdjghjhgjdgjdfgjgjdgj1", "a000gfdjghjhgjdgjdfgjgjdgj222", "DFKJJKF000gfdjghjhgjdgjdfgjgjdgjL", "d1000gfdjghjhgjdgjdfgjgjdgj0000", "000gfdjghjhgjdgjdfgjgjdgjf0000" };
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, strArr1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, strArr2);

		mlv1 = (ListView) findViewById(R.id.lv1);
		mlv2 = (ListView) findViewById(R.id.lv2);
		mlv1.setAdapter(adapter1);
		mlv2.setAdapter(adapter2);
		mlv1.setOnScrollListener(new OnScrollListener() {

			/**
			 * onScrollStateChanged，滚动状态改变<br/>
			 * 
			 * @param view
			 *            ：mListView <br/>
			 * @param scrollState
			 *            ：状态码，0-停止；1-正在滚动；2-手指离开屏幕 <br/>
			 * @see android.widget.AbsListView.OnScrollListener#onScrollStateChanged(android.widget.AbsListView,
			 *      int)
			 */
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {

				View subview1 = mlv1.getChildAt(0);
				if (null == subview1)
					return;

				View subview2 = mlv2.getChildAt(0);
				if (null == subview2)
					return;

				int top1 = subview1.getTop();
				int top2 = subview2.getTop();

				final int position = mlv1.getFirstVisiblePosition();// 最顶item索引

				// 如果两个首个显示的子view高度不等
				if (top1 != top2) {
					mlv2.setSelectionFromTop(position, top1);
				}
			}

			/**
			 * onScroll，滚动过程中持续调用，监听数据的方法<br/>
			 * 
			 * @param view
			 *            ：mListView <br/>
			 * @param firstVisibleItem
			 *            ：当前屏幕上可以看到的最顶部第一个条目的索引。始于0 <br/>
			 * @param visibleItemCount
			 *            ：当前屏幕上可以看到的全部条目数量 <br/>
			 * @param totalItemCount
			 *            ： mListView内拥有的全部条目数量。 <br/>
			 * @see android.widget.AbsListView.OnScrollListener#onScroll(android.widget.AbsListView,
			 *      int, int, int)
			 */
			@Override
			public void onScroll(AbsListView view, final int firstVisibleItem, int visibleItemCount, int totalItemCount) {

				View subview1 = mlv1.getChildAt(0);
				if (null == subview1)
					return;

				View subview2 = mlv2.getChildAt(0);
				if (null == subview2)
					return;

				int top1 = subview1.getTop();
				int top2 = subview2.getTop();

				if (top1 != top2) {
					mlv2.setSelectionFromTop(firstVisibleItem, top1);
					mlv1.setSelectionFromTop(firstVisibleItem, top1);
				}
			}
		});	
		mlv2.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				
				View subview1 = mlv1.getChildAt(0);
				if (null == subview1)
					return;

				View subview2 = mlv2.getChildAt(0);
				if (null == subview2)
					return;

				int top1 = subview1.getTop();
				int top2 = subview2.getTop();

				final int position = mlv2.getFirstVisiblePosition();// 最顶item索引

				// 如果两个首个显示的子view高度不等
				if (top1 != top2) {
					mlv1.setSelectionFromTop(position, top2);
				}
			}

			@Override
			public void onScroll(AbsListView view, final int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				View subview1 = mlv1.getChildAt(0);
				if (null == subview1)
					return;

				View subview2 = mlv2.getChildAt(0);
				if (null == subview2)
					return;

				int top1 = subview1.getTop();
				int top2 = subview2.getTop();

				if (top1 != top2) {
					mlv2.setSelectionFromTop(firstVisibleItem, top2);
					mlv1.setSelectionFromTop(firstVisibleItem, top2);
				}
			}
		});

		mhsv1 = (UHorizontalScrollView) findViewById(R.id.hsv1);
		mhsv2 = (UHorizontalScrollView) findViewById(R.id.hsv2);
		mhsv1.setOnScrollChangedListener(this);
		mhsv2.setOnScrollChangedListener(this);
	}

	/**
	 * onScrollChanged，水平滚动控件滚动监听<br/> 
	 * @param view 触发此监听的滚动控件<br/>
	 * @param l 左新<br/>
	 * @param t 顶新<br/>
	 * @param oldl 左旧<br/>
	 * @param oldt ： 顶旧<br/>
	 * @see com.cuiweiyou.autoscrolllist.ScrollChangedListener#onScrollChanged(com.cuiweiyou.autoscrolllist.UHorizontalScrollView, int, int, int, int)
	 */
	@Override
	public void onScrollChanged(UHorizontalScrollView view, int l, int t, int oldl, int oldt) {
		if (view == mhsv1) {
			mhsv2.scrollTo(l, t);
		} else if (view == mhsv2) {
			mhsv1.scrollTo(l, t);
		}
	}
}
