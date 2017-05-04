package com.dani.demotwine.repo_list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dani.demotwine.databinding.ItemRepositoryBinding

/**
 * Created by dani on 4/05/17.
 */
class RepoListAdapter(val repos: List<RepositoryViewModel>,
                      val onRepoclick: (RepositoryViewModel) -> Unit) : RecyclerView.Adapter<RepoViewHolder>() {

    override fun getItemCount(): Int = repos.count()

    override fun onBindViewHolder(holder: RepoViewHolder?, position: Int) {
        holder?.bind(repos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RepoViewHolder? {
        val inflater = LayoutInflater.from(parent?.context)
        val binding = ItemRepositoryBinding.inflate(inflater, parent, false)
        return RepoViewHolder(binding, onRepoclick)
    }
}

class RepoViewHolder(val binding: ItemRepositoryBinding,
                     val onClick: (RepositoryViewModel) -> Unit) : RecyclerView.ViewHolder(binding.root) {
    fun bind(repoViewModel: RepositoryViewModel) {
        binding.repository = repoViewModel
        binding.root.setOnClickListener {
            onClick(repoViewModel)
        }
        binding.executePendingBindings()
    }
}
