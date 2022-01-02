package raul.imashev.shoppinglist.domain

interface ShopListRepository {
    fun addShopListItem(shopItem: ShopItem)
    fun editShopListItem(shopItem: ShopItem)
    fun getShopListItemById(id: Int): ShopItem
    fun getShopListItems(): List<ShopItem>
    fun removeShopListItem(shopItem: ShopItem)
}