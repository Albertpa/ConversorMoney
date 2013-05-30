package com.aprendeandroid.conversormoney;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {

		/*Albert Pagès Raventos
		 * 
		 * Al igual que en la calculadora, esta clase hace de controlador y de modelo
		 * porque el model es sencillo
		*/
		
	//elementos de la vista
	private TextView campoPantallaA;
	private TextView campoPantallaB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//campo donde se mostrara el resultado
		campoPantallaB = (TextView) findViewById(R.id.valorConvertido);
		campoPantallaA = (TextView) findViewById(R.id.textValorConvertido);
		
	}
	
	
	//Siempre de tipo publica si es llamada por onClick
	public void pulsaConversor(View v){
		
		double resultado = 0.0;
		String resultadoTexto = "";
		String resultadoSimbolo = "";
		//Log.i("miApp", "->a euros");
		//Log.i("miApp", tagPulsado);
		
		//Recojo el valor en euros
		EditText ed = (EditText) findViewById(R.id.valorEuros);
		
		//pasamos el parametro recibido del editText
		String valorEuros = ed.getText().toString();
		
		if(valorEuros.trim().equals("")){
			valorEuros = "0";
		}	
		
		//Log.i("miApp", ""+valorEuros);
		
		switch(v.getId()){
			case R.id.aDolares:
				//Log.i("miApp", "->a euros");
				resultado = Double.parseDouble(valorEuros)*1.308;			
				resultadoTexto = getResources().getString(R.string.textValorConvertidoD);
				resultadoSimbolo = "$";
				break;
			
			case R.id.aLibras:
				//Log.i("miApp", "->a dolares");
				resultado = Double.parseDouble(valorEuros)*0.810;
				resultadoTexto = getResources().getString(R.string.textValorConvertidoL);
				resultadoSimbolo = "£";
				break;
							
			case R.id.aYenes:
				//Log.i("miApp", "->a yenes");
				resultado = Double.parseDouble(valorEuros)*108.733;
				resultadoTexto = getResources().getString(R.string.textValorConvertidoY);
				resultadoSimbolo = "Y";
				break;
			}
		
		campoPantallaA.setText(""+resultadoTexto);
		
		//redondeamos a 3 decimales
		resultado = Math.rint(resultado*1000)/1000;
		campoPantallaB.setText(""+resultado+" "+resultadoSimbolo);
	}
	

}
