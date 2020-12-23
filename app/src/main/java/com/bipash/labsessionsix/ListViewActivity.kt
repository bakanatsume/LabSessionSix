package com.bipash.labsessionsix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class ListViewActivity : AppCompatActivity() {

    private lateinit var listView : ListView
    private lateinit var txtView : TextView
    private lateinit var profile:ArrayList<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        profile = intent.getSerializableExtra("data") as ArrayList<Person>;
        
        listView = findViewById(R.id.listView)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            profile
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val showResult = parent.getItemAtPosition(position).toString()
            txtView.text = showResult
        }
    }
}