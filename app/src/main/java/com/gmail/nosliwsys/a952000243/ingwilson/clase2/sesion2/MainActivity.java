package com.gmail.nosliwsys.a952000243.ingwilson.clase2.sesion2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtnombre;
    EditText edtmonto;
    TextView txtresultado;
    Button btnejecutar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtnombre=findViewById(R.id.edtnombre);
        edtmonto=findViewById(R.id.edtmonto);
        txtresultado=findViewById(R.id.txtResultado);
        btnejecutar=findViewById(R.id.btncambiar);
        btnejecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cambio;
                cambio=Double.parseDouble(edtmonto.getText().toString())*3.3;
                txtresultado.setText(edtnombre.getText() + " el monto de "+ edtmonto.getText()+
                        " dolares equivale a " + cambio.toString() + "Soles");
            }
        });
    }
    public void ocultar(View view){
        btnejecutar.setVisibility(View.GONE);
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true; /** true -> el menú ya está visible */
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.accion_compartir) {
            Intent paramView;
            paramView = new Intent("android.intent.action.SEND");
            paramView.setType("text/plain");
            paramView.putExtra("android.intent.extra.TEXT", "Descarga nuestra app de la PlayStore" +
                    " \n" + "https://play.google.com/store/apps/details?id=app.product.demarktec.alo14_pasajero");
            startActivity(Intent.createChooser(paramView, "Comparte Nuestro aplicativo"));
            return true;
        }
        if (id == R.id.activity_comunicacion) {
            startActivity(new Intent(this, Comunicacion1.class));
            return true;
        }
        if (id == R.id.accion_salir) {
            finish();
            return true;
        }
        if (id == R.id.activity_intenciones) {
            startActivity(new Intent(this, Intenciones.class));
            return true;
        }
        if (id == R.id.activity_multimedia) {
            startActivity(new Intent(this, Multimedia.class));
            return true;
        }
        if (id == R.id.activity_permisos) {
            startActivity(new Intent(this, Permisos.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}