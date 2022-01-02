package raul.imashev.shoppinglist.domain

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopListItems(): List<ShopItem> {
        return shopListRepository.getShopListItems()
    }
}