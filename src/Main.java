public class Main {
    public static void main(String[] args) {
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17", "19.09.2025",
                "Apple", "USA", 950, false);
        productsArray[2] = new Product("Xiaomi 17T", "28.05.2026",
                "Xiaomi", "China", 749, false);
        productsArray[3] = new Product("Honor 600", "18.05.2026",
                "Shenzhen Zhixin New Information Technology Co., Ltd.", "China", 485, true);
        productsArray[4] = new Product("Realme 16T", "26.05.2026",
                "BBK Electronics", "China", 5599, true);

        for (Product product: productsArray){
            System.out.println();
            product.showInfo();
        }

        Park.Attraction attraction = new Park().new Attraction("Карусель", "09:00-22:00", 11.11);
        System.out.println();
        System.out.println("Аттракцион: " + attraction.name);
        System.out.println("Часы работы: " + attraction.workingHours);
        System.out.println("Цена: " + attraction.price);
    }
}
