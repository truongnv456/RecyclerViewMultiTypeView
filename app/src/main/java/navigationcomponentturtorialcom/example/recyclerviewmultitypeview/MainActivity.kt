package navigationcomponentturtorialcom.example.recyclerviewmultitypeview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rcvUser: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mListUser = mutableListOf<User>()
        mListUser.add(User(R.drawable.img_1, "User 1 ", true))
        mListUser.add(User(R.drawable.img_2, "User 2 ", true))
        mListUser.add(User(R.drawable.img_3, "User 3 ", true))
        mListUser.add(User(R.drawable.img_4, "User 4 ", true))

        mListUser.add(User(R.drawable.img_1, "User 1 ", false))
        mListUser.add(User(R.drawable.img_2, "User 2 ", false))
        mListUser.add(User(R.drawable.img_3, "User 3 ", false))
        mListUser.add(User(R.drawable.img_4, "User 4 ", false))

        rcvUser = findViewById(R.id.rcv_user)
        val userAdapter = UserAdapter(mListUser)
        rcvUser.adapter = userAdapter
        rcvUser.layoutManager = LinearLayoutManager(this)
    }
}