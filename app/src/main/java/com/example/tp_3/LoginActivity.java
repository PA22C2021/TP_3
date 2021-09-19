package com.example.tp_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btn_ingresar;
    private TextView tv_register;
    private EditText et_username, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_ingresar = (Button) findViewById(R.id.btn_iniciar_sesion);
        tv_register = (TextView) findViewById(R.id.btn_registrarse);
        et_username = (EditText) findViewById(R.id.edt_login_username);
        et_password = (EditText) findViewById(R.id.edt_login_password);

        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
            }
        });

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciarSesion();
            }
        });
    }

    public void iniciarSesion(){
        if(validateInputs()){
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "parking", null, 1);
            SQLiteDatabase _dbContext = admin.getReadableDatabase();

            StringBuilder query = new StringBuilder();
            query.append("select * from usuarios where username = ");
            query.append(et_username.getText().toString());
            query.append(" and password = " + et_password.getText().toString());

            Cursor fila = _dbContext.rawQuery(query.toString(), null);

            if(fila.moveToFirst()){
                //Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                //startActivity(i);
            }else{
                Toast.makeText(this,"Usuario o clave invalidos", Toast.LENGTH_SHORT).show();
            }

            _dbContext.close();
        }
    }

    private boolean validateInputs(){
        boolean valid = true;

        if(et_username.getText().toString().isEmpty() && et_password.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe completar los campos requeridos", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(et_username.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe completar el nombre de usuario", Toast.LENGTH_SHORT).show();
            valid = false;
        }
        if(et_password.getText().toString().isEmpty()){
            Toast.makeText(this,"Debe completar la contraseña", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        return valid;
    }
}