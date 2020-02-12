package fr.easysoft.myboutique.presentation.ui.components.product.list


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


class ProductsFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var navController: NavController;

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ProductsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view);
        common_unregistred_bottom_navigation.selectedItemId = R.id.item_action_produits
        var response = common_unregistred_bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_action_panier -> navController.navigate(R.id.action_productsFragment_to_cartFragment);
            R.id.item_action_accueil -> navController.navigate(R.id.action_productsFragment_to_homeUnregistredFragment)
        }
        return false;
    }
}
