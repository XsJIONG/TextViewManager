package com.jxs.textview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity 
{
	private TextView text;
	private TextViewManager mTextViewManager;
	public final String typeString="这是一个文字打印展示";
	public final int none=Menu.NONE;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		text=(TextView) findViewById(R.id.textView);
		mTextViewManager=new TextViewManager();
		mTextViewManager.initTextView(MainActivity.this, text);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(none,none,1,"清空文字");
		menu.add(none,none,2,"打印文字");
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		switch(item.getTitle().toString()) {
			case "清空文字":
				mTextViewManager.clear();
				break;
			case "打印文字":
				mTextViewManager.typeText(typeString, 100);
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
}
