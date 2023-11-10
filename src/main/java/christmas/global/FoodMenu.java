public enum FoodMenu {
    양송이수프("Appetizer", "양송이수프", 6000),
    타파스("Appetizer", "타파스", 5500),
    시저샐러드("Appetizer", "시저샐러드", 8000),

    티본스테이크("Main", "티본스테이크", 55000),
    바비큐립("Main", "바비큐립", 54000),
    해산물파스타("Main", "해산물파스타", 35000),
    크리스마스파스타("Main", "크리스마스파스타", 25000),

    초코케이크("Dessert", "초코케이크", 15000),
    아이스크림("Dessert", "아이스크림", 5000),

    제로콜라("Beverage", "제로콜라", 3000),
    레드와인("Beverage", "레드와인", 60000),
    샴페인("Beverage", "샴페인", 25000);

    private final String category;
    private final String name;
    private final int price;

    FoodMenu(String category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
