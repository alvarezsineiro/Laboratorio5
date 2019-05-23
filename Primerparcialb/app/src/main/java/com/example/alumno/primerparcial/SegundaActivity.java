package com.example.alumno.primerparcial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        Button b = (Button) findViewById(R.id.btndos);

        b.setOnClickListener(new MyListener(this));


        XmlParse.jsonparse("{ 'frutas': [ { 'nombre_fruta':'Manzana' , 'cantidad':10 }, { 'nombre_fruta':'Pera' , 'cantidad':20 }, { 'nombre_fruta':'Naranja' , 'cantidad':30 } ] }");
    }
    /*
    public class MyListenerControlador implements View.OnClickListener{
    PersonaView view;
    PersonaModel model;



    public MyListenerControlador(PersonaModel model) {


        this.model = model;

    }

    @Override
    public void onClick(View v) {
        model = new PersonaModel();
        model.setNombre(view.etNombre.getText().toString());
        model.setApellido(view.etApellido.getText().toString());
        model.setDni(Integer.valueOf(view.etDni.getText().toString()));
        if(view.rbMasculino.isChecked()){
            model.setSexo(view.rbMasculino.getText().toString());
        }else{
            model.setSexo(view.rbFemenino.getText().toString());
        }

        Log.d("Nueva persona",model.toString());


    }

    public void setView(PersonaView view){
        this.view = view;
    }
}


public class PersonaView {
    EditText etNombre;
    EditText etApellido;
    EditText etDni;
    RadioButton rbMasculino;
    RadioButton rbFemenino;

    public PersonaView(Activity activity,MyListenerControlador controlador) {
        Button btn = (Button)activity.findViewById(R.id.btn);

        btn.setOnClickListener(controlador);


        etNombre =(EditText)activity.findViewById(R.id.etNombre);
        etDni =(EditText)activity.findViewById(R.id.etDni);
        etApellido =(EditText)activity.findViewById(R.id.etApellido);
        rbMasculino =(RadioButton)activity.findViewById(R.id.rbMasculino);
        rbFemenino = (RadioButton)activity.findViewById(R.id.rbFemenino);
    }


}
String str = getString(R.string.hello_world);

android:text:@string/hello_world
     */
}
