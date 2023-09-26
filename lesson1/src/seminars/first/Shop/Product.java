package seminars.first.Shop;

public class Product {
    private Integer cost; // Стоимость продукта
    private String title; // Название

    // Геттеры, сеттеры:
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this.getClass() == obj.getClass()){
            return  this.title == ((Product) obj).title && this.cost == ((Product) obj).cost;
        }
        return false;
    }

    public boolean equals(Product p) {
        if (p == null) {
            return false;
        }

        return this.title == p.title && this.cost == p.cost;

    }

    public int compareCost(Product p) {
        if (p == null) {
            throw new NullPointerException("Argument is null");
        }

        if (this.cost < p.cost) {
            return -1;
        }

        if (this.cost > p.cost) {
            return 1;
        }
        return 0;
    }

}