package com.bipash.labsessionsix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var radioGroup: RadioGroup
    private lateinit var txtName : EditText
    private lateinit var txtAddress : EditText
    private lateinit var txtPhoneNumber : EditText
    private lateinit var btnSubmit : Button
    var list = arrayListOf<Person>()
    lateinit var gender:String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtName = findViewById(R.id.txtName)
        txtAddress = findViewById(R.id.txtAddress)
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber)
        btnSubmit = findViewById(R.id.btnSubmit)
        radioGroup = findViewById(R.id.rg)
        radioGroup.setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when(checkedId){
                    R.id.rdoFemale->{
                        gender = "Femal"
                    }
                    R.id.rdoMale->{
                        gender = "Male"
                    }
                }
            }

        })

        btnSubmit.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnSubmit ->{
                val name = txtName.text.toString()
                val address = txtAddress.text.toString()
                val phoneNumber = txtPhoneNumber.text.toString()
                var person = Person(name,address,phoneNumber,gender)
                list.add(person)

                startActivity(Intent(this,ListViewActivity::class.java)
                    .putExtra("data",list))

            }
        }
    }
}