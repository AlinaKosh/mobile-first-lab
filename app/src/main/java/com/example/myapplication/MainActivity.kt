package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    private lateinit var nameValue: EditText
    private lateinit var ageValue: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var sendButton: Button
    private lateinit var resetButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
//        setContent {
//            MyApplicationTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                }
//            }
//        }

        nameValue = findViewById(R.id.inputName)
        ageValue = findViewById(R.id.inputAge)

        sendButton = findViewById(R.id.send)
        resetButton = findViewById(R.id.reset)

        radioGroupGender = findViewById(R.id.radioGroupGender)

        sendButton.setOnClickListener {
            val name = nameValue.text.toString()
            if (!name.matches(Regex("^[a-zA-Zа-яА-Я]+$"))) {
                nameValue.error = "Имя должно содержать только буквы"
            } else {
                nameValue.error = null
            }
            val age = ageValue.text.toString()
            if (!age.matches(Regex("^(?:100|\\d{1,2})$"))) {
                ageValue.error = "Возраст должен быть числом от 0 до 100"
            } else {
                ageValue.error = null
            }
            val selectedGender = findViewById<RadioButton>(radioGroupGender.checkedRadioButtonId)
            if (radioGroupGender.checkedRadioButtonId == -1) {
                Toast.makeText(this, "Выберите пол", Toast.LENGTH_SHORT).show()
            }

            if (name.matches(Regex("^[a-zA-Zа-яА-Я]+$")) && age.matches(Regex("^(?:100|\\d{1,2})$")) && radioGroupGender.checkedRadioButtonId != -1) {
                val intent = Intent(this, MainActivity2Activity::class.java)
                intent.putExtra("name", name)
                intent.putExtra("age", age)
                intent.putExtra("gender", selectedGender.text)
                startActivity(intent)
            }
        }

        resetButton.setOnClickListener {
            nameValue.text.clear()
            ageValue.text.clear()
            radioGroupGender.clearCheck()
            nameValue.error = null
            ageValue.error = null
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}