package com.example.booklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.booklist.databinding.ActivityDetailBinding

class DetailActivity : ComponentActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookID = intent.getIntExtra(BOOK_ID_EXTRA, -1)
        val book = bookFromID(bookID)
        if(book != null)
        {
            binding.cover.setImageResource(book.cover)
            binding.title.text = book.title
            binding.description.text = book.description
            binding.author.text = book.author

        }

        val backButton = findViewById<ImageButton>(R.id.imageButtonBackToList)

        backButton.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun bookFromID(bookID: Int): Book?
    {
        for(book in bookList)
        {
            if(book.id == bookID)
                return book
        }
        return null
    }


}