package com.ke_test_app.testapplication.UI.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ke_test_app.testapplication.R
import com.ke_test_app.testapplication.UI.Transformation.CornerTransformation
import com.ke_test_app.testapplication.data.ArticleItemData
import com.ke_test_app.testapplication.data.Interfaces.RecycleClick
import com.ke_test_app.testapplication.data.Utils.changeData
import com.ke_test_app.testapplication.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class MainAdapter(private val context : Context,
                  val datas : List<ArticleItemData>,
                  private val recycleClick: RecycleClick
                  ) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {

    //        holder.itemBinding.avg.setActicle(datas[position])

        holder.itemBinding.tvDate.text = changeData(datas[position].date)
        holder.itemBinding.tvAuthor.text = datas[position].author
        holder.itemBinding.tvTitle.text = datas[position].title
        holder.itemBinding.tvDesc.text = datas[position].description
        holder.itemBinding.tvLikeCount.text = datas[position].likeCount.toString()
        holder.itemBinding.tvMessageCount.text = datas[position].commentCount.toString()
        holder.itemBinding.tvRead.text = "${datas[position].readDuration} ${context.resources.getString(R.string.read)}"

        Picasso
            .get()
            .load(datas[position].poster)
            .resize(400, 400)
            .centerCrop()
            .transform(CornerTransformation())
            .into(holder.itemBinding.ivLogo)

        holder.itemView.setOnClickListener {
            recycleClick.onCellClickListener(datas[position])
        }
    }
}

class DataViewHolder(val itemBinding: ItemLayoutBinding) : RecyclerView.ViewHolder(itemBinding.root){

    private var binding : ItemLayoutBinding? = null

    init {
        this.binding = itemBinding
    }

}