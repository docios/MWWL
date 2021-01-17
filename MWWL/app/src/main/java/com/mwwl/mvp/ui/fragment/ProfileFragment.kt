package com.mwwl.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.OnClick
import com.afollestad.materialdialogs.MaterialDialog

import com.jess.arms.di.component.AppComponent

import com.mwwl.di.component.DaggerProfileFragmentComponent
import com.mwwl.di.module.ProfileFragmentModule
import com.mwwl.mvp.contract.ProfileFragmentContract
import com.mwwl.mvp.presenter.ProfileFragmentPresenter

import com.mwwl.R
import com.mwwl.base.BaseFragment
import com.mwwl.utils.LogUtil
import kotlinx.android.synthetic.main.fragment_profile.*
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


    override fun initToolBar() {
        toolbar.run {
            title = ""
            toolbarTitle.text = "我的"
        }

    }

    override fun initData(savedInstanceState: Bundle?) {
        //版本号
        val versionName =
            _mActivity.packageManager.getPackageInfo(_mActivity.packageName, 0).versionName
        versionTv.setText("${versionName}")
    }

    @OnClick(R.id.exitLogin)
    fun onViewClicked(view: View) {
        when (view.id) {
            //退出登录
            R.id.exitLogin -> {
                MaterialDialog(_mActivity).show {
                    val inflate =
                        LayoutInflater.from(_mActivity)
                            .inflate(R.layout.dialog_exit_login, null, false)
                    setContentView(inflate)
                    cancelable(false)
                    inflate.findViewById<TextView>(R.id.cancleTv).setOnClickListener {
                        LogUtil.e("取消~~~~~~~~~")
                        dismiss()
                    }
                    inflate.findViewById<TextView>(R.id.submitTv).setOnClickListener {
                        LogUtil.e("确定~~~~~~~~~")
                        dismiss()
                    }
                }

            }
        }
    }

}
