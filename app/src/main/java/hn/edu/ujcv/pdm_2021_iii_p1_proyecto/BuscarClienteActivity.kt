package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_agrega_cliente.*
import kotlinx.android.synthetic.main.activity_buscar_cliente.*
import kotlinx.android.synthetic.main.activity_buscar_producto.*

class BuscarClienteActivity : AppCompatActivity() {
    var clientes: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_cliente)
        btnBuscarCliente.setOnClickListener{buscarCliente()}
    }

    private fun buscarCliente() {
        var intent = intent
        clientes = intent.getSerializableExtra("clientes") as HashMap<Int, String>
        val id = txtIngresoCodigoCliente.text.toString().toInt()
        val client = clientes.get(id)
        txvMensajeCliente.setText("el cliente con n° de identidad $id tiene los siguientes datos:")
        txvClienteBuscado.setText(client)
    }
}