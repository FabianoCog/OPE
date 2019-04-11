package ferro.fabiano.ope_hairstyle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val texto = texto_inicial
        texto_inicial.setText(R.string.mensagem_inicial)
        texto_inicialLogin.setText(R.string.mensagem_login)


        val userLogin = findViewById<EditText>(R.id.campo_usuario)
        val userPassword = findViewById<EditText>(R.id.campo_senha)


        botao_login.setOnClickListener {

            var usuario = userLogin.text.toString()
            var password = userPassword.text.toString()

             if(usuario == "aluno" && password == "impacta" ){
                 onClickLogin()
             }
             else{ Toast.makeText(this, "Login ou Senha incoreto !", Toast.LENGTH_SHORT).show() }

            if(usuario == "") {
                Toast.makeText(this, "Login vazio !", Toast.LENGTH_SHORT).show()
            }else if(password == "") {Toast.makeText(this, "Senha vazia !", Toast.LENGTH_SHORT).show()}
  }

    }

    private val context get() = this

    fun onClickLogin() {


        Toast.makeText(this, "Bem vindo: ${campo_usuario.text}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, TelaInicialActivity::class.java)

        intent.putExtra("nomeUsuario", campo_usuario.text.toString())
        intent.putExtra("número", 10)

        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
        }
        Toast.makeText(context, "Saiu da OPE", Toast.LENGTH_SHORT).show()
    }



    }

