package fr.easysoft.myboutique.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import fr.easysoft.myboutique.R
import kotlinx.android.synthetic.main.common_unregistred_bottom_nav.*
import kotlinx.android.synthetic.main.common_unregistred_toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        common_unregistred_bottom_navigation.visibility = View.GONE;
//        common_unregistred_toolbar.visibility = View.GONE;
    }

}
