package com.gokselkoc.tmdb.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
abstract class BaseVmDbFragment<DB : ViewDataBinding> :
    BaseFragment() {

    private  var _viewBinding: DB? = null
    val viewBinding: DB get() = _viewBinding!!

    open fun DB.initialize() {}
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _viewBinding = DataBindingUtil.inflate(inflater, getResourceLayoutId(), container, false)
        viewBinding.lifecycleOwner = viewLifecycleOwner
        setHasOptionsMenu(true)
        viewBinding.initialize()
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onInitDataBinding()
    }

    abstract fun onInitDataBinding()

    override fun onDestroyView() {
        super.onDestroyView()
        _viewBinding = null
    }

}