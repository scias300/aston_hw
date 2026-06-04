public class Product {
    private String name;
    private String productionDate;
    private String manufacturer;
    private String country;
    private int price;
    private boolean isBooked;

    public Product(String name, String productionDate, String manufacturer, String country, int price, boolean isBooked) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isBooked = isBooked;
    }

    public void showInfo(){
        System.out.println("Наименование: " + this.name);
        System.out.println("Дата производства: " + this.productionDate);
        System.out.println("Производитель: " + this.manufacturer);
        System.out.println("Страна: " + this.country);
        System.out.println("Цена: " + this.price);
        if (this.isBooked){
            System.out.println("Товар забронирован: Да");
        }else {
            System.out.println("Товар забронирован: Нет");
        }
    }
}
