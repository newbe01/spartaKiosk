package kiosk;

import domain.MenuType;
import domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static domain.MenuType.*;

public class MakeList {
    public static List<Product> mainList = new ArrayList<>();
    public static List<Product> burgerList = new ArrayList<>();
    public static List<Product> frozenList = new ArrayList<>();
    public static List<Product> drinkList = new ArrayList<>();
    public static List<Product> beerList = new ArrayList<>();
    public static Map<MenuType, List<Product>> map = new HashMap<>();
    public static List<Product> totalProduct = new ArrayList<>();

    public List<Product> getTotalProduct() {
        return totalProduct;
    }

    public void init() {
        mainList = makeMenu();
        burgerList = makeBurgerMenu();
        frozenList = makeFrozenMenu();
        drinkList = makeDrinksMenu();
        beerList = makeBeerMenu();

        map.put(MAIN, mainList);
        map.put(BURGERS, burgerList);
        map.put(FROZEN_CUSTARD, frozenList);
        map.put(DRINKS, drinkList);
        map.put(BEER, beerList);
    }

    public List<Product> makeMenu() {
        List<Product> list = new ArrayList<>();
        Product p1 = new Product("Burgers", "앵거스 비프 통살을 다져만든 버거");
        Product p2 = new Product("Frozen Custard", "매장에서 신선하게 만드는 아이스크림");
        Product p3 = new Product("Drinks ", "매장에서 직접 만드는 음료");
        Product p4 = new Product("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");
        Product p5 = new Product("Order", "장바구니를 확인 후 주문합니다.");
        Product p6 = new Product("Cancel", "진행중인 주문을 취소합니다.");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        return list;
    }

    public List<Product> makeBurgerMenu() {
        List<Product> list = new ArrayList<>();
        Product p1 = new Product("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", 6.9);
        Product p2 = new Product("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", 8.9);
        Product p3 = new Product("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", 9.4);
        Product p4 = new Product("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", 6.9);
        Product p5 = new Product("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", 5.4);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        return list;
    }

    public List<Product> makeFrozenMenu() {
        List<Product> list = new ArrayList<>();
        Product p1 = new Product("Strawberry", "달콤한 스트로베리 플레이버에 바삭한 화이트 쿠키 크럼블이 더해진 시즌 한정 쉐이크", 7.5);
        Product p2 = new Product("Classic", "쫀득하고 진한 커스터드가 들어간 클래식 쉐이크", 6.5);
        Product p3 = new Product("Floats", "부드러운 바닐라 커스터드와 톡톡 터지는 탄산이 만나 탄생한 색다른 음료", 6.5);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }

    public List<Product> makeDrinksMenu() {
        List<Product> list = new ArrayList<>();
        Product p1 = new Product("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프, 환타 파인애플", 3.5);
        Product p2 = new Product("Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", 4.0);
        Product p3 = new Product("Fifty/Fifty", "레몬에이드와 유기농 홍차를 우려낸 아이스 티가 만나 탄생한 쉐이크쉑의 시그니처 음료", 4.4);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }

    public List<Product> makeBeerMenu() {
        List<Product> list = new ArrayList<>();
        Product p1 = new Product("CASS", "카스", 7.5);
        Product p2 = new Product("TERRA", "테라", 6.5);
        Product p3 = new Product("KLOUD", "클라우드", 6.5);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        return list;
    }

    public List<Product> getType(MenuType type) {
        return map.get(type);
    }

    public void addTotalProduct(List<Product> cart) {
        totalProduct.addAll(cart);
    }
}
