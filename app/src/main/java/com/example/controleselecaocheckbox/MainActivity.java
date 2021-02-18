package com.example.controleselecaocheckbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CheckBox.OnCheckedChangeListener{

    private CheckBox ckbCi, ckbFu, ckbGa, ckbIn, ckbLi, ckbTe;
    private TextView txtSel;
    private Button btnEx, btnDes;
    private int cont;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ckbCi = findViewById(R.id.ckbCinema);
        ckbFu = findViewById(R.id.ckbFutebol);
        ckbGa = findViewById(R.id.ckbGastronomia);
        ckbIn = findViewById(R.id.ckbinformatica);
        ckbLi = findViewById(R.id.ckbLiteratura);
        ckbTe = findViewById(R.id.ckbTeatro);
        txtSel = findViewById(R.id.txtTotalSelecionados);
        btnEx = findViewById(R.id.btnExibir);
        btnDes = findViewById(R.id.btnDesmarcar);

        ckbCi.setOnCheckedChangeListener(this);
        ckbFu.setOnCheckedChangeListener(this);
        ckbGa.setOnCheckedChangeListener(this);
        ckbIn.setOnCheckedChangeListener(this);
        ckbLi.setOnCheckedChangeListener(this);
        ckbTe.setOnCheckedChangeListener(this);
        btnEx.setOnClickListener(this);
        btnDes.setOnClickListener(this);

        cont = 0;
        exibirSelecionados();

    }

    private void exibirSelecionados(){
        //Recuperar o texto contido no TextView
        String txt = getResources().getString(R.string.txt_selecionados);
        txtSel.setText(String.format("%s= %d", txt, cont));

    }

    @Override
    public void onClick(View v) { // O Listener requer que implemente dois métodos: onclick e onCheckedChanged

        switch (v.getId()){
            case R.id.btnExibir:
                String txt = "Temas selecionados\n\n";
                txt += ckbCi.isChecked()?"Cinema\n":"";
                txt += ckbFu.isChecked()?"Futebol\n":"";
                txt += ckbGa.isChecked()?"Gastronomia\n":"";
                txt += ckbIn.isChecked()?"Informática\n":"";
                txt += ckbLi.isChecked()?"Literatura\n":"";
                txt += ckbTe.isChecked()?"Teatro\n":"";

                AlertDialog.Builder dlg = new AlertDialog.Builder(this);
                dlg.setMessage(txt);
                dlg.setPositiveButton("Ok",null);
                dlg.show();
                break;

            case R.id.btnDesmarcar:
                ckbCi.setChecked(false);
                ckbFu.setChecked(false);
                ckbGa.setChecked(false);
                ckbIn.setChecked(false);
                ckbLi.setChecked(false);
                ckbTe.setChecked(false);
                break;


        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        if(isChecked == true) {
            cont++;
        }else{
                cont--;
            }
        exibirSelecionados();

    }
}
