package com.mwwl.mvp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.OnClick

import com.jess.arms.di.component.AppComponent

import com.mwwl.di.component.DaggerInventoryComponent
import com.mwwl.di.module.InventoryModule
import com.mwwl.mvp.contract.InventoryContract
import com.mwwl.mvp.presenter.InventoryPresenter

import com.mwwl.R
import com.mwwl.base.BaseFragment
import com.mwwl.utils.LogUtil
import kotlinx.android.synthetic.main.fragment_inventory.*


/**
 * 盘点
 */
class InventoryFragment : BaseFragment<InventoryPresenter>(), InventoryContract.View {

    companion object {
        fun newInstance(): InventoryFragment {
            val fragment = InventoryFragment()
            return fragment
        }
    }


    override fun setupFragmentComponent(appComponent: AppComponent) {
        DaggerInventoryComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .inventoryModule(InventoryModule(this))
            .build()
            .inject(this)
    }

    override fun initToolBar() {}

    override fun initView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_inventory, container, false);
    }

    override fun initData(savedInstanceState: Bundle?) {
//        val sb = StringBuilder()
//        sb.append("<html>")
//        sb.append("<head>")
//        sb.append("<style>.main-table tr td { padding: 4px 0 } .main-table tr:first-child td { border: 1px solid #EEE; border-right: none; } .main-table tr:first-child td:last-child { border: 1px solid #EEE; } .main-table tr td { border-left: 1px solid #EEE; border-bottom: 1px solid #EEE; } .main-table tr td:last-child { border: 1px solid #EEE; border-top: none; } .title { font-size: 24px; font-weight: bold; } </style>")
//        sb.append("</head")
//        sb.append("<body>")
//
//        spoTableHeaderItemList?.let {
//            // 标题
//            for (index in it.indices) {
//                val ruleDetailBean = it.get(index)
//                val isTitle = ruleDetailBean.istitle
//                if (isTitle == 1) {
//                    val itemContent = ruleDetailBean.itemcontent
//                    sb.append("<div class=\"title\" align=\"center\" width=\"100%\">$itemContent</div>")
//                } else {
//                    val detailName = ruleDetailBean.detailname
//                    val itemContent = ruleDetailBean.itemcontent
//                    sb.append("<div>$detailName:$itemContent</div>")
//                }
//            }
//        }
//
//        list?.let {
//            sb.append("<table class=\"main-table\" cellspacing=\"0\" width=\"100%\">")
//            for (index in it.indices) {
//                val item = it.get(index)
//                item?.let {
//                    sb.append("<tr>")
//                    for (childIndex in it.indices) {
//                        val childItem = it.get(childIndex)
//                        sb.append("<td colspan=\"1\" align=\"center\">${childItem}</td>")
//                    }
//                    sb.append("</tr>")
//                }
//            }
//            sb.append("</table>")
//        }
//        sb.append("</body>")
//        sb.append("</html>")
//        webView.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null)

    }


    @OnClick(R.id.inventoryTv, R.id.clearTv, R.id.upLoadTv)
    fun onViewClicked(view: View) {
        when (view.id) {
            //盘点
            R.id.inventoryTv -> {
                if (inventoryTv.text.toString() != "开始盘点") {
                    changeInventory(true)
                    /**
                     * 执行结束盘点的操作
                     */
                    return
                }
                changeInventory(false)
                /**
                 * 执行开始盘点的操作
                 */
            }
            //清除
            R.id.clearTv -> {
            }

            //上传
            R.id.upLoadTv -> {

            }
        }
    }


    fun changeInventory(flag: Boolean) {
        if (flag) {
            inventoryTv.setText("开始盘点")
            inventoryTv.background = _mActivity.resources.getDrawable(R.drawable.bg_inventory_start)
        } else {
            inventoryTv.setText("结束盘点")
            inventoryTv.background = _mActivity.resources.getDrawable(R.drawable.bg_inventory_stop)
        }
    }


}
