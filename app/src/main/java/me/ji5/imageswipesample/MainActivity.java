package me.ji5.imageswipesample;

import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
    protected int mPrevPos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int count = getResources().obtainTypedArray(R.array.sample_images).length();
                LinearLayout ll = (LinearLayout)findViewById(R.id.layout_position);
                ll.getChildAt(mPrevPos).setEnabled(false);
                ll.getChildAt(position).setEnabled(true);
                mPrevPos = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        LinearLayout ll = (LinearLayout)findViewById(R.id.layout_position);
        int count = getResources().obtainTypedArray(R.array.sample_images).length();

        for (int i = 0; i < count; i++) {
            ImageView iv = new ImageView(this);
            iv.setImageResource(R.drawable.selector_circle);
            iv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            iv.setEnabled(i == 0);

            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            ll.addView(iv, llp);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
