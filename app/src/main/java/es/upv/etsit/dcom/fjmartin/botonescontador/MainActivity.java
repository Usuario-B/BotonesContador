package es.upv.etsit.dcom.fjmartin.botonescontador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Se declaran como propiedad de MainActivity para que
    // sea accesible dentro de rutinas
    int valor_cuenta = 0;

    // Máximo valor de la cuenta
    final int MAX_CUENTA = 10;
    // Mínimo valor de la cuenta
    final int MIN_CUENTA = -3;

    // Incrementa cuenta si no supera el máximo
    private void incrementar_cuenta() {
        if (valor_cuenta<MAX_CUENTA) valor_cuenta++;
    }

    // Decrementa cuenta si no es menor que el mínimo
    private void decrementar_cuenta() {
        if (valor_cuenta>MIN_CUENTA) valor_cuenta--;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se declara final porque texto_cuenta ya no se modificará
        // (pueden cambiarse sus campos, pero no su referencia)
        // y como es una constante, se pasará una copia (referencia)
        // a los listeners. Cuando se ejecuten los listeners por el
        // el evento click, el método onCreate ya habrá finalizado
        // y sus variables locales no existirán, por ello, se lleva
        // una copia
        final TextView texto_cuenta = (TextView) findViewById(R.id.contador);

        Button boton_arriba = (Button) findViewById(R.id.boton_arriba);
        Button boton_abajo = (Button) findViewById(R.id.boton_abajo);

        // Objeto sumar: perteneciente a clase anónima y
        // después: polimorfismo a clase padre (View.OnClickListener)
        View.OnClickListener sumar = new View.OnClickListener() {
            // Extendemos clase View.OnClickListener
            @Override
            public void onClick(View vista) {
                incrementar_cuenta();
                texto_cuenta.setText("" + valor_cuenta);
            }
        };
        // Programación de acción para boton_arriba
        boton_arriba.setOnClickListener(sumar);

        // Programación de acción para boton_abajo
        // Forma alternativa más compacata: con objeto y clase anónimos
        boton_abajo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View vista) {
                decrementar_cuenta();
                texto_cuenta.setText("" + valor_cuenta);
            }
        });
    }
}
