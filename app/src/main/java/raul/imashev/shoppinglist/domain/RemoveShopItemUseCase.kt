package raul.imashev.shoppinglist.domain

class RemoveShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun removeShopListItem(shopItem: ShopItem) {
        shopListRepository.removeShopListItem(shopItem)
    }
}