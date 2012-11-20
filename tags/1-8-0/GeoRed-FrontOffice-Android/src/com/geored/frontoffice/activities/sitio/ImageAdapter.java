package com.geored.frontoffice.activities.sitio;

import com.geored.frontoffice.activities.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter 
{
	   int mGalleryItemBackground;
	   
	   private Context mContext;

	   private Integer[] mImageIds = {
	           R.drawable.next,
	           R.drawable.marker3,
	           R.drawable.contact,
	           R.drawable.georeduy_v1,
	           R.drawable.ic_launcher
	   };
	   
	   
	   
		public ImageAdapter(Context c) 
		{
		       mContext = c;
		       TypedArray a = c.obtainStyledAttributes(R.styleable.Theme);
		       mGalleryItemBackground = a.getResourceId(R.styleable.Theme_android_galleryItemBackground, 0);
		       a.recycle();
		}

		public int getCount() 
		{
			return mImageIds.length;
		}
	
		public Object getItem(int position) 
		{
			return position;
		}
	
		public long getItemId(int position) 
		{
			return position;
		}
	
		public View getView(int position, View convertView, ViewGroup parent) 
		{
		       ImageView i = new ImageView(mContext);

		       i.setImageResource(mImageIds[position]);
		       i.setLayoutParams(new Gallery.LayoutParams(160, 160));
		       i.setScaleType(ImageView.ScaleType.FIT_XY);
		       i.setBackgroundResource(mGalleryItemBackground);

		       return i;
		}

}
