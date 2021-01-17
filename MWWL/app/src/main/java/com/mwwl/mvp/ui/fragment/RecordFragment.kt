package com.mwwl.mvp.ui.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick

import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.mwwl.di.component.DaggerRecordComponent
import com.mwwl.di.module.RecordModule
import com.mwwl.mvp.contract.RecordContract
import com.mwwl.mvp.presenter.RecordPresenter

import com.mwwl.R
import com.mwwl.base.BaseFragment
import com.mwwl.mvp.ui.activity.RecordSearchResultActivity
import com.mwwl.utils.LogUtil
import com.yanzhenjie.permission.AndPermission
import com.yanzhenjie.permission.runtime.Permission
import com.yzq.zxinglibrary.android.CaptureActivity
import com.yzq.zxinglibrary.common.Constant
import kotlinx.android.synthetic.main.fragment_inventory.*
import kotlinx.android.synthetic.main.fragment_record.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.startActivityForResult


/**
 * 记录
 */
class RecordFragment : BaseFragment<RecordPresenter>(), RecordContract.View {
    val REQUEST_CODE_SCAN = 101

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


    @OnClick(R.id.scanIV, R.id.queryTv)
    fun onViewClicked(view: View) {
        when (view.id) {
            //扫描
            R.id.scanIV -> {
                //授权
                AndPermission.with(_mActivity)
                    .runtime()
                    .permission(
                        Permission.CAMERA
                    )
                    .onGranted {
                        val intent = Intent()
                        intent.setClass(activity!!, CaptureActivity::class.java)
                        startActivityForResult(intent, REQUEST_CODE_SCAN)
                    }
                    .onDenied {
                        ArmsUtils.snackbarText("拍照权限已拒绝,将会影响正常使用")
                    }
                    .start()


            }
            //查询
            R.id.queryTv -> {
                val rfid = rfidNumber.text.toString()
                val intent = Intent()
//                intent.putExtra("rfif",rfid)
                intent.setClass(_mActivity, RecordSearchResultActivity::class.java)
                launchActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                val content: String = data.getStringExtra(Constant.CODED_CONTENT)
                rfidNumber.setText("$content")
            }
        }

    }

}
