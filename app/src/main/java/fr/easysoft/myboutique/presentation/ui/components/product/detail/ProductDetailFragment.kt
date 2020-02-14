package fr.easysoft.myboutique.presentation.ui.components.product.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.squareup.picasso.Picasso

import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.model.Product
import kotlinx.android.synthetic.main.common_unregistred_bottom_nav.*
import kotlinx.android.synthetic.main.item_product.*
import timber.log.Timber

private const val ARG_PRODUCT_ID = "productId"

class ProductDetailFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var navController: NavController;
    private var product_id: Long = -1L

    companion object {
        @JvmStatic
        fun newInstance(productId: String) =
            ProductDetailFragment().apply {
                arguments = Bundle().apply {
                    putLong(ARG_PRODUCT_ID, product_id)
                }
            }


        //const val EXTRA_PRODUCT_ID = "fr.easysoft.myboutique.presentation.ui.components.product.detail.productId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            product_id = it.getLong(ARG_PRODUCT_ID);
        }
//        productId = arguments!!.getString("productId").toString();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        common_unregistred_bottom_navigation.selectedItemId = R.id.item_action_produits;

        //productId = "1"
        Timber.i(">>>>>>>>>>>>>>>>> productId: ${product_id}")
        navController = Navigation.findNavController(view);

        Timber.i(">>>>>>>>>>> BEFORE Picasso")
        Picasso.get()
            .load("https://www.biougnach.ma/4964-large_default/smart-tv-fhd-49-samsung.jpg")
            .placeholder(R.drawable.ic_placeholder_image)
            .into(product_cover)

        Timber.i("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< AFTER Picasso")

        var response = common_unregistred_bottom_navigation.setOnNavigationItemSelectedListener(this);
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_action_accueil -> navController.navigate(R.id.action_productDetailFragment_to_homeUnregistredFragment);
            R.id.item_action_produits -> navController.navigate(R.id.action_productDetailFragment_to_productsFragment);
            R.id.item_action_panier -> navController.navigate(R.id.action_productDetailFragment_to_cartFragment);
        }

        return false;
    }
}
