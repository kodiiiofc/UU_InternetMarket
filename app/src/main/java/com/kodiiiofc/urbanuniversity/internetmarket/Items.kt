package com.kodiiiofc.urbanuniversity.internetmarket

object Items {
    val list = mutableListOf(
        Item("Эко-бутылка для воды из нержавеющей стали (500 мл)", 20, R.drawable.bytylka),
        Item("Силиконовый коврик для выпечки", 15, R.drawable.kovrik),
        Item("Компактный беспроводной зарядный адаптер для телефона", 30, R.drawable.zaryadka),
        Item("Мини-проектор для домашнего кинотеатра", 120, R.drawable.proektor),
        Item("Детский обучающий планшет с сенсорным экраном", 50, R.drawable.planshet),
        Item("Многоразовые хлопковые маски для лица", 12, R.drawable.maski),
        Item("Органайзер для кабелей и проводов", 10, R.drawable.organayzer),
        Item("Умная лампочка с поддержкой управления через приложение", 25, R.drawable.lampochka),
        Item("Дорожный чехол для наушников", 8, R.drawable.chehol),
        Item("Складной походный стул", 40, R.drawable.stul)
    )

    val cart = mutableListOf<Item>()

    fun getCartWithCount() : Map<Item, Int> {
        return cart.groupingBy { it }.eachCount()
    }
}