package com.mwwl.mvp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jess.arms.di.component.AppComponent

import com.mwwl.di.component.DaggerRecordComponent
import com.mwwl.di.module.RecordModule
import com.mwwl.mvp.contract.RecordContract
import com.mwwl.mvp.presenter.RecordPresenter

import com.mwwl.R
import com.mwwl.base.BaseFragment
import kotlinx.android.synthetic.main.include_toolbar.*


/**
 * 记录
 */
class RecordFragment : BaseFragment<RecordPresenter>(), RecordContract.View {

    companion object {
        fun newInstance(): RecordFragment {
            val fragment = RecordFragment()
            return fragment
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerRecordComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .recordModule(RecordModule(this))
            .build()
            .inject(this)
    }

    override fun initView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

    override fun initToolBar() {
        toolbar.run {
            title = ""
            toolbarTitle.text = "记录"
        }
    }





}
