package mx.tecnm.tepic.ladm_u2_practica1_coposdenieve_gustavomarinlemus

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class CopoDeNieve(l:Lienzo) {
    private var x = 0f
    private var y = 0f
    private var movX = 0f
    private var movY = 0f
    private var color = Color.rgb(200,224,228)
    private var radio = 0f
    private var copoCaido = false
    init{
        darAtributo()
    }
    fun mover(){
       if(!copoCaido){
            y+=movY
        }
        if (y>1520){
            copoCaido = true
        }
    }
    fun pintar(canvas : Canvas){
        var p = Paint()
        p.color = color
        canvas.drawCircle(x,y,radio,p)
    }
    fun darAtributo(){
        x = rand(1080)
        y = (rand(700)*-1)-10
        movY = rand(10)+5
        radio = rand(15)+6f
        copoCaido = false
    }
    private fun rand(limite:Int): Float{
        return Random.nextInt(limite).toFloat()
    }
}