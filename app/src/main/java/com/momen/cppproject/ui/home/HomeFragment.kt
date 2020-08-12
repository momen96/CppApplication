package com.momen.cppproject.ui.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.momen.cppproject.R
import com.momen.cppproject.recycler_view.adapter_home
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(){

    //Navigation drawer configurations
    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("FragmentLiveDataObserve")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root



    }
    // End here

    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)

        val cppData = arrayOf("1-المقدمة" , "2-الهيكلية العامة للبرنامج" , "3-المتغيرات" , "4-دالة الاخراج" , "5-دالة الادخال" , "6-العمليات الرياضية"
            ,  "7-العمليات المنطقية",  "8-الدوال الرياضية" , "9-العبارة الشرطية (if)", "10-العبارة الشرطية (switch)" , "11-الدوال التكرارية (for)" ,  "12-الدوال التكرارية (while)"
        , "13-الدوال التكرارية (do-while)" ,  "14-المصفوفات" ,  "15-المصفوفات ثنائية الابعاد" , "16-الدوال (functions)" , "17-التراكيب", "18-البرمجة الكائنية" , "19-الفئات" ,"20-الوراثة" , "21-محددات الوصول" , "22-التغليف" , "23-تعدد الأوجه")

        RecyclerView.layoutManager = LinearLayoutManager(this.context ,LinearLayout.VERTICAL, false)
        RecyclerView.adapter = adapter_home(cppData)


    }

}