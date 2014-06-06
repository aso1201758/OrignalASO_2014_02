package jp.ac.st.asojuku.originalaso2014002;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MaintenanceActivity extends Activity implements View.OnClickListener{

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