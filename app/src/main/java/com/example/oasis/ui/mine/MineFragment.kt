package com.example.oasis.ui.mine

import androidx.fragment.app.Fragment

class MineFragment:Fragment() {
    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { MineFragment() }
    }
}