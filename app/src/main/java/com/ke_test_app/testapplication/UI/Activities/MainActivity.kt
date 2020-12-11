package com.ke_test_app.testapplication.UI.Activities

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.ke_test_app.testapplication.R
import com.ke_test_app.testapplication.UI.Fragments.DetailsFragment
import com.ke_test_app.testapplication.UI.Fragments.MainFragment
import com.ke_test_app.testapplication.data.ArticleItemData
import com.ke_test_app.testapplication.data.Interfaces.DetailClick
import com.ke_test_app.testapplication.data.ListsViewModel
import com.ke_test_app.testapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val viewModel: ListsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        //////////////////////////////////////////////
        // Задание не доделано
        //////////////////////////////////////////////

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Сразу получаем и выводим весь список
        viewModel.lists.observe(this, Observer { lists ->
            if (lists.isNullOrEmpty()) {
                showErrorToast(resources.getString(R.string.noData))
            } else {
                showFragmentWithData()
            }
            Log.d("000000000", "viewModel.lists")
        })

        // Ждем клик из recycleview с нужной статьей
        viewModel.selectedArticle.observe(this, Observer { article ->
            showFragmentWithDetails(article)
        })
    }

    private fun showFragmentWithData() {
        // Показываем главный фрагмент - со списком
        val mainFragment: MainFragment = MainFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.main_fr_main, mainFragment::class.java, null)
            .commit()
    }

    private fun showFragmentWithDetails(article: ArticleItemData) {
        // Показываем фрагмент с деталями статьи
        val detailsFragment = DetailsFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_fr_main, detailsFragment::class.java, null)
            .commit()
    }

    private fun showErrorToast(message: String?) {
        // Показываем тост с ошибкой
        Toast.makeText(this, message ?: resources.getString(R.string.noData), Toast.LENGTH_SHORT).show()
    }



}

