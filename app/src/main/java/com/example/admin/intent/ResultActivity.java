package com.example.admin.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private TextView txtResult;
    private Button btnKetqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btnKetqua = (Button) findViewById(R.id.btnKetqua);
        btnKetqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);

                showToast("Wellcome back to MainActivity");
            }
        });

        txtResult = (TextView) findViewById(R.id.txtResult);

        Intent callerIntent = getIntent();

        Bundle packBundle = callerIntent.getBundleExtra("My Package");
        int a = packBundle.getInt("soA");
        int b = packBundle.getInt("soB");

        giaiPTBN(a, b);
    }

    public void giaiPTBN(int a, int b) {
        if (a == 0) {
            if (b == 0) {
                txtResult.setText("Phuong trinh vo so nghiem");
                return;
            } else txtResult.setText("Phuong trinh vo nghiem");
        } else txtResult.setText(String.valueOf((float) -b / a));
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
