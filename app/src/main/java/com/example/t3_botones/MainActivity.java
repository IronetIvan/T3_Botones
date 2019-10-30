package com.example.t3_botones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener , RadioGroup.OnCheckedChangeListener {
    ImageButton boton;
    ToggleButton togglebtn;
    Switch switchNormal;
    CheckBox chkBox;
    RadioGroup grupoRadios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        boton.setOnClickListener(this);
        togglebtn.setOnClickListener(this);
        switchNormal.setOnClickListener(this);
        togglebtn.setOnClickListener(this);
        switchNormal.setOnClickListener(this);
        grupoRadios.setOnCheckedChangeListener(this);


    }

    private void instancias() {
        boton = findViewById(R.id.btnImagen);
        togglebtn = findViewById(R.id.togImagen);
        switchNormal = findViewById(R.id.switchNormal);
        chkBox = findViewById(R.id.chkNormal);
        grupoRadios= findViewById(R.id.grupoRadios);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnImagen:
               /* Log.v("tag", String.valueOf(togglebtn.isChecked()));
                Log.v("tag", String.valueOf(switchNormal.isChecked()));
                Log.v("tag", String.valueOf(chkBox.isChecked()));*/
                RadioButton rSelect = findViewById(grupoRadios.getCheckedRadioButtonId());
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean b) {
        String elemento="";
        boolean estado= false;
        switch(buttonView.getId()){
            case R.id.chkNormal:
                if(chkBox.isChecked()){
                    elemento= "check";
                    estado = b;
                }
                break;
            case R.id.switchNormal:
                if(b){
                    buttonView.setEnabled(true);
                }else{
                    buttonView.setEnabled(false);
                }
                elemento= "switch";
                estado = b;
                break;
            case R.id.togImagen:
                if(b){
                    buttonView.setEnabled(true);
                }else{
                    buttonView.setEnabled(false);
                }
                elemento= "toggle";
                estado = b;
                break;
        }
        Toast.makeText(getApplicationContext(),String.format("El elemento %s esta en un estado %b!", elemento,estado), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int i) {
        String elemento="";
        switch(i){
            case R.id.radio1:
                elemento = "opcion1";
                break;
            case R.id.radio2:
                elemento = "opcion2";
                break;
            case R.id.radio3:
                elemento = "opcion3";
                break;
        }
        Toast.makeText(getApplicationContext(), elemento, Toast.LENGTH_SHORT).show();
    }
}
