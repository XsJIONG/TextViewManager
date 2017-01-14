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
	private boolean isinit;
	
	public void initTextView(Context context, TextView textview) {
		mContext=context;
		mTextView=textview;
		isinit=true;
	}
	
	public void reset() {
		mContext=null;
		mTextView=null;
	}
	
	public void typeText(String text, int time) {
		showText=text;
		delayTime=time;
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
	
	public void setText(String text) {
		mTextView.setText(text);
	}
	
	public void clear() {
		mTextView.setText("");
	}
	
	public boolean isInit() {
		return isinit;
	}
	
	public void append(String text) {
		mTextView.setText(mTextView.getText().toString()+text);
	}
	
	public void next() {
		mTextView.setText(mTextView.getText().toString()+"\n");
	}
}
