package com.estebannaranjo.urandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class CategoriasActivity extends AppCompatActivity {
    private Button btnFreestylers,btnFutbolistas,btnActores,btnActrices,
    btnVillanos,btnSuperheroes,btnCantantes,btnAtletas,btnHistoricos,
    btnVideojuegos,btnHecho;
    private Switch swTodo;
    private int varFreestylers,varFutbolistas,varActores,varActrices,varVillanos,varSuperheroes,
    varCantantes,varAtletas,varVideojuegos,varHistoricos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias);
        getSupportActionBar().hide();
        btnFreestylers = findViewById(R.id.btnFreestylers);
        btnFutbolistas = findViewById(R.id.btnFutbolistas);
        btnActores = findViewById(R.id.btnActores);
        btnActrices = findViewById(R.id.btnActrices);
        btnVillanos = findViewById(R.id.btnVillanos);
        btnSuperheroes = findViewById(R.id.btnSuperheroes);
        btnCantantes = findViewById(R.id.btnCantantes);
        btnAtletas = findViewById(R.id.btnAtletas);
        btnVideojuegos = findViewById(R.id.btnVideojuegos);
        btnHistoricos = findViewById(R.id.btnHistoricos);
        btnHecho = findViewById(R.id.btnHecho);
        swTodo = findViewById(R.id.swTodo);
        varFreestylers = 0;
        varFutbolistas = 0;
        varActores = 0;
        varActrices = 0;
        varVillanos = 0;
        varSuperheroes = 0;
        varCantantes = 0;
        varAtletas = 0;
        varVideojuegos = 0;
        varHistoricos = 0;


        //Cambiar color de los botones al pulsar e indicar en la variable el estado
        btnFreestylers.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varFreestylers == 0){
                    btnFreestylers.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varFreestylers = 1;
                }else{
                    btnFreestylers.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varFreestylers = 0;
                }
            }
        });

        btnFutbolistas.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varFutbolistas == 0){
                    btnFutbolistas.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varFutbolistas = 1;
                }else{
                    btnFutbolistas.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varFutbolistas = 0;
                }
            }
        });
        btnActores.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varActores == 0){
                    btnActores.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varActores = 1;
                }else{
                    btnActores.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varActores = 0;
                }
            }
        });
        btnActrices.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varActrices == 0){
                    btnActrices.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varActrices = 1;
                }else{
                    btnActrices.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varActrices = 0;
                }
            }
        });
        btnVillanos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varVillanos==0){
                    btnVillanos.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varVillanos=1;
                }else{
                    btnVillanos.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varVillanos =  0;
                }
            }
        });
        btnSuperheroes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varSuperheroes ==0){
                    btnSuperheroes.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varSuperheroes =1;
                }else{
                    btnSuperheroes.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varSuperheroes =  0;
                }
            }
        });
        btnCantantes.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varCantantes ==0){
                    btnCantantes.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varCantantes =1;
                }else{
                    btnCantantes.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varCantantes =  0;
                }
            }
        });
        btnAtletas.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varAtletas ==0){
                    btnAtletas.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varAtletas =1;
                }else{
                    btnAtletas.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varAtletas =  0;
                }
            }
        });
        btnVideojuegos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varVideojuegos ==0){
                    btnVideojuegos.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varVideojuegos =1;
                }else{
                    btnVideojuegos.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varVideojuegos =  0;
                }
            }
        });
        btnHistoricos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(varHistoricos ==0){
                    btnHistoricos.setBackgroundColor(Color.parseColor("#EFC60B"));
                    varHistoricos =1;
                }else{
                    btnHistoricos.setBackgroundColor(Color.parseColor("#AB18CC"));
                    varHistoricos =  0;
                }
            }
        });

        btnHecho.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int pruebaSeleccionados = varFreestylers+varActores+varActrices+varAtletas+varCantantes+varFutbolistas+
                        varHistoricos+varSuperheroes+varVillanos+varVideojuegos;
                if(pruebaSeleccionados==0){
                    Toast.makeText(CategoriasActivity.this,
                            "Selecciona alguna categoria", Toast.LENGTH_LONG).show();
                }else{
                    Intent intent = new Intent(CategoriasActivity.this,PrincipalActivity.class);
                    intent.putExtra("varFreestylers", varFreestylers);
                    intent.putExtra("varActores", varActores);
                    intent.putExtra("varActrices", varActrices);
                    intent.putExtra("varAtletas", varAtletas);
                    intent.putExtra("varCantantes", varCantantes);
                    intent.putExtra("varFutbolistas", varFutbolistas);
                    intent.putExtra("varHistoricos", varHistoricos);
                    intent.putExtra("varSuperheroes", varSuperheroes);
                    intent.putExtra("varVideojuegos", varVideojuegos);
                    intent.putExtra("varVillanos", varVillanos);
                    startActivity(intent);
                }

            }
        });
        swTodo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if(swTodo.isChecked()){
                    btnActrices.performClick();
                    btnActores.performClick();
                    btnVillanos.performClick();
                    btnVideojuegos.performClick();
                    btnSuperheroes.performClick();
                    btnFreestylers.performClick();
                    btnAtletas.performClick();
                    btnFutbolistas.performClick();
                    btnCantantes.performClick();
                    btnHistoricos.performClick();

                }else{
                    btnActrices.performClick();
                    btnActores.performClick();
                    btnVillanos.performClick();
                    btnVideojuegos.performClick();
                    btnSuperheroes.performClick();
                    btnFreestylers.performClick();
                    btnAtletas.performClick();
                    btnFutbolistas.performClick();
                    btnCantantes.performClick();
                    btnHistoricos.performClick();

                }
            }
        });

    }
}
