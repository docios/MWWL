package com.mwwl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jess.arms.di.component.AppComponent
import com.jess.arms.mvp.IPresenter
import com.mwwl.base.BaseFragment
import com.mwwl.mvp.ui.fragment.InventoryFragment
import com.mwwl.mvp.ui.fragment.ProfileFragment
import com.mwwl.mvp.ui.fragment.RecordFragment
import com.mwwl.utils.SettingUtil
import kotlinx.android.synthetic.main.fragment_main.*


import me.yokeyword.fragmentation.SupportFragment


/**
 *主页
 */
class MainFragment : BaseFragment<IPresenter>() {
    private val one = 0
    private val two = 1
    private val three = 2
    private val mFragments = arrayOfNulls<SupportFragment>(3)

    companion object {
        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun setupFragmentComponent(appComponent: AppComponent) {}

    override fun initView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {

        val inventoryFragment = findChildFragment(InventoryFragment::class.java)
        if (inventoryFragment == null) {
            mFragments[one] = InventoryFragment.newInstance()//盘点
            mFragments[two] = RecordFragment.newInstance()//记录
            mFragments[three] = ProfileFragment.newInstance()//我的

            loadMultipleRootFragment(
                R.id.main_frame, one, mFragments[one]
                , mFragments[two], mFragments[three]
            )
        } else {
            mFragments[one] = inventoryFragment
            mFragments[two] = findChildFragment(RecordFragment::class.java)
            mFragments[three] = findChildFragment(ProfileFragment::class.java)
        }
        main_bnve.run {
            enableAnimation(false)
            enableShiftingMode(false)
            enableItemShiftingMode(false)
            itemIconTintList = SettingUtil.getColorStateList(_mActivity)
            itemTextColor = SettingUtil.getColorStateList(_mActivity)
            setIconSize(20F, 20F)
            setTextSize(12F)
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_invertory -> showHideFragment(mFragments[one])
                    R.id.menu_record -> showHideFragment(mFragments[two])
                    R.id.menu_profile -> showHideFragment(mFragments[three])
                }
                true
            }
        }
    }

    override fun initToolBar() {
    }
}
