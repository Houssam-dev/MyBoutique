package fr.easysoft.myboutique.presentation.ui.components.product.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import fr.easysoft.myboutique.R
import fr.easysoft.myboutique.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsAdapter(private val products: List<Product>,
                      private val listener: ProductsAdapterListener)
    : RecyclerView.Adapter<ProductsAdapter.ViewHolder>(), View.OnClickListener {

    interface ProductsAdapterListener {
        fun onProductSelected(product: Product)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view_product);
        val productCover = itemView.findViewById<ImageView>(R.id.product_cover);
        val productTitle = itemView.findViewById<TextView>(R.id.product_title);
        val productDesignation = itemView.findViewById<TextView>(R.id.product_designation);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false);
        return ViewHolder(item);
    }

    override fun getItemCount() = products.size;


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position];

        with(holder) {
            cardView.setOnClickListener(this@ProductsAdapter);
            cardView.tag = product;
            productTitle.text = product.name;
            productDesignation.text = product.designation;

//            Picasso.get()
//                .load(product.pictureUrl)
//                .placeholder(R.drawable.ic_placeholder_image)
//                .into(productCover)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.card_view_product -> listener.onProductSelected(v.tag as Product);
        }
    }


}