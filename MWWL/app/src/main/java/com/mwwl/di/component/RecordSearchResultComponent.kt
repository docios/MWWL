package com.mwwl.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.mwwl.di.module.RecordSearchResultModule

import com.jess.arms.di.scope.ActivityScope
import com.mwwl.mvp.ui.activity.RecordSearchResultActivity


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
@ActivityScope
@Component(
    modules = arrayOf(RecordSearchResultModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface RecordSearchResultComponent {
    fun inject(activity: RecordSearchResultActivity)
}
