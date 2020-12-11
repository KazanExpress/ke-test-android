package com.ke_test_app.testapplication.data.Interfaces

import com.ke_test_app.testapplication.data.ArticleItemData

// Интерфейс для обработки кликов по RecycleView
interface RecycleClick {
    fun onCellClickListener(article : ArticleItemData)
}