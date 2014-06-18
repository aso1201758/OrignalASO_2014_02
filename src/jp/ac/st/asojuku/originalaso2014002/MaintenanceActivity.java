package jp.ac.st.asojuku.originalaso2014002;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;


public class MaintenanceActivity extends Activity implements View.OnClickListener, AdapterView.OnItemClickListener{

	SQLiteDatabase sdb = null;
	MySQLiteOpenHelper helper = null;

	int selectedID = -1;

	int lastPosition = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO 自動生成されたメソッド・スタブ
		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintenance);

	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnM = (Button)findViewById(R.id.btnm);
		btnM.setOnClickListener(this);

		Button btnT = (Button)findViewById(R.id.btnt);
		btnT.setOnClickListener(this);

		ListView lstHitokoto = (ListView)findViewById(R.id.LvHITOKOTO);
		lstHitokoto.setOnItemClickListener(this);

		this.setDBValuetoList(lstHitokoto);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void setDBValuetoList(ListView lstHitokoto){

		SQLiteCursor cursor = null;

		if(sdb == null) {
			helper = new MySQLiteOpenHelper(getApplicationContext());
		}
		try{
			sdb = helper.getWritableDatabase();
		} catch(SQLiteException e) {
			Log.e("ERROR", e.toString());
		}

		cursor = this.helper.selectHitokotoList(sdb);

		int db_layout = android.R.layout.simple_list_item_activated_1;

		String[]from = {"phrase"};

		int[] to = new int[]{android.R.id.text1};

		SimpleCursorAdapter adapter =
				new SimpleCursorAdapter(this,db_layout,cursor,from,to,0);

		lstHitokoto.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {

		Intent intent = null;
		switch(v.getId()){ //どのボタンが押されたか判定
		case R.id.btnm: //ボタンbtnOKが押された

			intent = new Intent(MaintenanceActivity.this, MainActivity.class);

			startActivity(intent);
			break;
		}



	}

}