package dev7.id.newdolang

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var fragments = mutableListOf<Fragment>().apply {
        add(ExampleFragment("Example 1"))
        add(ExampleFragment("Example 2"))
        add(ExampleFragment("Example 3"))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //if this inside fragment, use childFragmentManager
        view_pager.adapter = FragmentSlideAdapter(fragments, supportFragmentManager)
        equal_navigation_bar.setNavigationChangeListener { view , position ->
            equal_navigation_bar.setCurrentActiveItem(position)
            view_pager.setCurrentItem(position, true)
        }
        view_pager.addOnPageChangeListener(object  : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                equal_navigation_bar.setCurrentActiveItem(position)
            }
        })
        equal_navigation_bar.setCurrentActiveItem(0)
    }

    private fun toast(mess : String?) = Toast.makeText(this, mess, Toast.LENGTH_LONG).show()

    override fun onResume() {
        super.onResume()
        requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}
