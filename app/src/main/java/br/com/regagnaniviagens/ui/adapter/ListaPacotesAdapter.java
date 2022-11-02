package br.com.regagnaniviagens.ui.adapter;

import static br.com.regagnaniviagens.ui.util.DiasUtil.formataDiasEmTexto;
import static br.com.regagnaniviagens.ui.util.MoedaUtil.formataMoedaParaBr;
import static br.com.regagnaniviagens.ui.util.ResourceUtil.devolveUmDrawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {


    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {

        this.context = context;
        this.pacotes = pacotes;
    }

    @Override
    public int getCount() {//METODO QUE PEGA O TAMANHO MAXIMO ATUAL DA LISTA
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {//METODO QUE PEGA UM ITEM DA LISTA DE ACORDO COM A POSIÇÃO
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {//ID NÃO IMPLANTADO AQUI MAS GERALMENTE É USADO PARA EDITAR O ITEM
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup) { //PROGRAMA O ITEM DA LISTA
        //Setando o XML do pacote
        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote_de_viagens, viewGroup, false);
        Pacote pacote = pacotes.get(posicao);

        configuraLocal(viewCriada, pacote);
        ConfiguraImagem(viewCriada, pacote);
        configuraDias(viewCriada, pacote);
        configuraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void configuraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_preco);
        String moedaBr = formataMoedaParaBr(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void configuraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_dias);
        String numeroDeDias = formataDiasEmTexto(pacote.getDias());
        dias.setText(numeroDeDias);
    }

    private void ConfiguraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_imagem);
        Drawable drawableImagemPacote = devolveUmDrawable(context,pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void configuraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_local);
        local.setText(pacote.getLocal());
    }
}
