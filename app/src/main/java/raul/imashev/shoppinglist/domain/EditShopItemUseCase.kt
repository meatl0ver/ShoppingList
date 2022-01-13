package raul.imashev.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editShopListItem(shopItem: ShopItem) {
        shopListRepository.editShopListItem(shopItem)
    }
}