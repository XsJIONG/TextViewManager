package com.jxs.textview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.widget.EditText;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends Activity 
{
	private TextView text;
	private TextViewManager mTextViewManager;
	private String typeString="这是一个文字打印展示";
	public final int none=Menu.NONE;
	private EditText edit;
	
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
		menu.add(none,none,2,"设置演示文字");
		menu.add(none,none,3,"打印文字");
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
			case "设置演示文字":
				AlertDialog.Builder builder=new AlertDialog.Builder(this);
				builder.setTitle("请输入");
				edit=new EditText(this);
				edit.setHint("请输入...");
				edit.setText(typeString);
				builder.setView(edit);
				builder.setNegativeButton("取消", null);
				builder.setNegativeButton("确定", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						typeString=edit.getText().toString();
						Toast.makeText(MainActivity.this, "设置成功！", Toast.LENGTH_SHORT).show();
					}
				});
				builder.setCancelable(true);
				builder.show();
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
}
