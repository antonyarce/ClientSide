package com.androidsrc.client;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView response;
	EditText editTextAddress, editTextPort, editTextLstPort, editTextBytes, editTextNum;
	Button buttonConnect, buttonClear;
    Server server;
    TextView infoip, msg;

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

        infoip = (TextView) findViewById(R.id.infoip);
        msg = (TextView) findViewById(R.id.msg);
        server = new Server(this);
        infoip.setText(server.getIpAddress()+":"+server.getPort());

		buttonConnect.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Client myClient = new Client(editTextAddress.getText()
						.toString(), Integer.parseInt(editTextPort
						.getText().toString()), response);
				myClient.execute();

			}
		});

		buttonClear.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				response.setText("");
			}
		});
	}

}
