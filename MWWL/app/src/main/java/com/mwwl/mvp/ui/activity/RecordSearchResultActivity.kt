package com.mwwl.mvp.ui.activity

import android.os.Bundle

import com.jess.arms.di.component.AppComponent

import com.mwwl.di.module.RecordSearchResultModule
import com.mwwl.mvp.contract.RecordSearchResultContract
import com.mwwl.mvp.presenter.RecordSearchResultPresenter

import com.mwwl.R
import com.mwwl.base.BaseActivity
import com.mwwl.di.component.DaggerRecordSearchResultComponent
import kotlinx.android.synthetic.main.include_toolbar.*


/**
 *查询搜索结果
 */
class RecordSearchResultActivity : BaseActivity<RecordSearchResultPresenter>(),
    RecordSearchResultContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerRecordSearchResultComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .recordSearchResultModule(RecordSearchResultModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_record_search_result
    }




    override fun initToolBar() {
        toolbar.run {
            title = ""
            toolbarTitle.text = "查询"
            setSupportActionBar(this)
            setNavigationIcon(R.drawable.ic_left)
            setNavigationOnClickListener {
                finish()
            }
        }
    }

    override fun initData(savedInstanceState: Bundle?) {

    }

}
