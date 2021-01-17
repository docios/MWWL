package com.mwwl

import android.os.Bundle
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.jess.arms.utils.ArmsUtils
import com.mwwl.base.BaseActivity
import com.mwwl.utils.ShowUtils
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission


/**
 * 主界面
 */
class MainActivity : BaseActivity<IPresenter>() {

    var exitTime: Long = 0

    override fun setupActivityComponent(appComponent: AppComponent) {
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_main
    }
    override fun initToolBar() {
    }

    override fun initData(savedInstanceState: Bundle?) {
        if (findFragment(MainFragment::class.java) == null) {
            loadRootFragment(R.id.main_framelayout, MainFragment.newInstance())
        }

        //授权
        AndPermission.with(this@MainActivity)
            .runtime()
            .permission(
                Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE,
                Permission.ACCESS_COARSE_LOCATION, Permission.ACCESS_FINE_LOCATION,
                Permission.CAMERA
                )
            .onGranted {

            }
            .onDenied {
                ArmsUtils.snackbarText("部分权限已拒绝,将会影响正常使用")
            }
            .start()

    }

    override fun onBackPressedSupport() {
        if (System.currentTimeMillis() - this.exitTime > 2000L) {
            ShowUtils.showToast(this, "再按一次退出程序")
            this.exitTime = System.currentTimeMillis()
            return
        } else {
            super.onBackPressedSupport()
        }
    }



}
