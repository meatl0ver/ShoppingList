package raul.imashev.shoppinglist.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopListItemById(id: Int) : ShopItem {
        return shopListRepository.getShopListItemById(id)
    }
}