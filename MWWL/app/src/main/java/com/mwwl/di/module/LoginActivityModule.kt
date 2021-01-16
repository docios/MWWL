package com.mwwl.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.mwwl.mvp.contract.LoginActivityContract
import com.mwwl.mvp.model.LoginActivityModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/15/2021 14:45
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建LoginActivityModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class LoginActivityModule(private val view: LoginActivityContract.View) {
    @ActivityScope
    @Provides
    fun provideLoginActivityView(): LoginActivityContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideLoginActivityModel(model: LoginActivityModel): LoginActivityContract.Model {
        return model
    }
}
