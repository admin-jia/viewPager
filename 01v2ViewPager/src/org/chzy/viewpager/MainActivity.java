package org.chzy.viewpager;

import java.util.ArrayList;

import android.media.Image;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {

	private ViewPager vp;
	private ImageView iv;
	private ArrayList<ImageView> lists;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		vp = (ViewPager) findViewById(R.id.vp);
		int []img={R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
		
		iv = new ImageView(this);
		lists = new ArrayList<ImageView>();
		for (int i = 0; i < img.length; i++) {
			iv.setBackgroundResource(img[i]);
			lists.add(iv);
		}
		vp.setAdapter(new PagerAdapter() {
			
			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				ImageView view = lists.get(position);
				container.addView(view);
				return view;
			}
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0==arg1;
			}
			
			@Override
			public int getCount() {
				return lists.size();
			}
			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
			
				container.removeView((View) object);
			}
		});
	}


}
