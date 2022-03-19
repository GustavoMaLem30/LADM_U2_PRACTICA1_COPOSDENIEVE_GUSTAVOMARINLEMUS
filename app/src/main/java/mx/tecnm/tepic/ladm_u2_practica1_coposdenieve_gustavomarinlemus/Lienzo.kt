package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_gustavomarinlemus

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity) : View(este) {
    private var este = este
    private var global = 0
    private val coposdenieveLigera = Array<CopoDeNieve>(30,{ CopoDeNieve((this)) })
    private val coposdenieveMedia = Array<CopoDeNieve>(70,{ CopoDeNieve((this)) })
    private val coposdenievePesada = Array<CopoDeNieve>(120,{ CopoDeNieve((this)) })
    private val coroutine = GlobalScope.launch {
        while (true){
            este.runOnUiThread(){
                invalidate()
            }
            delay(50L)
        }
    }
    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        global++
        var p = Paint()
        c.drawColor(Color.rgb(37, 40, 80))
        p.color = Color.WHITE
        p.textSize = 40f
        c.drawText("BY GUSTAVO MARIN LEMUS", 100f, 100f, p)
        ////BLOQUE CALLE
        p.color = (Color.rgb(60, 60, 60))
        c.drawRect(0f, 1250f, width.toFloat(), 1500f, p)
        p.color = Color.WHITE
        c.drawRect(0f, 1270f, width.toFloat(), 1280f, p)
        c.drawRect(0f, 1470f, width.toFloat(), 1480f, p)
        c.drawRect(125f, 1350f, 250f, 1400f, p)
        c.drawRect(350f, 1350f, 475f, 1400f, p)
        c.drawRect(575f, 1350f, 700f, 1400f, p)
        c.drawRect(800f, 1350f, 925f, 1400f, p)
        //BLOQUE ARBOLES
        p.color = Color.rgb(161, 130, 98)
        c.drawRect(100f, 1050f, 180f, 1250f, p)
        p.color = Color.rgb(0, 143, 57)
        c.drawCircle(140f, 990f, 100f, p)
        c.drawCircle(110f, 900f, 50f, p)
        c.drawCircle(180f, 900f, 50f, p)
        c.drawCircle(180f, 1070f, 50f, p)
        c.drawCircle(110f, 1070f, 50f, p)
        c.drawCircle(230f, 940f, 50f, p)
        c.drawCircle(230f, 1020f, 50f, p)
        c.drawCircle(60f, 940f, 50f, p)
        c.drawCircle(60f, 1020f, 50f, p)

        //BLOQUE PASTO CONGELADO
        p.color = Color.rgb(200,224,228)
        c.drawRect(0f, 1500f, width.toFloat(), height.toFloat(), p)

        //BLOQUE CASA
        p.color = Color.rgb(59, 131, 189)
        c.drawRect(350f, 950f, 800f, 1250f, p)

        p.color = Color.YELLOW
        c.drawRect(400f, 1030f, 600f, 1150f, p)

        p.color = Color.BLACK
        p.strokeWidth = 4f
        c.drawLine(400f, 1090f, 600f, 1090f, p)
        c.drawLine(470f, 1030f, 470f, 1150f, p)
        c.drawLine(535f, 1030f, 535f, 1150f, p)
        p.strokeWidth = 9f
        c.drawLine(400f, 1152f, 600f, 1152f, p)

        p.color = Color.WHITE
        c.drawRect(650f, 1120f, 750f, 1250f, p)
        p.color = Color.rgb(59, 131, 189)
        c.drawCircle(730f, 1180f, 10f, p)

        p.color = Color.rgb(75, 86, 147)
        c.drawRect(320f, 850f, 830f, 950f, p)

        p.color = Color.rgb(45, 108, 159)
        c.drawRect(350f, 950f, 800f, 970f, p)

        //LUNA
        p.color = Color.rgb(243, 225, 163)
        c.drawCircle(300f, 300f, 150f, p)

        p.color = Color.rgb(37, 40, 80)
        c.drawCircle(400f, 330f, 130f, p)
        p.color = Color.rgb(174, 154, 114)
        c.drawCircle(200f, 350f, 20f, p)
        c.drawCircle(220f, 250f, 50f, p)
        //LINEAS NEGRAS
        p.style = Paint.Style.STROKE
        p.strokeWidth = 1f
        //CASA
        p.color = Color.BLACK
        c.drawRect(350f, 950f, 800f, 1250f, p)
        //ventana
        c.drawRect(400f, 1030f, 600f, 1150f, p)
        //Puerta
        c.drawRect(650f, 1120f, 750f, 1250f, p)
        c.drawCircle(730f, 1180f, 10f, p)

        //LLAMADA DE COPOS DE NIEVE
        if (global > 0 ) {
            for (i in 0..coposdenieveLigera.size - 1) {
                coposdenieveLigera[i].mover()
                coposdenieveLigera[i].pintar(c)
            }
        }
        if (global > 150) {
            for (i in 0..coposdenieveMedia.size - 1) {
                coposdenieveMedia[i].mover()
                coposdenieveMedia[i].pintar(c)
            }

            if (global > 300) {
                for (i in 0..coposdenievePesada.size - 1) {
                    coposdenievePesada[i].mover()
                    coposdenievePesada[i].pintar(c)
                }
            }
            if (global > 750){
                global = 1
                for (i in 0..coposdenievePesada.size-1){
                    if (i<=coposdenieveLigera.size-1) coposdenieveLigera[i].darAtributo()
                    if (i<=coposdenieveMedia.size-1) coposdenieveMedia[i].darAtributo()
                    coposdenievePesada[i].darAtributo()
                }
            }
        }
    }
}
