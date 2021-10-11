package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_agrega_producto.*
import kotlinx.android.synthetic.main.activity_ingresar_facturas.*
import java.lang.StringBuilder

class IngresarFacturasActivity : AppCompatActivity() {
    var facturas: HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingresar_facturas)
        inicializarFactura()
        btnsubtotal.setOnClickListener { subtotal() }
        btnIngresarFacturas.setOnClickListener { guardarFactura() }
        btnVisualizarFacturas.setOnClickListener { visualizarFactura() }
    }

    private fun subtotal() {
        val intent = intent
        val hashMap = intent.getSerializableExtra("map") as HashMap<Int,Double>?
        val codigodeproducto=txtCodigoProductoFactura.text.toString().toInt()
        var cantidad = txtCantidaddeProductos.text.toString().toDouble()
        val precio = hashMap?.get(codigodeproducto)
        var subtotal = cantidad* precio!!
        txtsubtotal.setText("$subtotal")
        txtsubtotal.isEnabled=true

    }

    private fun inicializarFactura() {
            btnVisualizarFacturas.isEnabled = false
        txtsubtotal.isEnabled = false
        }

        private fun visualizarFactura() {
            val intent = Intent(this, BuscarFacturaActivity::class.java)
            intent.putExtra("facturas", facturas)
            startActivity(intent)
        }

        private fun guardarFactura() {
            val dato = StringBuilder()
            val IdeFactura = txtNoIdentidad.text.toString().toInt()
            dato.append("N° IDENTIDAD: ").append(txtNoIdentidad.text.toString().toInt()).append(" | FECHA DE FACTURA : ")
            dato.append(txtFechaFacturacion.text.toString()).append(" | N° DE IDENTIDAD DEL CLIENTE : ")
            dato.append(txtNoIdentidad.text.toString().toInt()).append(" | CODIGO DEL PRODUCTO: ")
            dato.append(txtCodigoProductoFactura.text.toString().toInt()).append(" | CANTIDAD LLEVADA : ")
            dato.append(txtCantidaddeProductos.text.toString())
            facturas.put(IdeFactura, dato.toString())
            txtNoIdentidad.setText("")
            txtFechaFacturacion.setText("")
            txtIdCliente.setText("")
            txtCodigoProductoFactura.setText("")
            txtCantidaddeProductos.setText("")
            txvEstadoFactura.setText("LA FACTURA DE $IdeFactura HA SIDO AGREGADO")
            btnVisualizarFacturas.isEnabled = true


        }


    }





