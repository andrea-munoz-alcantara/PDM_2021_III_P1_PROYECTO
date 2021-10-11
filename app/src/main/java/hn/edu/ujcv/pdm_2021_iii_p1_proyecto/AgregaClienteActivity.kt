package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_agrega_cliente.*
import kotlinx.android.synthetic.main.activity_agrega_producto.*
import java.lang.StringBuilder


class AgregaClienteActivity : AppCompatActivity() {
    var clientes: HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agrega_cliente)
        inicializarCliente()
        btnGuardarCliente.setOnClickListener { guardarCliente() }
        btnVisualizarClientes.setOnClickListener{visualizarCliente()}
    }

    private fun inicializarCliente() {
        btnVisualizarClientes.isEnabled=false
    }

    private fun visualizarCliente() {
        val intent = Intent(this,BuscarClienteActivity::class.java)
        intent.putExtra("clientes",clientes)
        startActivity(intent)
    }

    private fun guardarCliente() {
        val dato = StringBuilder()
        val identidad = txtIdentidad.text.toString().toInt()
        dato.append("N° IDENTIDAD: ").append(txtIdentidad.text.toString().toInt()).append(" | NOMBRE: ")
        dato.append(txtNombre.text.toString()).append(" | FECHA NACIMIENTO: ")
        dato.append(txtNacimiento.text.toString()).append(" | FECHA DE INGRESO: ")
        dato.append(txtIngreso.text.toString()).append(" | CORREO: ")
        dato.append(txtCorreo.text.toString())
        clientes.put(identidad, dato.toString())
        txtNombre.setText("")
        txtNacimiento.setText("")
        txtIngreso.setText("")
        txtCorreo.setText("")
        txtIdentidad.setText("")
        txvEstadocliente.setText("EL CLIENTE CON IDENTIDAD $identidad HA SIDO AGREGADO")
        btnVisualizarClientes.isEnabled=true

    }
}