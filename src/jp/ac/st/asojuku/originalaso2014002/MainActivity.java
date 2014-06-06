package jp.ac.st.asojuku.originalaso2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements View.OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	protected void onResume() {
		// TODO 自動生成されたメソッド・スタブ
		super.onResume();
		Button btnM = (Button)findViewById(R.id.btnm);
		btnM.setOnClickListener(this);

		Button btnt = (Button)findViewById(R.id.btnt);
		btnt.setOnClickListener(this);

		Button btnc = (Button)findViewById(R.id.btnc);
		btnc.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO 自動生成されたメソッド・スタブ

		EditText etv = (EditText)findViewById(R.id.edthito);
		String inputMsg = etv.getText().toString();

		Intent intent = null;
		switch(v.getId()){ //どのボタンが押されたか判定
		case R.id.btnc: //ボタンbtnOKが押された

			intent = new Intent(MainActivity.this, HitokotoActivity.class);

			startActivity(intent);
			break;

		case R.id.btnm:

			intent = new Intent(MainActivity.this, MaintenanceActivity.class);

			startActivity(intent);
			break;
		}

		intent.putExtra("hito", inputMsg);
		//次画面のアクティビティ起動
		startActivity(intent);

	}

}
