package kyawthiha.viewpaper.indicator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kyawthiha.viewpaper.indicator.fragment.F_One
import kyawthiha.viewpaper.indicator.fragment.F_two


class MainActivity : AppCompatActivity() {
    private lateinit var pagerview_adapter:Pager_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        pagerview_adapter= Pager_Adapter(supportFragmentManager)
        add_MyFragment()
        my_viewpaper.adapter=pagerview_adapter
        my_viewpaper.addOnPageChangeListener(MyListener(this::onPageSelected))

    }

    private fun onPageSelected(position: Int) {
        when(position){
            0 -> {
                first_indicator.setImageResource(R.drawable.selceted_circle)
                second_indicator.setImageResource(R.drawable.disable_circle)
            }
            1 -> {
                second_indicator.setImageResource(R.drawable.selceted_circle)
                first_indicator.setImageResource(R.drawable.disable_circle)
            }
        }
    }

    private fun add_MyFragment(){
        pagerview_adapter.addFragment(F_One() )
        pagerview_adapter.addFragment(F_two())
    }
}

class MyListener(private val closure: (Int) -> Unit) : ViewPager.OnPageChangeListener {
    override fun onPageScrollStateChanged(p0: Int) {
    }
    override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
    }
    override fun onPageSelected(position: Int) = closure(position)
}
