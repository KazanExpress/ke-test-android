package com.ke_test_app.testapplication.UI.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ke_test_app.testapplication.R
import com.ke_test_app.testapplication.UI.Transformation.CircleTransformation
import com.ke_test_app.testapplication.data.ArticleItemData
import com.ke_test_app.testapplication.data.Interfaces.DetailClick
import com.ke_test_app.testapplication.data.Interfaces.RecycleClick
import com.ke_test_app.testapplication.data.ListsViewModel
import com.ke_test_app.testapplication.data.Utils.changeData
import com.ke_test_app.testapplication.databinding.DetailLayoutBinding
import com.squareup.picasso.Picasso

class DetailsFragment : Fragment(), DetailClick {

    lateinit var binding: DetailLayoutBinding
    private val viewModel: ListsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailLayoutBinding.inflate(LayoutInflater.from(context), container, false)

        val article : ArticleItemData = viewModel.selectedArticle.value ?: ArticleItemData()

        binding.tvDate.text = changeData(article.date)
        binding.tvTitle.text = article.title
        binding.tvAuthor.text = article.author
        binding.tvDesc.text = article.description

        Picasso
            .get()
            .load(article.authorAvatar)
            .resize(400, 400)
            .transform(CircleTransformation())
            .centerCrop()
            .into(binding.ivAuthor)

        Picasso
            .get()
            .load(article.poster)
            .into(binding.ivLogo)

        // back click
        binding.mainBnvTop.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
//                R.id.back -> {
//                    onDetailClickListener()
//                    return@setOnNavigationItemSelectedListener true
//                }
            }
            false
        }

        return binding.root
    }

    override fun onDetailClickListener() {
        // TODO возврат обратно к главному экрану
        viewModel.lists
    }


}