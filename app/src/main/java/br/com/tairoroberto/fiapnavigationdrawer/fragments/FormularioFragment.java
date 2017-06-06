package br.com.tairoroberto.fiapnavigationdrawer.fragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import br.com.tairoroberto.fiapnavigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment implements View.OnClickListener {

    private int num1;
    private int num2;
    private TextInputLayout edtNum1;
    private TextInputLayout edtNum2;
    private TextView textResultado;

    public FormularioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);
        edtNum1 = (TextInputLayout) view.findViewById(R.id.editNum1);
        edtNum2 = (TextInputLayout) view.findViewById(R.id.editNum2);
        textResultado = (TextView) view.findViewById(R.id.textResultado);

        Button btnSoma = (Button) view.findViewById(R.id.btnSoma);
        Button btnSubtrair = (Button) view.findViewById(R.id.btnSubtrair);
        Button btnMultiplicar = (Button) view.findViewById(R.id.btnMultiplicar);
        Button btnDividir = (Button) view.findViewById(R.id.btnDividir);

        btnSoma.setOnClickListener(this);
        btnSubtrair.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (!TextUtils.isEmpty(edtNum1.getEditText().getText()) && !TextUtils.isEmpty(edtNum2.getEditText().getText())) {
            num1 = Integer.parseInt(edtNum1.getEditText().getText().toString());
            num2 = Integer.parseInt(edtNum2.getEditText().getText().toString());
        }

        if (view.getId() == R.id.btnSoma) {
            int soma = num1 + num2;
            textResultado.setText(String.valueOf(soma));

        } else if (view.getId() == R.id.btnSubtrair) {
            int subtracao = num1 - num2;
            textResultado.setText(String.valueOf(subtracao));

        } else if (view.getId() == R.id.btnMultiplicar) {
            int mutiplicacao = num1 * num2;
            textResultado.setText(String.valueOf(mutiplicacao));

        } else if (view.getId() == R.id.btnDividir) {
            int divisao = (num1 == 0 || num2 == 0) ? 0 : num1 / num2;
            textResultado.setText(String.valueOf(divisao));
        }
    }
}
