package com.mwwl.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import butterknife.OnClick
import com.hjq.toast.ToastUtils
import com.jess.arms.di.component.AppComponent
import com.mwwl.MainActivity
import com.mwwl.R
import com.mwwl.base.BaseActivity
import com.mwwl.di.component.DaggerLoginActivityComponent
import com.mwwl.di.module.LoginActivityModule
import com.mwwl.mvp.contract.LoginActivityContract
import com.mwwl.mvp.presenter.LoginActivityPresenter
import org.jetbrains.anko.startActivity


/**
 *登录
 */
class LoginActivity : BaseActivity<LoginActivityPresenter>(), LoginActivityContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLoginActivityComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .loginActivityModule(LoginActivityModule(this))
            .build()
            .inject(this)
    }


    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_login
    }


    override fun initData(savedInstanceState: Bundle?) {

    }
    @OnClick(R.id.nextBt)
    fun onViewClicked(view: View) {
        when (view.id) {
            //查询
            R.id.nextBt -> {
                startActivity<MainActivity>()
            }
        }

    }
}
