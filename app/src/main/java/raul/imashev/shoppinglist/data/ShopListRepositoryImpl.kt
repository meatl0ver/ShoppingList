package raul.imashev.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import raul.imashev.shoppinglist.domain.ShopItem
import raul.imashev.shoppinglist.domain.ShopListRepository
import java.lang.RuntimeException

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    init {
        for (i in 0 until 10) {
            val a = ShopItem("name $i",1,true)
            addShopListItem(a)
        }
    }

    override fun addShopListItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
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

    override fun getShopListItems(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun removeShopListItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}