package co.edu.uan.numberaplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_play.*
import java.util.*


class NumberGuessActivity : AppCompatActivity() {

    var numberAttempts=0
    var numberAttemptsCompleted=0
    var number=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)
        numberAttempts = intent.getIntExtra("number",0)
        number=valorRandom()
        changeTextAttemp()
    }

    fun testNumber(view: View){

            if(txtNumberInput.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "valor no valido", Toast.LENGTH_SHORT).show()
            }else{
                if(txtNumberInput.text.toString().toInt()>number){
                    Toast.makeText(this ,"Te pasaste",Toast.LENGTH_SHORT).show()
                    changeImage("red")
                }else if(txtNumberInput.text.toString().toInt()<number){
                    Toast.makeText(this ,"Sumale",Toast.LENGTH_SHORT).show()
                    changeImage("green")
                }else{
                    Toast.makeText(this ,"Gano!",Toast.LENGTH_SHORT).show()
                    changeImage("approved")
                    buttonTest.isClickable=false
                }
            }
        numberAttemptsCompleted++
        changeTextAttemp()
        progressBar.setProgress(progressBar.progress-(100/numberAttempts))
        if(numberAttemptsCompleted==numberAttempts){
            buttonTest.isClickable=false
        }
    }

    fun Reset(view: View){
        val intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
    }

    fun valorRandom(): Int {
        var value = Random().nextInt((1001-1))+1
        return value
    }

    fun changeTextAttemp(){
        remainingAttempts.setText(numberAttemptsCompleted.toString()+"/"+numberAttempts.toString())
    }

    fun changeImage(name: String){
        var imageResource = resources.getIdentifier(name,"drawable",packageName)
        if(imageResource==null){
            Toast.makeText(this,"Image not found",Toast.LENGTH_SHORT).show()
            return
        }
        imageView.setImageResource(imageResource)
    }
}
