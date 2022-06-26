package com.atorresveiga.playingwithtransitions.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.atorresveiga.playingwithtransitions.Product
import com.atorresveiga.playingwithtransitions.R
import com.atorresveiga.playingwithtransitions.Repository
import com.atorresveiga.playingwithtransitions.ui.TRANSITION_DURATION
import com.google.android.material.transition.MaterialElevationScale

class ProductListFragment : Fragment(), ProductAdapter.ProductAdapterListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
        super.onViewCreated(view, savedInstanceState)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
        val recyclerView = view.findViewById<RecyclerView>(R.id.productList)
        (requireActivity() as? AppCompatActivity)?.setSupportActionBar(toolbar)

        exitTransition = MaterialElevationScale(false).apply {
            duration = TRANSITION_DURATION.toLong()
        }
        reenterTransition = MaterialElevationScale(true).apply {
            duration = TRANSITION_DURATION.toLong()
        }

        recyclerView.adapter = ProductAdapter(Repository.products, this)
    }

    override fun onProductClicked(view: View, product: Product) {
        val productDetailTransitionName = getString(R.string.product_detail_transition_name)
        val extras = FragmentNavigatorExtras(view to productDetailTransitionName)
        val directions = ProductListFragmentDirections.actionProductsToDetail(product.id)
        findNavController().navigate(directions, extras)
    }
}

class ProductAdapter(
    private val products: List<Product>,
    private val listener: ProductAdapterListener
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item_product, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product)
        holder.itemView.setOnClickListener {
            listener.onProductClicked(it, product)
        }
    }

    override fun getItemCount(): Int = products.size

    interface ProductAdapterListener {
        fun onProductClicked(view: View, product: Product)
    }

    class ProductViewHolder(itemView: View) : ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.productImage)
        private val title = itemView.findViewById<TextView>(R.id.title)
        private val description = itemView.findViewById<TextView>(R.id.description)
        fun bind(product: Product) {
            val context = itemView.context
            val stock = if (product.inStock) {
                context.getString(R.string.in_stock)
            } else {
                context.getString(R.string.out_stock)
            }

            ViewCompat.setTransitionName(
                itemView,
                context.getString(R.string.product_list_item_transition_name, product.id)
            )
            title.text = product.name
            description.text = context.getString(R.string.product_description, product.price, stock)
            image.load(product.image) {
                crossfade(true)
                placeholder(R.drawable.ic_product)
            }
        }
    }
}