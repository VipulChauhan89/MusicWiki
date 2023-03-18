package com.vipul.musicwiki

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vipul.musicwiki.repository.Repository
import com.vipul.musicwiki.viewmodel.MainViewModel

class MainViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}