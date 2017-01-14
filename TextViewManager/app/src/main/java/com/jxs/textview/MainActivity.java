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
import android.text.TextUtils;

public class MainActivity extends Activity 
{
	private TextView text;
	private TextViewManager mTextViewManager;
	private String typeString="这是一个文字打印展示";
	public final int none=Menu.NONE;
	private EditText edit;
	private int delayTime=100;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		text=(TextView) findViewById(R.id.textView);
		mTextViewManager=new TextViewManager();
		mTextViewManager.initTextView(MainActivity.this, text);
		mTextViewManager.setText(typeString);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(none,none,1,"清空文字");
		menu.add(none,none,2,"还原文字");
		menu.add(none,none,3,"设置演示文字");
		menu.add(none,none,4,"设置打字间隔时间");
		menu.add(none,none,5,"打印文字");
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
				mTextViewManager.clear();
				mTextViewManager.typeText(typeString, delayTime);
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
						if (TextUtils.isEmpty(edit.getText().toString())) {
							Toast.makeText(MainActivity.this, "设置失败！", Toast.LENGTH_SHORT).show();
						} else {
							typeString=edit.getText().toString();
							mTextViewManager.setText(typeString);
							Toast.makeText(MainActivity.this, "设置成功！", Toast.LENGTH_SHORT).show();
						}
					}
				});
				builder.setCancelable(true);
				builder.show();
				break;
			case "还原文字":
				mTextViewManager.setText(typeString);
				break;
			case "设置打字间隔时间":
				AlertDialog.Builder builder2=new AlertDialog.Builder(this);
				builder2.setTitle("请输入");
				edit=new EditText(this);
				edit.setHint("请输入...");
				edit.setText(delayTime+"");
				builder2.setView(edit);
				builder2.setNegativeButton("取消", null);
				builder2.setNegativeButton("确定", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							try {
								delayTime=Integer.parseInt(edit.getText().toString());
								Toast.makeText(MainActivity.this, "设置成功！", Toast.LENGTH_SHORT).show();
							} catch(Exception e) {
								Toast.makeText(MainActivity.this, "设置失败！", Toast.LENGTH_SHORT).show();
							}
						}
					});
				builder2.setCancelable(true);
				builder2.show();
				break;
			default:
				break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
	
}
