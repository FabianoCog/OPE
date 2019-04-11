package ferro.fabiano.ope_hairstyle

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*

class TelaInicialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)


        val nome = intent.getStringExtra("nomeUsuario")
        val numero = intent.getIntExtra("número", 0)

        mensagemTelaInicial.setText(nome)

        botao_sair.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra("result", "Saiu da OPE")
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }

        supportActionBar?.title = "Horários"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou Buscar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou Atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou Config", Toast.LENGTH_SHORT).show()

        } else if (id == android.R.id.home){ finish() }



        return super.onOptionsItemSelected(item)

    }

}
