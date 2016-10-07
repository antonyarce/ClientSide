package com.androidsrc.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity{
	LinearLayout linear;
	TextView response;
	EditText editTextAddress, editTextPort, editTextLstPort, editTextBytes, editTextNum;
	Button buttonConnect, buttonClear,GEstadoNodo,GBloques;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		editTextAddress = (EditText) findViewById(R.id.addressEditText);
		editTextPort = (EditText) findViewById(R.id.portEditText);
        editTextLstPort = (EditText) findViewById(R.id.lstPortEditText);
        editTextBytes = (EditText) findViewById(R.id.bytesEditText);
        editTextNum = (EditText) findViewById(R.id.numEditText);
		buttonConnect = (Button) findViewById(R.id.connectButton);
		buttonClear = (Button) findViewById(R.id.clearButton);
		response = (TextView) findViewById(R.id.responseTextView);
		linear = (LinearLayout)findViewById(R.id.layout);
		GEstadoNodo = (Button)findViewById(R.id.GEstadoMemoria);
        GBloques = (Button) findViewById(R.id.GEstadoBloques);

		buttonConnect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Server server=new Server(MainActivity.this,Integer.parseInt(editTextLstPort.getText().toString()));
				Node meshNode = new Node(editTextAddress.getText().toString(),
                        Integer.parseInt(editTextPort.getText().toString()),
                        Integer.parseInt(editTextLstPort.getText().toString()),
                        Integer.parseInt(editTextNum.getText().toString()),
                        Integer.parseInt(editTextBytes.getText().toString()),
                        response,server.getIpAddress());
				meshNode.execute();
				pasar();



			}
		});


		buttonClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				response.setText("");
			}
		});

		GEstadoNodo.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pasarGraficacion();
			}
		});
		GBloques.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
                GraficarBloques();
			}
		});

	}




	public void pasar(){
		Intent i = new Intent(MainActivity.this,MapActivity.class);
		startActivity(i);
	}
	public void pasarGraficacion(){
		Intent i = new Intent(MainActivity.this,GEstadoDelNodo.class);
		startActivity(i);
	}


	public void GraficarBloques(){
		Intent i = new Intent(MainActivity.this,DatosEnBloques.class);
		startActivity(i);
	}
}
