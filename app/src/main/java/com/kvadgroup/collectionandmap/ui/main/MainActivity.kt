package com.kvadgroup.collectionandmap.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.kvadgroup.collectionandmap.R
import com.kvadgroup.collectionandmap.ui.collection.CollectionFragment
import com.kvadgroup.collectionandmap.ui.main.adapter.MainPageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView, View.OnClickListener {

    private val presenter = MainPresenterImpl
    private var pagerAdapter: MainPageAdapter? = MainPageAdapter(supportFragmentManager)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pagerAdapter?.addFragment(CollectionFragment(), COLLECTION)
        viewPager.adapter = pagerAdapter

        calcBtn.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.calcBtn -> {
                if (!inputListSize.text.isNullOrEmpty()) {
                    presenter.calculate(inputListSize.text.toString().toInt())
                } else {
                    showMessage("Please input size of collection")
                }
            }
        }
    }

    override fun getCurrentPage(): Fragment {
        return pagerAdapter?.getItem(viewPager.currentItem)!!
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun onPause() {
        super.onPause()
        presenter.detachView()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val COLLECTION = "Collection"
        const val MAP = "Map"
    }
}
