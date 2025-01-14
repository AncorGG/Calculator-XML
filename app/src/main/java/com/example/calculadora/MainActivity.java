package com.example.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView resultField, error_input_field_1, error_input_field_2;
    private EditText inputField1, inputField2;
    private Button submitBtn;

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

        resultField = findViewById(R.id.resultText);
        submitBtn = findViewById(R.id.submitBtn);
        inputField1 = findViewById(R.id.input_field_1);
        inputField2 = findViewById(R.id.input_field_2);
        error_input_field_1 = findViewById(R.id.error_input_field_1);
        error_input_field_2  = findViewById(R.id.error_input_field_2);

        submitBtn.setOnClickListener(new listener());
    }

    class listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            String inputText1 = inputField1.getText().toString();
            String inputText2 = inputField2.getText().toString();
            boolean valid = true;
            error_input_field_1.setText("");
            error_input_field_2.setText("");

            if (!isNumber(inputText1)) {
                error_input_field_1.setText("Invalid, Not a Number");
                inputField1.setText("");
                valid = false;
            }else if (inputText1.length() > 8){
                error_input_field_1.setText("Number is too long (8)");
                valid = false;
            }

            if (!isNumber(inputText2)) {
                error_input_field_2.setText("Invalid, Not a Number");
                inputField2.setText("");
                valid = false;
            }else if (inputText1.length() > 8){
                error_input_field_1.setText("Number is too long (8)");
                valid = false;
            }

            if (valid) {
                float result = Float.parseFloat(inputText1) + Float.parseFloat(inputText2);
                resultField.setText(""+result);
            }

        }
    }

    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}