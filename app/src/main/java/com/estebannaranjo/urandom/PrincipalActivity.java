package com.estebannaranjo.urandom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.estebannaranjo.urandom.modelo.Personaje;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Random;

public class PrincipalActivity extends AppCompatActivity {
    private ImageView ivfoto;
    private Button btnSeleccionar,btnDamelo;
    private TextView tvInfo,tvNombre,tvFecha;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference collectionReference = db.collection("Personajes");
    private final String TAG = PrincipalActivity.class.getSimpleName();
    private ArrayList<Personaje> personajes = new ArrayList<>();
    private int varFreestylers,varActores,varActrices,varAtletas,varCantantes,varFutbolistas,
            varHistoricos,varSuperheroes,varVideojuegos,varVillanos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        ivfoto = findViewById(R.id.ivFoto);
        ivfoto.setImageResource(R.drawable._karimbenzema);
        btnDamelo = findViewById(R.id.btnDamelo);
        btnSeleccionar = findViewById(R.id.btnSeleccionar);
        tvFecha = findViewById(R.id.tvFecha);
        tvNombre = findViewById(R.id.tvNombre);
        tvInfo = findViewById(R.id.tvInfo);
        getSupportActionBar().hide();
        llenarPersonajes();


        //Cojemos las categorias seleccionadas
        Intent intent = getIntent();
        varFreestylers = intent.getIntExtra("varFreestylers",1);
        varActores = intent.getIntExtra("varActores",1);
        varActrices = intent.getIntExtra("varActrices",1);
        varAtletas = intent.getIntExtra("varAtletas",1);
        varCantantes = intent.getIntExtra("varCantantes",1);
        varFutbolistas = intent.getIntExtra("varFutbolistas",1);
        varHistoricos = intent.getIntExtra("varHistoricos",1);
        varSuperheroes = intent.getIntExtra("varSuperheroes",1);
        varVideojuegos = intent.getIntExtra("varVideojuegos",1);
        varVillanos = intent.getIntExtra("varVillanos",1);


        btnSeleccionar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PrincipalActivity.this,CategoriasActivity.class);
                startActivity(intent);
            }
        });


        btnDamelo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int personajeIndex=generarPersonajesRandom();
                tvNombre.setText(personajes.get(personajeIndex).getNombre());
                tvFecha.setText("Fecha : "+personajes.get(personajeIndex).getFecha());
                tvInfo.setText("Info : "+personajes.get(personajeIndex).getInformacion());

                //Reformar nombre para usar la foto - Se quita acentos , se quita espacios y se pone todo en minuscula
                String original = personajes.get(personajeIndex).getNombre();
                String cadenaNormalize = Normalizer.normalize(original, Normalizer.Form.NFD);
                String cadenaSinAcentos = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");

                String fotoPre = cadenaSinAcentos.replace(" ","");
                String fotoFinal = "drawable/_"+fotoPre.toLowerCase();;
                int iResource = getResources().getIdentifier(fotoFinal,null,getPackageName());
                ivfoto.setImageResource(iResource);


                for(int i = 0;i<personajes.size();i++){
                    Log.i(TAG,personajes.get(i).getNombre()+" "+i);
                }

            }

        });


    }
    private void llenarPersonajes(){
        db.collection("Personajes").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot queryDocumentSnapshot : queryDocumentSnapshots) {
                            String id = queryDocumentSnapshot.getId();
                            String nombre = queryDocumentSnapshot.getString("Nombre");
                            String fecha = queryDocumentSnapshot.getString("Fecha");
                            String info = queryDocumentSnapshot.getString("Informacion");
                            String categoria = queryDocumentSnapshot.getString("Categoria");
                            Personaje personaje = new Personaje(id,nombre,fecha,info,categoria);
                            personajes.add(personaje);

                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, "Error al leer los personajes" + e.getMessage());
                        e.printStackTrace();
                    }
                });



    }
    private int generarPersonajesRandom(){
        Random random = new Random();
        int maxInt = personajes.size()-1;
        boolean correcto = false;
        int numIndex = 0;
        while (!correcto){
            numIndex = random.nextInt(maxInt - 0 + 1) + 0;
            System.out.println("nnnnnnnnnnnnnnnnn "+numIndex);
            if(personajes.get(numIndex).getCategoria().equals("Futbolistas") && varFutbolistas==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Freestylers") && varFreestylers==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Actores") && varActores==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Actrices") && varActrices==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Villanos") && varVillanos==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Superheroes") && varSuperheroes==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Historicos") && varHistoricos==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Atletas") && varAtletas==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Cantantes") && varCantantes==1){
                correcto=true;
            }else if(personajes.get(numIndex).getCategoria().equals("Videojuegos") && varVideojuegos==1){
                correcto=true;
            }else{
                System.out.println("Errorrrrr : "+numIndex+ " "+personajes.get(numIndex).getNombre()+ " y "+personajes.get(numIndex).getCategoria());
            }
        }

        return numIndex;
    }
}
