package ec.edu.sumaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText num1;
    private EditText num2;
    private TextView resp;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText) findViewById(R.id.txtNum1);
        num2 = (EditText) findViewById(R.id.txtNum2);
        resp = (TextView) findViewById(R.id.txtResultado);
        btn = (Button) findViewById(R.id.btnSuma);
    }

    //Método para realiza la operacione Suma
    public void calcular(View view){
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if(validar()){
            double valor1 = Double.parseDouble(n1);
            double valor2 = Double.parseDouble(n2);
            double suma = valor1 + valor2;
            String resultado = String.valueOf(suma);
            resp.setText(resultado);
        }else{
            Toast.makeText( this, "Ingreso de Datos", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validar(){
        boolean retorno = true;
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();
        if(n1.isEmpty()){
            num1.setError("Campo vacio");
            retorno = false;
        }
        if (n2.isEmpty()){
            num2.setError("Campo vacio");
            retorno = false;
        }
        return retorno;
    }

    public void limpiar(View view){
        num1.setText("");
        num2.setText("");
        resp.setText("Resultado");
    }
}
