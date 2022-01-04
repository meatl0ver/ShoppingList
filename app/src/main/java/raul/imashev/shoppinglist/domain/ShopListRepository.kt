package raul.imashev.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopListItem(shopItem: ShopItem)
    fun editShopListItem(shopItem: ShopItem)
    fun getShopListItemById(id: Int): ShopItem
    fun getShopListItems(): LiveData<List<ShopItem>>
    fun removeShopListItem(shopItem: ShopItem)
}