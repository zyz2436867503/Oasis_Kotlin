package com.example.oasis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.oasis.base.BaseActivity
import com.example.oasis.databinding.ActivityMainBinding
import com.example.oasis.ui.discover.DiscoverFragment
import com.example.oasis.ui.home.HomeFragment
import com.example.oasis.ui.message.MessageFragment
import com.example.oasis.ui.mine.MineFragment
import com.example.oasis.ui.more.MoreFragment
import com.example.oasis.viewmodel.MainViewMode

class MainActivity : BaseActivity<MainViewMode, ActivityMainBinding>(
    R.layout.activity_main,
    MainViewMode::class.java
), View.OnClickListener {

    lateinit var homeFragment: Fragment
    lateinit var discoverFragment: Fragment
    lateinit var morefragment: Fragment
    lateinit var messagefragment: Fragment
    lateinit var minefragment: Fragment

    override fun initView() {

        mDataBinding.layoutHome.setOnClickListener(this)
        mDataBinding.layoutDiscover.setOnClickListener(this)
        mDataBinding.layoutMore.setOnClickListener(this)
        mDataBinding.layoutMessage.setOnClickListener(this)
        mDataBinding.layoutMine.setOnClickListener(this)

        homeFragment = HomeFragment.instance
        discoverFragment = DiscoverFragment.instance
        morefragment = MoreFragment.instance
        messagefragment = MessageFragment.instance
        minefragment = MineFragment.instance

        //初始化第一个fragment
        val beginTransaction = supportFragmentManager.beginTransaction()
        mDataBinding.ivHome.setImageResource(R.mipmap.main_nav_home_hl)
        //显示第一个homefragment
        beginTransaction.replace(R.id.layout_framelayout, homeFragment)
        //提交
        beginTransaction.commit()
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }

    override fun onClick(v: View?) {
        resetImg()
        val beginTransaction = supportFragmentManager.beginTransaction()
        when (v!!.id) {
            R.id.layout_home -> {
                mDataBinding.ivHome.setImageResource(R.mipmap.main_nav_home_hl)
                //显示homefragment这个fragment
                beginTransaction.replace(R.id.layout_framelayout, homeFragment)


            }
            R.id.layout_discover -> {
                mDataBinding.ivDiscover.setImageResource(R.mipmap.main_nav_discover_hl)
                //显示homefragment这个fragment
                beginTransaction.replace(R.id.layout_framelayout, discoverFragment)

            }
            R.id.layout_more -> {

            }
            R.id.layout_message -> {
                mDataBinding.ivMessage.setImageResource(R.mipmap.main_nav_message_hl)
                //显示homefragment这个fragment
                beginTransaction.replace(R.id.layout_framelayout, messagefragment)

            }
            R.id.layout_mine -> {
                mDataBinding.ivMine.setImageResource(R.mipmap.main_nav_mine_hl)
                //显示homefragment这个fragment
                beginTransaction.replace(R.id.layout_framelayout, minefragment)

            }
        }
        beginTransaction.commit()
    }

    private fun resetImg() {
        mDataBinding.ivHome.setImageResource(R.mipmap.main_nav_home_normal)
        mDataBinding.ivDiscover.setImageResource(R.mipmap.main_nav_discover_normal)
        mDataBinding.ivMessage.setImageResource(R.mipmap.main_nav_message_normal)
        mDataBinding.ivMine.setImageResource(R.mipmap.main_nav_mine_normal)
    }

}