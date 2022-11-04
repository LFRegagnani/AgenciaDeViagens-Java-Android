package br.com.regagnaniviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.regagnaniviagens.R;
import br.com.regagnaniviagens.ui.adapter.ListaPacotesAdapter;
import br.com.regagnaniviagens.ui.dao.PacoteDao;
import br.com.regagnaniviagens.ui.model.Pacote;

public class listaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        ConfiguraLista();


        Intent mudaTela = new Intent(this,ResumoPacoteActivity.class);
        startActivity(mudaTela);
        
    }

    private void ConfiguraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacotes = new PacoteDao().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes,this));


    }
}