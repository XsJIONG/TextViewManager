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
		MenuInflater inflater=getMenuInflater();
		inflater.inflate(R.menu.layout_menu, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		switch(item.getItemId()) {
			case R.id.menutype:
				mTextViewManager.typeText(typeString, 100, false);
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
}
