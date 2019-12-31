package com.eeearl.hackernews.presentation.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.eeearl.BR
import com.eeearl.R
import com.eeearl.hackernews.repository.NewsListRepositoryContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewsListAdapter(
    private val mList: ArrayList<Int>,
    private val apiClient: NewsListRepositoryContract
): RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ViewDataBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindId(item: Int) {
            binding.setVariable(BR.itemId, "$item")

        }

        fun setTitle(t: String) {
            binding.setVariable(BR.title, t)
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

        GlobalScope.launch(Dispatchers.Default) {
             apiClient.loadItem(item, success = {
                 holder.setTitle(it._title)
            })
        }
    }

    fun setList(list: List<Int>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

}