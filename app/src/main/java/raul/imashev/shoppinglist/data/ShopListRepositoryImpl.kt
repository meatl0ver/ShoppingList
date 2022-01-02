package raul.imashev.shoppinglist.data

import raul.imashev.shoppinglist.domain.ShopItem
import raul.imashev.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopListItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun editShopListItem(shopItem: ShopItem) {
        val editedElement = getShopListItemById(shopItem.id)
        shopList.remove(editedElement)
        addShopListItem(shopItem)
    }

    override fun getShopListItemById(id: Int): ShopItem {
        return shopList.find { it.id == id }
            ?: throw RuntimeException("The element with id=$id did not find")
    }

    override fun getShopListItems(): List<ShopItem> {
        return shopList.toList()
    }

    override fun removeShopListItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }
}