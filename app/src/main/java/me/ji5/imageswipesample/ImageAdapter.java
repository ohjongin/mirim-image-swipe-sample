package me.ji5.imageswipesample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Describe about this class here...
 *
 * @author ohjongin
 * @since 1.0
 * 14. 11. 4
 */
public class ImageAdapter extends PagerAdapter {
    protected Context mContext;

    ImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return getContext().getResources().obtainTypedArray(R.array.sample_images).length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);

        RelativeLayout layout = (RelativeLayout)inflater.inflate(R.layout.layout_page, null);

        ImageView imageView = (ImageView) layout.findViewById(R.id.image);
        TextView tvPosition = (TextView) layout.findViewById(R.id.position);

        int padding = mContext.getResources().getDimensionPixelSize(R.dimen.padding_medium);
        imageView.setPadding(padding, padding, padding, padding);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageResource(getContext().getResources().obtainTypedArray(R.array.sample_images).getResourceId(position, -1));

        tvPosition.setText("" + position);

        ((ViewPager) container).addView(layout, 0);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

    protected Context getContext() {
        return mContext;
    }
}
