package com.example.tp_3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {

    private Button btn_save_user;
    private EditText et_username, et_correo, et_password, et_repeat_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_save_user = (Button) findViewById(R.id.btn_aceptar);
        et_username = (EditText) findViewById(R.id.et_nombre);
        et_correo = (EditText) findViewById(R.id.et_correo);
        et_password = (EditText) findViewById(R.id.et_password);
        et_repeat_password = (EditText) findViewById(R.id.et_repeat_password);

        btn_save_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateInputs()){
                    insertarRegistro();
                }
            }
        });
    }

    public boolean validateInputs(){
        return true;
    }

    private void insertarRegistro(){
        ContentValues val = new ContentValues();
        val.put("Nombre", et_username.getText().toString());
        val.put("Correo", et_correo.getText().toString());
        val.put("Password", et_password.getText().toString());

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parking", null, 1);

        admin.getWritableDatabase().insert("usuarios", null, val);
        admin.close();

        Toast.makeText(this,"Usuario guardado correctamente", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
