package com.example.oasis.ui.more

import androidx.fragment.app.Fragment

class MoreFragment : Fragment() {
    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { MoreFragment() }
    }
}