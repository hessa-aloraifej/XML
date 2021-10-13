package com.example.xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException

class MainActivity : AppCompatActivity() {
    lateinit var students :ArrayList<Students>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      var myRV=findViewById<RecyclerView>(R.id.myRV)

        try{
            val parser = XMLParser()
            val iStream = assets.open("student.xml")
            students = parser.parse(iStream)

            myRV.adapter=StudentsRVAdapter(students)
            myRV.layoutManager= LinearLayoutManager(this)

        }catch (e: IOException) {
            println("ISSUE: $e")
        }
    }
}