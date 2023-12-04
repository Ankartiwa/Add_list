package com.programmer.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import malkinfo.editingrecyclerview.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*Isi content*/
        val fragment = HomeFragment.newInstance("test1","test2")
        bottom_navigation_view.setOnNavigationItemSelectedListener(menuItemSelected)
        addFragment(fragment)
    }

    /*Deteksi Menu Item Yang Diklik*/
    private val menuItemSelected = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.itemHome ->{
                val fragment = HomeFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemDatabase ->{
                val fragment = DatabaseFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemStatistic ->{
                val fragment = StatisticFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.itemSetting ->{
                val fragment = SettingFragment.newInstance("test1","test2")
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    /*Memanggil Fragment ke frame_layout di activity_main*/
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
}