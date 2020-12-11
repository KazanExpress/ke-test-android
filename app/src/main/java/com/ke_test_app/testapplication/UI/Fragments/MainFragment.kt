package com.ke_test_app.testapplication.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ke_test_app.testapplication.R
import com.ke_test_app.testapplication.UI.Adapters.MainAdapter
import com.ke_test_app.testapplication.data.ArticleItemData
import com.ke_test_app.testapplication.data.Interfaces.RecycleClick
import com.ke_test_app.testapplication.data.ListsViewModel
import com.ke_test_app.testapplication.databinding.MainLayoutBinding

class MainFragment : Fragment(), RecycleClick {

    private lateinit var mainAdapter: MainAdapter
    lateinit var binding: MainLayoutBinding
    private val viewModel: ListsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainLayoutBinding.inflate(LayoutInflater.from(context), container, false)

        binding.toolbar.setTitle(R.string.article)

        binding.mainRv.layoutManager = LinearLayoutManager(context)
        binding.mainRv.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        mainAdapter = MainAdapter(requireContext(), viewModel.lists.value!!, this)
        binding.mainRv.adapter = mainAdapter

        return binding.root
    }

    override fun onCellClickListener(article: ArticleItemData) {
        viewModel.selectArticle(article)
    }

}