package com.mlwl.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.mlwl.di.module.ProfileFragmentModule

import com.jess.arms.di.scope.FragmentScope
import com.mlwl.mvp.ui.fragment.ProfileFragment


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/15/2021 14:53
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@FragmentScope
@Component(
    modules = arrayOf(ProfileFragmentModule::class),
    dependencies = arrayOf(AppComponent::class)
)
interface ProfileFragmentComponent {
    fun inject(fragment: ProfileFragment)
}
