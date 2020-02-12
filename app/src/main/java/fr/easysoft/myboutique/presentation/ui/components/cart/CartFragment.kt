package fr.easysoft.myboutique.presentation.ui.components.cart

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView

import fr.easysoft.myboutique.R
import kotlinx.android.synthetic.main.common_unregistred_bottom_nav.*

class CartFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var navController: NavController;

    companion object {
        @JvmStatic
        fun newInstance() = CartFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        common_unregistred_bottom_navigation.selectedItemId = R.id.item_action_panier;
        navController = Navigation.findNavController(view);

        var response = common_unregistred_bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_action_accueil -> navController.navigate(R.id.action_cartFragment_to_homeUnregistredFragment)
            R.id.item_action_produits -> navController.navigate(R.id.action_cartFragment_to_productsFragment)
        }

        return false;
    }
}
