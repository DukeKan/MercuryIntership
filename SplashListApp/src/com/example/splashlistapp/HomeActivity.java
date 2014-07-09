package com.example.splashlistapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends Activity {

	private final byte sizeOfItemsList = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_home_activity);

		// получаем экземпляр элемента ListView
		ListView lv = (ListView) findViewById(R.id.listOfItems);

		// определяем массив типа String
		final String[] items = new String[sizeOfItemsList];

		for (int i = 0; i < sizeOfItemsList; i++) {
			items[i] = "item" + i;
		}

		// используем адаптер данных
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, items);

		View header = getLayoutInflater().inflate(R.layout.list_header, null);
		((TextView) header.findViewById(R.id.tvText)).setText("Заголовок");

		lv.addHeaderView(header);
		lv.setAdapter(adapter);

	}
}
