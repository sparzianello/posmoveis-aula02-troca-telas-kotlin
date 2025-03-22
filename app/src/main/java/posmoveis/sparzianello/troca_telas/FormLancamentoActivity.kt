package posmoveis.sparzianello.troca_telas

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormLancamentoActivity : AppCompatActivity() {

    private lateinit var etCodigoProduto: EditText
    private lateinit var etQuantidade: EditText
    private lateinit var etValor: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_lancamento)

        etCodigoProduto = findViewById(R.id.etCodigoProduto)
        etQuantidade = findViewById(R.id.etQuantidade)
        etValor = findViewById(R.id.etValor)
    }

    fun btnConfirmarRegistroOnClick(view: View)  {
        val intent = Intent(this, FormConfirmarActivity::class.java)

        intent.putExtra("codigoProduto",etCodigoProduto.text.toString())
        intent.putExtra("quantidade",etQuantidade.text.toString())
        intent.putExtra("valor",etValor.text.toString())

        startActivity(intent)
    }

    fun btnListarOnClick(view: View) {
        val intent = Intent( this, ListarActivity::class.java )
        getResult.launch( intent )
    }

    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if(it.resultCode == RESULT_OK) {
            val codRetorno = it.data?.getIntExtra("itemId",0)
            etCodigoProduto.setText(codRetorno.toString())
        }
    }
}