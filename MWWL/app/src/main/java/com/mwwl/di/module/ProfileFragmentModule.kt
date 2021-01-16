package com.mwwl.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.mwwl.mvp.contract.ProfileFragmentContract
import com.mwwl.mvp.model.ProfileFragmentModel


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
@Module
//构建ProfileFragmentModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class ProfileFragmentModule(private val view: ProfileFragmentContract.View) {
    @FragmentScope
    @Provides
    fun provideProfileFragmentView(): ProfileFragmentContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideProfileFragmentModel(model: ProfileFragmentModel): ProfileFragmentContract.Model {
        return model
    }
}
