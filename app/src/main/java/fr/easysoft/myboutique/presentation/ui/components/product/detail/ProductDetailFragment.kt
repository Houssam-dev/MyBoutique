package fr.easysoft.myboutique.presentation.ui.components.product.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation

import fr.easysoft.myboutique.R
import timber.log.Timber

class ProductDetailFragment : Fragment() {

    private lateinit var navController: NavController;
    private var productId: Long? = null;

    companion object {
        @JvmStatic
        fun newInstance() = ProductDetailFragment()

        const val EXTRA_PRODUCT_ID = "fr.easysoft.myboutique.presentation.ui.components.product.detail.productId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        productId = arguments!!.getString("productId")?.toLong();
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

        Timber.i(">>>>>>>>>>>>>>>>> productId: ${productId}")
        navController = Navigation.findNavController(view);

    }
}
