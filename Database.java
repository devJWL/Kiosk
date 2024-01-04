import util.ProductType;

import java.util.HashMap;
import java.util.Map;

public class Database {
    private Map<Integer, Product> database;
    // 메뉴 이름으로 데이터를 찾기위한 해쉬
    private Map<String, Integer> key;
    private static int no = 1;

    Database() {
        database = new HashMap<>();
        key = new HashMap<>();
        init();
    }

    public Map<Integer, Product> getDatabase() {
        return database;
    }

    public void setDatabase(Map<Integer, Product> database) {
        this.database = database;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        no = no;
    }
    public void add(Product product) {
        database.put(no, product);
        key.put(product.getName(), no);
        ++no;
    }

    public void delete(Product product) {
        database.remove(product.getNo());
    }

    public Product find(Product product){
        return find(product.getNo());
    }
    public Product find(int no) {
        return database.get(no);
    }
    public Product find(String name) {
        return find(key.get(name));
    }
    public void init () {
        // int no, String name, String detail, double sPrice, double dPrice, TypeEnum type
        this.add(new Product(no,"ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9, 10.9, ProductType.BURGER));
        this.add(new Product(no, "SmokeShack", "애플우드 칩으로 훈연한 베이컨, 쉑소스가 토핑된 치즈 버거", 8.9, 12.9, ProductType.BURGER));


        this.add(new Product(no, "Shakes", "바닐라, 초콜렛, 솔티드 카라멜", 5.9, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Shake of the Week", "특별한 커스터드 플레이버", 6.5, 0, ProductType.FROZEN_CUSTARD));
        this.add(new Product(no, "Cups & Cones", "바닐라, 초콜렛, Flavor of the Week", 4.9, 5.9, ProductType.FROZEN_CUSTARD));


        this.add(new Product(no,"Shack-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 3.9, 4.5, ProductType.DRINK));


        this.add(new Product(no,"ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일맥주",
                        9.8, 0, ProductType.BEER));
    }
}