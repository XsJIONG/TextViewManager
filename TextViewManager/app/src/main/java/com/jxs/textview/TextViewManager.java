package com.jxs.textview;

import android.content.Context;
import android.widget.TextView;
import android.os.Handler;

public class TextViewManager
{
	private Context mContext;
	private TextView mTextView;
	private String showText;
	private int delayTime;
	
	public void initTextView(Context context, TextView textview) {
		mContext=context;
		mTextView=textview;
	}
	
	public void clear() {
		mContext=null;
		mTextView=null;
	}
	
	public void typeText(String text, int time, boolean append) {
		showText=text;
		delayTime=time;
		if(!append) {
			mTextView.setText("");
		}
		TypeDelay();
	}
	
	private void TypeDelay() {
		new Handler().postDelayed(new Runnable(){
			public void run() {
				if(mTextView.getText().toString().length() < showText.length()) {
					mTextView.setText(showText.substring(0,mTextView.getText().toString().length()+1));
					TypeDelay();
				}
			}
		}, delayTime);
	}
	
}
