package com.example.yummy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistroActivity extends AppCompatActivity {

    TextView registro;
    TextView usuario;
    TextView contraseña;
    TextView email;
    TextView confirpassword;
    EditText usuarioEdit;
    EditText emailEdit;
    EditText confirEdit;
    EditText contraseñaEdit;
    Button crearCuenta;
    Typeface chewy;
    Typeface glacial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registro=findViewById(R.id.textRegistro);
        usuario=findViewById(R.id.usuarioRegistro);
        contraseña=findViewById(R.id.passwordRegistro);
        email=findViewById(R.id.email);
        confirpassword=findViewById(R.id.confirmarPasswordRegistro);
        usuarioEdit=findViewById(R.id.newusernameEditText);
        contraseñaEdit=findViewById(R.id.newpasswordEditText);
        emailEdit=findViewById(R.id.emailEditText);
        confirEdit=findViewById(R.id.confirPasswordEditText);
        crearCuenta=findViewById(R.id.createAccountButton);

        String font1 = "fuentes/Chewy.ttf";
        String font2 = "fuentes/Glacial.otf";

        this.chewy=Typeface.createFromAsset(getAssets(),font1);
        this.glacial=Typeface.createFromAsset(getAssets(),font2);

        registro.setTypeface(chewy);
        usuario.setTypeface(chewy);
        email.setTypeface(chewy);
        contraseña.setTypeface(chewy);
        confirpassword.setTypeface(chewy);
        crearCuenta.setTypeface(chewy);
        usuarioEdit.setTypeface(glacial);
        contraseñaEdit.setTypeface(glacial);
        emailEdit.setTypeface(glacial);
        confirEdit.setTypeface(glacial);

    }


}
