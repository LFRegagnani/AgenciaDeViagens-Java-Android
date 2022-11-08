package br.com.regagnaniviagens.ui.activity;

import static br.com.regagnaniviagens.ui.activity.ChaveDosPacotes.CHAVE_DO_PACOTE;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.adapter.ListaPacotesAdapter;
import br.com.regagnaniviagens.ui.dao.PacoteDao;
import br.com.regagnaniviagens.ui.model.Pacote;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        ConfiguraLista();

    }

    private void ConfiguraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
                intent.putExtra(CHAVE_DO_PACOTE, pacotes.get(i));
                startActivity(intent);

            }
        });


    }
}