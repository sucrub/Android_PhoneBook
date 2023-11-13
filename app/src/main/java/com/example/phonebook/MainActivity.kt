package com.example.phonebook

import User
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail_recycle.MyAdapter
import com.example.phonebook.ui.theme.PhoneBookTheme
import java.util.*
import android.view.*

val userList = listOf(
    User(1, "Alice", "123-456-789001", "alice@gmail.com"),
    User(2, "Bob", "123-456-789002", "bob@gmail.com"),
    User(3, "Charlie", "123-456-789003", "charlie@gmail.com"),
    User(4, "David", "123-456-789004", "david@gmail.com"),
    User(5, "Eva", "123-456-789005", "eva@gmail.com"),
    User(6, "Frank", "123-456-789006", "frank@gmail.com"),
    User(7, "Grace", "123-456-789007", "grace@gmail.com"),
    User(8, "Harry", "123-456-789008", "harry@gmail.com"),
    User(9, "Ivy", "123-456-789009", "ivy@gmail.com"),
    User(10, "Jack", "123-456-789010", "jack@gmail.com"),
    User(11, "Katie", "123-456-789011", "katie@gmail.com"),
    User(12, "Leo", "123-456-789012", "leo@gmail.com"),
    User(13, "Mia", "123-456-789013", "mia@gmail.com"),
    User(14, "Noah", "123-456-789014", "noah@gmail.com"),
    User(15, "Olivia", "123-456-789015", "olivia@gmail.com"),
    User(16, "Peter", "123-456-789016", "peter@gmail.com"),
    User(17, "Quinn", "123-456-789017", "quinn@gmail.com"),
    User(18, "Ryan", "123-456-789018", "ryan@gmail.com"),
    User(19, "Sara", "123-456-789019", "sara@gmail.com"),
    User(20, "Tom", "123-456-789020", "tom@gmail.com")
)

class MainActivity : ComponentActivity() {

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(userList)
        rv.adapter = myAdapter
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val clickedUser = myAdapter.getClickedUser()
        Log.d("TAG", clickedUser.toString())
        return when (item.itemId) {
            R.id.action_call -> {
                Log.d("TAG", "Call " + clickedUser?.getUserPhone())
                Toast.makeText(this@MainActivity, "Call " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_message -> {
                Log.v("TAG", "Send message to " + clickedUser?.getUserPhone())
                Toast.makeText(this, "Send message to " + clickedUser?.getUserPhone(), Toast.LENGTH_LONG).show()
                true
            }
            R.id.action_send_email -> {
                Log.v("TAG", "Send email to " + clickedUser?.getUserEmail())
                Toast.makeText(this, "Send email to " + clickedUser?.getUserEmail(), Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}

