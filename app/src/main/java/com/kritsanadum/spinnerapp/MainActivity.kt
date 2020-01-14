package com.kritsanadum.spinnerapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var dataList  = arrayOf("Java","Kotlin","Swift","Python","Scala","Perl")
    var context = this@MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spinner = findViewById<Spinner>(R.id.spinner)
        if(spinner != null){

            var mAdapter = ArrayAdapter(context,android.R.layout.simple_spinner_item,dataList)

            spinner.adapter = mAdapter
        }


        btn_selected.setOnClickListener {

            tv_header.text = spinner.selectedItem.toString()
        }

        spinner?.onItemSelectedListener  = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                tv_header.text = dataList.get(position)

            }


        }

        btn_alert.setOnClickListener {

            var bulider = AlertDialog.Builder(context)

            bulider.setTitle("This is title!")

            bulider.setMessage("This is message!!!")

            bulider.setNegativeButton("Set Green"){dialog, which ->

                root_view.setBackgroundColor(Color.GREEN)
            }

            bulider.setPositiveButton("Set Red"){dialog, which ->

                root_view.setBackgroundColor(Color.RED)
            }

            bulider.setNeutralButton("Set Yellow"){dialog, which ->

                root_view.setBackgroundColor(Color.YELLOW)
            }

            var dialog : AlertDialog = bulider.create()
            dialog.show()

        }


    }
}
