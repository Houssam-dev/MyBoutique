package fr.easysoft.myboutique.presentation.ui.components.product.list


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.model.Product
import kotlinx.android.synthetic.main.common_unregistred_bottom_nav.*
import kotlinx.android.synthetic.main.fragment_products.*
import timber.log.Timber


class ProductsFragment : Fragment(), BottomNavigationView.OnNavigationItemSelectedListener,
    ProductsAdapter.ProductsAdapterListener {

    private lateinit var navController: NavController;
    private lateinit var productsViewModel: ProductsViewModel;
    private lateinit var productsAdapter: ProductsAdapter;
    private lateinit var products: MutableList<Product>;

    companion object {
        @JvmStatic
        fun newInstance(): ProductsFragment = ProductsFragment()
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

        products = mutableListOf();
        productsViewModel = ViewModelProvider(this).get(ProductsViewModel::class.java);
        productsViewModel.getAllProducts().observe(viewLifecycleOwner, Observer { newProducts -> updateProducts(newProducts) })

        productsAdapter = ProductsAdapter(products, this);

        recycler_view_products.apply {
            layoutManager = LinearLayoutManager(this@ProductsFragment.activity);
            adapter = productsAdapter;
        }

        var response = common_unregistred_bottom_navigation.setOnNavigationItemSelectedListener(this)
    }

    private fun updateProducts(newProducts: List<Product>?) {
        Timber.i("[ updateProducts ] list of new products: ${newProducts}");
        products.clear();
        products.addAll(newProducts!!);
        productsAdapter.notifyDataSetChanged();
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.item_action_panier -> navController.navigate(R.id.action_productsFragment_to_cartFragment);
            R.id.item_action_accueil -> navController.navigate(R.id.action_productsFragment_to_homeUnregistredFragment)
        }
        return false;
    }

    override fun onProductSelected(product: Product) {
        Timber.i("[ onProductSelected ] => ${product}")
    }
}
