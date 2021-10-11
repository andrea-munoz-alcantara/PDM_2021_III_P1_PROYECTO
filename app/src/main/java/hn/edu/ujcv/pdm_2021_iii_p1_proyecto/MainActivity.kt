package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnIngresaCliente.setOnClickListener { ingresaC() }
        btnIngresaProducto.setOnClickListener { ingresaP() }
        btnIngresarFactura.setOnClickListener { ingresaF() }
    }

    private fun ingresaF() {
        val intent = Intent(this, IngresarFacturasActivity ::class.java)
        startActivity(intent)
    }

    private fun ingresaP() {
        val intent = Intent(this, AgregaProductoActivity ::class.java)
        startActivity(intent)
    }

    private fun ingresaC() {
        val intentc = Intent(this, AgregaClienteActivity ::class.java)
        startActivity(intentc)
    }

}