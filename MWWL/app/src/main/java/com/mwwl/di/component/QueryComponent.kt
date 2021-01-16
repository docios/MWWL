package com.mwwl.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.mwwl.di.module.QueryModule

import com.jess.arms.di.scope.FragmentScope
import com.mwwl.mvp.ui.fragment.QueryFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/15/2021 14:54
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(modules = arrayOf(QueryModule::class), dependencies = arrayOf(AppComponent::class))
interface QueryComponent {
    fun inject(fragment: QueryFragment)
}
