package com.ke_test_app.testapplication

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.TextureView
import android.widget.TextView
import com.ke_test_app.testapplication.data.ArticlesRepository

class MainActivity : AppCompatActivity() {

    //Данные о статьях: ArticlesRepository.loadArticles()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}