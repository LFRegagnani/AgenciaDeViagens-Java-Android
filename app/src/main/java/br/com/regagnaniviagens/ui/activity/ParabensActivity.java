package br.com.regagnaniviagens.ui.activity;

import static br.com.regagnaniviagens.ui.activity.ChaveDosPacotes.CHAVE_DO_PACOTE;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.model.Pacote;
import br.com.regagnaniviagens.ui.util.FormataDatasUtil;
import br.com.regagnaniviagens.ui.util.MoedaUtil;
import br.com.regagnaniviagens.ui.util.ResourceUtil;

public class ParabensActivity extends AppCompatActivity {

    public static final String TITULO = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parabens);
        setTitle(TITULO);


        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_DO_PACOTE)) {
            Pacote pacoteDeViagem = (Pacote) intent.getSerializableExtra(CHAVE_DO_PACOTE);

            configuraFoto(pacoteDeViagem);
            configuraLocal(pacoteDeViagem);
            configuraDatas(pacoteDeViagem);
            configuraValor(pacoteDeViagem);

        }
    }

    private void configuraValor(Pacote pacoteDeViagem) {
        TextView parabensValor = findViewById(R.id.parabensValor);
        String valorFormatado = MoedaUtil.formataMoedaParaBr(pacoteDeViagem.getPreco());
        parabensValor.setText(valorFormatado);
    }

    private void configuraDatas(Pacote pacoteDeViagem) {
        TextView parabensData = findViewById(R.id.parabensDatas);
        String dataFormatada = FormataDatasUtil.formataDatas(pacoteDeViagem.getDias());
        parabensData.setText(dataFormatada);
    }

    private void configuraLocal(Pacote pacoteDeViagem) {
        TextView parabensLocal = findViewById(R.id.parabensLocal);
        parabensLocal.setText(pacoteDeViagem.getLocal());
    }

    private void configuraFoto(Pacote pacoteDeViagem) {
        ImageView parabensFoto = findViewById(R.id.parabensFotoDoLocal);
        Drawable imagemFormatada = ResourceUtil.devolveUmDrawable(this, pacoteDeViagem.getImagem());
        parabensFoto.setImageDrawable(imagemFormatada);
    }
}