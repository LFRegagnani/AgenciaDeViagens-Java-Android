package br.com.regagnaniviagens.ui.activity;

import static br.com.regagnaniviagens.ui.activity.ChaveDosPacotes.CHAVE_DO_PACOTE;
import static br.com.regagnaniviagens.ui.util.FormataDatasUtil.formataDatas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.model.Pacote;
import br.com.regagnaniviagens.ui.util.DiasUtil;
import br.com.regagnaniviagens.ui.util.MoedaUtil;
import br.com.regagnaniviagens.ui.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO = "Resumo do Pacote";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO);

        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_DO_PACOTE)) {
            Pacote pacoteDeViagem = (Pacote) intent.getSerializableExtra(CHAVE_DO_PACOTE);

            mostraFoto(pacoteDeViagem);
            mostraTextoLocal(pacoteDeViagem);
            mostraTextoDias(pacoteDeViagem);
            mostraTextoValor(pacoteDeViagem);
            mostraTextoDatasIdaEVolta(pacoteDeViagem);


            Button botaoPagar = findViewById(R.id.resumoBotaoPagamento);
            botaoPagar.setOnClickListener(AbreTelaDePagamento -> {
                Intent intentResumo = new Intent(this, PagamentoPacoteActivity.class);
                intentResumo.putExtra(CHAVE_DO_PACOTE, pacoteDeViagem);
                startActivity(intentResumo);
            });


        }


    }

    private void mostraTextoDatasIdaEVolta(Pacote pacoteDeViagem) {
        TextView resumoData = findViewById(R.id.resumodataDaViagem);
        String dataFormatadaDaViagem = formataDatas(pacoteDeViagem.getDias());
        resumoData.setText(dataFormatadaDaViagem);
    }

    private void mostraTextoValor(Pacote pacoteSp) {
        TextView resumoValor = findViewById(R.id.resumovalorAPagar);
        String valorFormatado = MoedaUtil.formataMoedaParaBr(pacoteSp.getPreco());
        resumoValor.setText(valorFormatado);
    }

    private void mostraTextoDias(Pacote pacoteSp) {
        TextView resumoDias = findViewById(R.id.resumonumeroDeDias);
        String diasFormatado = DiasUtil.formataDiasEmTexto(pacoteSp.getDias());
        resumoDias.setText(diasFormatado);
    }

    private void mostraTextoLocal(Pacote pacoteSp) {
        TextView resumoLocal = findViewById(R.id.resumonomeDoLocal);
        resumoLocal.setText(pacoteSp.getLocal());
    }

    private void mostraFoto(Pacote pacoteSp) {
        ImageView resumoImagem = findViewById(R.id.resumofotoDoLocal);
        Drawable drawableDaResumoImagem = ResourceUtil.devolveUmDrawable(this, pacoteSp.getImagem());
        resumoImagem.setImageDrawable(drawableDaResumoImagem);
    }
}