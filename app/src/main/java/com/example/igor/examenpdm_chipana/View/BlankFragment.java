package com.example.igor.examenpdm_chipana.View;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.igor.examenpdm_chipana.Modelo.Productos;
import com.example.igor.examenpdm_chipana.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class BlankFragment extends Fragment {
          private EditText data1;
          private TextView data2;
          private Button buton;
          private ListView listaa,lista1;
          private TableLayout tabe;
            DatabaseReference bbdd;;
        //  DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
         //  DatabaseReference msgref=ref.child("Azucar");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista=inflater.inflate(R.layout.fragment_blank, container, false);

        lista1=(ListView)vista.findViewById(R.id.lista1);
        listaa=(ListView)vista.findViewById(R.id.lista);

        bbdd = FirebaseDatabase.getInstance().getReference(getString(R.string.nodo_discos));


        bbdd.addValueEventListener(new ValueEventListener() {
                                       @Override
                                       public void onDataChange(DataSnapshot dataSnapshot) {

                                           ArrayAdapter<String> adaptador;
                                           ArrayList<String> listado = new ArrayList<String>();
                                           ArrayAdapter<String> adaptador1;
                                           ArrayList<String> listado1 = new ArrayList<String>();

                                           for (DataSnapshot datasnapshot : dataSnapshot.getChildren()) {
                                               Productos productos = datasnapshot.getValue(Productos.class);

                                               String titulo = productos.getTitulo();
                                               listado.add(titulo);
                                               String precio = productos.getPrecio();
                                               listado1.add(precio);
                                           }

                                           adaptador = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listado);
                                           listaa.setAdapter(adaptador);

                                           adaptador1 = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listado1);
                                           lista1.setAdapter(adaptador1);


                                       }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return vista;
    }

    @Override
    public void onStart() {
        super.onStart();
       /* msgref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                data2.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/


    }
}
