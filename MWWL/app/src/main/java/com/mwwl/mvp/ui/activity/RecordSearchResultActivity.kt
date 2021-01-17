package com.mwwl.mvp.ui.activity

import android.content.Intent
import android.os.Bundle

import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils

import com.mwwl.di.component.DaggerRecordSearchResultComponent
import com.mwwl.di.module.RecordSearchResultModule
import com.mwwl.mvp.contract.RecordSearchResultContract
import com.mwwl.mvp.presenter.RecordSearchResultPresenter

import com.mwwl.R


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/17/2021 11:10
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
/**
 * 如果没presenter
 * 你可以这样写
 *
 * @ActivityScope(請注意命名空間) class NullObjectPresenterByActivity
 * @Inject constructor() : IPresenter {
 * override fun onStart() {
 * }
 *
 * override fun onDestroy() {
 * }
 * }
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
        return R.layout.activity_record_search_result //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }


    override fun initData(savedInstanceState: Bundle?) {

    }


    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }

    override fun killMyself() {
        finish()
    }
}
