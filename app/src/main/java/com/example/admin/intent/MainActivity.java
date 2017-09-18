package com.example.admin.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnResult;
    private EditText edtSoA, edtSoB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSoA = (EditText) findViewById(R.id.edtSoA);
        edtSoB = (EditText) findViewById(R.id.edtSoB);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (TextUtils.isEmpty(edtSoA.getText()) || TextUtils.isEmpty(edtSoB.getText())) {
                    showToast("Enter Number");
                } else {

                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    int a = Integer.parseInt(edtSoA.getText().toString());
                    int b = Integer.parseInt(edtSoB.getText().toString());

                    Bundle bundle = new Bundle();
                    bundle.putInt("soA", a);
                    bundle.putInt("soB", b);

                    myIntent.putExtra("My Package", bundle);
                    startActivity(myIntent);
                }
            }
        });
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
