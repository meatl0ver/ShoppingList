package raul.imashev.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import raul.imashev.shoppinglist.data.ShopListRepositoryImpl
import raul.imashev.shoppinglist.domain.EditShopItemUseCase
import raul.imashev.shoppinglist.domain.GetShopListUseCase
import raul.imashev.shoppinglist.domain.RemoveShopItemUseCase
import raul.imashev.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val shopListRepository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(shopListRepository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(shopListRepository)
    private val editShopItemUseCase = EditShopItemUseCase(shopListRepository)

    val shopList = getShopListUseCase.getShopListItems()

    fun removeShopItem(item: ShopItem) {
        removeShopItemUseCase.removeShopListItem(item)
    }

    fun changeEnabledState(item: ShopItem) {
        val editedItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopListItem(editedItem)
    }
}