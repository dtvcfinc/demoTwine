package com.dani.demotwine.repo_list

import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dani.demotwine.R
import com.dani.demotwine.databinding.FragmentListRepoBinding
import com.dani.demotwine.repositories.GitHub
import rx.android.schedulers.AndroidSchedulers
import timber.log.Timber.e


/**
 * Created by dani on 4/05/17.
 */
class RepoListView : Fragment() {
    private lateinit var binding: FragmentListRepoBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentListRepoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GitHub.getRepos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    list ->
                    val listViewModels = list.map {
                        RepositoryViewModel(it, context)
                    }
                    binding.repoList.layoutManager = LinearLayoutManager(this.context)
                    binding.repoList.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                    val adapter = RepoListAdapter(listViewModels,
                            onRepoclick = {
                                repoViewModel ->
                                val url = repoViewModel.repository.repositoryUrl
                                val builder =  CustomTabsIntent.Builder()
                                val customTabsIntent = builder.build()
                                val color = ContextCompat.getColor(context, R.color.colorPrimary)
                                builder.setToolbarColor(color)
                                builder.setShowTitle(true)
                                customTabsIntent.launchUrl(context, Uri.parse(url))
                            }
                    )
                    binding.repoList.adapter = adapter
                }, ::e)
    }
}