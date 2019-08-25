package co.edu.uan.numberaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun PlayAgain(view: View){
        if(txtAttemptNumber.text.toString().isNullOrEmpty()){
            Toast.makeText(this, "valor no valido", Toast.LENGTH_SHORT).show()
        }else{
            val intent = Intent(this, co.edu.uan.numberaplication.NumberGuessActivity::class.java)
            intent.putExtra("number", txtAttemptNumber.text.toString().toInt())
            startActivity(intent)
        }
    }
}
