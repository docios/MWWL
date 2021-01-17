package com.mwwl.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.mwwl.di.module.InventoryUpLoadModule

import com.jess.arms.di.scope.ActivityScope
import com.mwwl.mvp.ui.activity.InventoryUpLoadActivity


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/17/2021 15:09
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@ActivityScope
@Component(
    modules = arrayOf(InventoryUpLoadModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface InventoryUpLoadComponent {
    fun inject(activity: InventoryUpLoadActivity)
}
