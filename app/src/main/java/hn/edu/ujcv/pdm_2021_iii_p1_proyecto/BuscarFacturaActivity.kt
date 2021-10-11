package hn.edu.ujcv.pdm_2021_iii_p1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_buscar_factura.*
import kotlinx.android.synthetic.main.activity_buscar_producto.*
import kotlinx.android.synthetic.main.activity_ingresar_facturas.*

class BuscarFacturaActivity : AppCompatActivity() {
    var facturas : HashMap<Int, String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_factura)
        btnBuscarFactura.setOnClickListener { buscarFactura() }
    }

    private fun buscarFactura() {
        var intent = intent
        facturas = intent.getSerializableExtra("facturas") as HashMap<Int, String>
        val facturaabuscar = txtFacturaBuscar.text.toString().toInt()
        val facturasdeventa = facturas.get(facturaabuscar)
        txvMensajeFactura.setText("datos relevantes de la factura de venta de $facturaabuscar :")
        txvFacturaBuscada.setText(facturasdeventa)
    }

}