package fr.easysoft.myboutique.presentation.ui.components.product.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.squareup.picasso.Picasso

import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.model.Product
import kotlinx.android.synthetic.main.item_product.*
import timber.log.Timber

class ProductDetailFragment : Fragment() {

    private lateinit var navController: NavController;
    private lateinit var productId: String;

    companion object {
        @JvmStatic
        fun newInstance() = ProductDetailFragment()

        const val EXTRA_PRODUCT_ID = "fr.easysoft.myboutique.presentation.ui.components.product.detail.productId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        productId = "1"
        Timber.i(">>>>>>>>>>>>>>>>> productId: ${productId}")
        navController = Navigation.findNavController(view);

        Timber.i(">>>>>>>>>>> BEFORE Picasso")
        Picasso.get()
            .load("https://www.biougnach.ma/4964-large_default/smart-tv-fhd-49-samsung.jpg")
            .placeholder(R.drawable.ic_placeholder_image)
            .into(product_cover)

        Timber.i("<<<<<<<<<<<<<<<<<<<<<<<<<<<<< AFTER Picasso")

    }
}
