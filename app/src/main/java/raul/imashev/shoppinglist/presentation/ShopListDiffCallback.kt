package raul.imashev.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import raul.imashev.shoppinglist.domain.ShopItem

class ShopListDiffCallback(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
) : DiffUtil.Callback() {

    //возвращает размер старого списка
    override fun getOldListSize(): Int {
        return oldList.size
    }

    //возвращает размер нового списка
    override fun getNewListSize(): Int {
        return newList.size
    }

    //сравнение элементов по id
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    //сравнение контента элементов
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]

    }
}