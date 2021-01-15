package com.mlwl.di.module

import com.jess.arms.di.scope.FragmentScope

import dagger.Module
import dagger.Provides

import com.mlwl.mvp.contract.InventoryContract
import com.mlwl.mvp.model.InventoryModel


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 01/15/2021 14:51
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
@Module
//构建InventoryModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class InventoryModule(private val view: InventoryContract.View) {
    @FragmentScope
    @Provides
    fun provideInventoryView(): InventoryContract.View {
        return this.view
    }

    @FragmentScope
    @Provides
    fun provideInventoryModel(model: InventoryModel): InventoryContract.Model {
        return model
    }
}
