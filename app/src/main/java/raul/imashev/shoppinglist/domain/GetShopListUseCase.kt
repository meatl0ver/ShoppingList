package raul.imashev.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopListItems(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopListItems()
    }
}