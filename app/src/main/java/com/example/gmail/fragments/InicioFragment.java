package com.example.gmail.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gmail.Gmail;
import com.example.gmail.R;
import com.example.gmail.interfaces.ComunicarFragments;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InicioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InicioFragment<OnFragmentInteractionListener> extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


        /*if (context instanceof Activity) {
        actividad= (Activity) context;
        comunicarFragments= (ComunicarFragments) actividad;*/

    private OnFragmentInteractionListener mListener;
    View vista;
    Activity actividad;
    CardView cardGmail, cardWinzip,cardDrive;
    ComunicarFragments comunicarFragments;

    public InicioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InicioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InicioFragment newInstance(String param1, String param2) {
        InicioFragment fragment = new InicioFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista=inflater.inflate(R.layout.fragment_inicio, container, false);
        cardGmail=vista.findViewById(R.id.cardGmail);
        cardWinzip=vista.findViewById(R.id.cardWinzip);
        cardDrive=vista.findViewById(R.id.cardDrive);

        //eventosMenu();

        cardGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicarFragments.abrirGmail();
                /*Toast.makeText(getContext(), "Abrir Gmail", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent (view.getContext(), Gmail.class);
                startActivityForResult(intent, 0);*/
            }
        });

        cardWinzip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicarFragments.abrirWinzip();
            }
        });

        cardDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comunicarFragments.abrirDrive();
            }
        });

        return vista;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            actividad= (Activity) context;
            comunicarFragments= (ComunicarFragments) actividad;
        }
    }
}