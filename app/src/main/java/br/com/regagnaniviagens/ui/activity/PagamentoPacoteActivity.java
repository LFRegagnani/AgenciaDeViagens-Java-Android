package br.com.regagnaniviagens.ui.activity;

import static br.com.regagnaniviagens.ui.activity.ChaveDosPacotes.CHAVE_DO_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.model.Pacote;
import br.com.regagnaniviagens.ui.util.MoedaUtil;

public class PagamentoPacoteActivity extends AppCompatActivity {

    public static final String TITULO = "Pagamento";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento_pacote);
        setTitle(TITULO);

        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_DO_PACOTE)) {
            Pacote pacoteDeViagem = (Pacote) intent.getSerializableExtra(CHAVE_DO_PACOTE);

            mostraPrecoFinal(pacoteDeViagem);


            Button botaoComprar = findViewById(R.id.pagamentoBotaoFinalizar);
            botaoComprar.setOnClickListener(abreTelaDeParabens -> {
                Intent intentPagamento = new Intent(this, ParabensActivity.class);
                intentPagamento.putExtra(CHAVE_DO_PACOTE, pacoteDeViagem);
                startActivity(intentPagamento);
            });


        }


    }

    private void mostraPrecoFinal(Pacote pacoteDeViagem) {
        TextView pagamentoPreco = findViewById(R.id.pagamentoValorAPagar);
        String valorFormatado = MoedaUtil.formataMoedaParaBr(pacoteDeViagem.getPreco());
        pagamentoPreco.setText(valorFormatado);
    }
}
