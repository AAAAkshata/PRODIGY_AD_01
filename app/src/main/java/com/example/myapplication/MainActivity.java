package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnadd, btnsub, btnmul, btndiv;
    EditText editnum1, editnum2;
    TextView textView;
    int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        btnadd = findViewById(R.id.add);
        btnsub = findViewById(R.id.sub);
        btnmul = findViewById(R.id.mul);
        btndiv = findViewById(R.id.div);
        editnum1 = findViewById(R.id.num1);
        editnum2 = findViewById(R.id.num2);
        textView = findViewById(R.id.result);

        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);

    }

    public int getIntergerFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        number1 = getIntergerFromEditText(editnum1);
        number2 = getIntergerFromEditText(editnum2);

        int id = view.getId();
        if (id == R.id.add) {
            textView.setText("Answer = " + (number1 + number2));
        } else if (id == R.id.sub) {
            textView.setText("Answer = " + (number1 - number2));
        } else if (id == R.id.mul) {
            textView.setText("Answer = " + (number1 * number2));
        } else if (id == R.id.div)
            if (number2 != 0) {
            textView.setText("Answer = " + ((float) number1 / (float) number2));
        } else {
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
        }
    }
}