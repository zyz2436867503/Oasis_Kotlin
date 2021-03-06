package com.example.oasis.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider

/**
 * baseactivity基类
 */
abstract class BaseActivity<VM : BaseViewModel, DB : ViewDataBinding>(
    var layoutId: Int,
    val vmClass: Class<VM>
) : AppCompatActivity() {

    protected lateinit var mViewModel: VM
    protected lateinit var mDataBinding: DB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mDataBinding = DataBindingUtil.setContentView(this, layoutId)
        mViewModel = ViewModelProvider(this).get(vmClass)
        initView() //适配器
        initVM() //viewmodel获取数据
        initData()//赋值
        initVariable()
    }

    protected abstract fun initView()
    protected abstract fun initVM();
    protected abstract fun initData()
    protected abstract fun initVariable()


}