package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buscar_cliente.*
import kotlinx.android.synthetic.main.activity_buscar_producto.*

class BuscarProductoActivity : AppCompatActivity() {
    var productos : HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_producto)
        btnBuscarProducto.setOnClickListener { buscarProducto() }
    }

    private fun buscarProducto() {
        var intent = intent
        productos = intent.getSerializableExtra("productos") as HashMap<Int, String>
        val code = txtProductoBuscado.text.toString().toInt()
        val product = productos.get(code)
        txvMensajeProducto.setText("el producto con codigo $code contiene los siguientes datos:")
        txvProductoBuscado.setText(product)
    }

}