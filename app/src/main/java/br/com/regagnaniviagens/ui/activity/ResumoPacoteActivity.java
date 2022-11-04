package br.com.regagnaniviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.model.Pacote;
import br.com.regagnaniviagens.ui.util.DiasUtil;
import br.com.regagnaniviagens.ui.util.MoedaUtil;
import br.com.regagnaniviagens.ui.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        Pacote pacoteSp = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        ImageView resumoImagem = findViewById(R.id.resumofotoDoLocal);
        Drawable drawableDaResumoImagem = ResourceUtil.devolveUmDrawable(this, pacoteSp.getImagem());

        TextView resumoLocal = findViewById(R.id.resumonomeDoLocal);

        TextView resumoDias = findViewById(R.id.resumonumeroDeDias);
        String diasFormatado = DiasUtil.formataDiasEmTexto(pacoteSp.getDias());

        TextView resumoValor = findViewById(R.id.resumovalorAPagar);
        String valorFormatado = MoedaUtil.formataMoedaParaBr(pacoteSp.getPreco());

        TextView resumoData = findViewById(R.id.resumodataDaViagem);

        resumoImagem.setImageDrawable(drawableDaResumoImagem);
        resumoLocal.setText(pacoteSp.getLocal());
        resumoDias.setText(diasFormatado);
        resumoValor.setText(valorFormatado);
        //resumoData.setText(data);




    }
}