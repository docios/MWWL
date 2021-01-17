package com.mwwl.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jess.arms.di.component.AppComponent

import com.mwwl.di.component.DaggerProfileFragmentComponent
import com.mwwl.di.module.ProfileFragmentModule
import com.mwwl.mvp.contract.ProfileFragmentContract
import com.mwwl.mvp.presenter.ProfileFragmentPresenter

import com.mwwl.R
import com.mwwl.base.BaseFragment
import kotlinx.android.synthetic.main.include_toolbar.*


/**
 * 我的
 */
class ProfileFragment : BaseFragment<ProfileFragmentPresenter>(),
    ProfileFragmentContract.View {
    companion object {
        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerProfileFragmentComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .profileFragmentModule(ProfileFragmentModule(this))
            .build()
            .inject(this)
    }

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initToolBar() {
        toolbar.run {
            title = ""
            toolbarTitle.text = "我的"
        }

    }
}
