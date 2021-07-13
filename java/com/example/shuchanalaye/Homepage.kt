package com.example.shuchanalaye


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*

class Homepage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)
        // Initializing the array lists and the adapter
        val itemList = arrayListOf<String>()
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice
                , itemList)
        // Adding the items to the list when the add button is pressed

        val add = findViewById<Button>(R.id.add)
        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)
        val clear = findViewById<Button>(R.id.clear)
        val delete = findViewById<Button>(R.id.delete)

        add.setOnClickListener {
            itemList.add(editText.text.toString())
            listView.adapter =  adapter
            // This is because every time when you add the item the input space or the eidt text space will be cleared
            editText.text.clear()
        }
        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {

            itemList.clear()
            adapter.notifyDataSetChanged()
        }
        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { _, _, i, l ->
            Toast.makeText(this, "You Selected the item --> "+itemList.get(i), Toast.LENGTH_SHORT).show()
        }
        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemList.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }
    }
}