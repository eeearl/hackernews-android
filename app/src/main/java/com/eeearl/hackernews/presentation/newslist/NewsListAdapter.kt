package com.eeearl.hackernews.presentation.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.eeearl.BR
import com.eeearl.R

class NewsListAdapter(
    private val mList: ArrayList<Int>
): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindId(item: Int) {
            binding.setVariable(BR.itemId, "$item")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.row_news, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mList[position]
        holder.bindId(item)
    }

    fun setList(list: List<Int>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

}