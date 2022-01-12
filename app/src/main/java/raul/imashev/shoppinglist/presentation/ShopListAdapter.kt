package raul.imashev.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import raul.imashev.shoppinglist.R
import raul.imashev.shoppinglist.domain.ShopItem

class ShopListAdapter :
    ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            IS_ENABLED_CONST -> R.layout.item_shop_enabled
            IS_DISABLED_CONST -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown viewType: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.itemView.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }
        holder.itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }

        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
    }

    //прорисовка разных view, в зависимости от условия
    override fun getItemViewType(position: Int): Int {
        val shopItem = getItem(position)
        return if (shopItem.enabled) {
            IS_ENABLED_CONST
        } else {
            IS_DISABLED_CONST
        }
    }

    //можно не переопределять getItemCount() т.к. в ListAdapter скрыта работа со списком

    companion object {
        private const val IS_ENABLED_CONST = 0
        private const val IS_DISABLED_CONST = 1
    }
}