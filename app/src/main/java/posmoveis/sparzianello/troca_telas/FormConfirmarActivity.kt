package posmoveis.sparzianello.troca_telas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FormConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCodigoProduto: TextView
    private lateinit var tvQuantidade: TextView
    private lateinit var tvValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_confirmar)

        tvCodigoProduto = findViewById(R.id.tvCodigoProduto)
        tvQuantidade = findViewById(R.id.tvQuantidade)
        tvValor = findViewById(R.id.tvValor)

        tvCodigoProduto.text = intent.getStringExtra("codigoProduto")
        tvQuantidade.text = intent.getStringExtra("quantidade")
        tvValor.text = intent.getStringExtra("valor")
    }

    fun btnEnviarOnClick(view: View) {
        val sms_body = "Código: ${tvCodigoProduto.text} Quantidade: ${tvQuantidade.text} Valor: ${tvValor.text}"
        val phone_number = "sms:+5546991124391"

        val intent = Intent(Intent.ACTION_VIEW)

        intent.setData(Uri.parse(phone_number))
        intent.putExtra("sms_body", sms_body)

        startActivity(intent)
    }
}