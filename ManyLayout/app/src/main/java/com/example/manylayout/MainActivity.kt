package com.example.manylayout // У вас может быть другое имя пакета

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Date // Обязательно импортируйте этот класс

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Логика из задания
        val date = Date()
        var time: Int // переменная для id макета

        // Проверка времени: если меньше 14 часов - один макет, иначе - другой
        // Примечание: date.hours устарел, но используется в задании.
        // Если студия выдаст ошибку, используйте Calendar (см. ниже).
        if (date.hours < 14) {
            time = R.layout.activity_main
        } else {
            time = R.layout.second
        }

        setContentView(time)
    }
}