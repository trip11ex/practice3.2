package com.example.practice32

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practice32.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.button1.setOnClickListener {
            val input = bindingClass.input.text.toString()
            when (true) {
                bindingClass.radioNumber.isChecked -> {
                    if (input.matches(Regex("[0-9]+"))) {
                        val telIntent: Intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("tel:$input")
                        )
                        startActivity(telIntent)
                    } else bindingClass.warning.text = "Номер некорректен"
                }

                bindingClass.radioGeo.isChecked -> {
                    val mapIntent: Intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=$input")
                    )
                    startActivity(mapIntent)
                }

                bindingClass.radioWeb.isChecked -> {
                    if (input.contains("https://") || input.contains("http://")) {
                        val webIntent: Intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse(input)
                        )
                        startActivity(webIntent)
                    } else bindingClass.warning.text = "Ссылка некорректна"
                }
                else -> bindingClass.warning.text = "Выберите радио-кнопку"
            }
        }

        bindingClass.button2.setOnClickListener {
            val input = bindingClass.input.text.toString()
            when (true) {
                input.matches(Regex("[0-9]+")) -> {
                    val telIntent: Intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("tel:$input")
                    )
                    startActivity(telIntent)
                }

                (input.contains("https://") || input.contains("http://")) -> {
                    val webIntent: Intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(input)
                    )
                    startActivity(webIntent)
                }

                else -> {
                    val mapIntent: Intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q=$input")
                    )
                    startActivity(mapIntent)
                }
            }
        }
    }
}