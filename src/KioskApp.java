import domain.Order;
import domain.Product;
import kiosk.PrintList;

import java.util.List;
import java.util.Scanner;

import static domain.MenuType.*;

public class KioskApp {

    static Scanner sc = new Scanner(System.in);
    private static final Order order = new Order();
    private static final PrintList print = new PrintList(order);

    public static void main(String[] args) {
        showMenuList();
    }

    // 키오스크 메인화면
    public static void showMenuList() {
        print.printMainMenuList(MAIN);
        detailMenuList(sc.nextLine());
    }

    // 메뉴 상세화면
    public static void detailMenuList(String str) {
        List<Product> list = null;
        switch (str) {
            case "1" -> list = print.printDetailMenuList(BURGERS);
            case "2" -> list = print.printDetailMenuList(FROZEN_CUSTARD);
            case "3" -> list = print.printDetailMenuList(DRINKS);
            case "4" -> list = print.printDetailMenuList(BEER);
            case "5" -> {
                showCartList();
                return;
            }
            case "6" -> {
                cancelOrder();
                return;
            }
            default -> showMenuList();
        }

        String input = sc.nextLine();
        int num = 0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            detailMenuList(str);
        }

        if (num > list.size()) {
            detailMenuList(str);
        }
        order(list.get(num-1));
    }

    // 장바구니 화면
    private static void showCartList() {
        print.printCartList();
        String str = sc.nextLine();
        if (str.equals("1")) {
            purchasing();
        } else if(str.equals("2")){
            showMenuList();
        } else {
            showCartList();
        }
    }

    // 장바구니 담긴 상품 구매
    private static void purchasing() {
        print.printOrder();
        showMenuList();
    }

    // 장바구니 추가화면
    private static void order(Product product) {
        print.printAddCart(product);

        String str = sc.nextLine();
        if (str.equals("1")) {
            order.addCart(product);
            System.out.println(product.getName() + " 가 장바구니 추가 되었습니다.");
            showMenuList();
        } else if (str.equals("2")) {
            showMenuList();
        } else {
            order(product);
        }
    }

    // 장바구니 비우기
    private static void cancelOrder() {
        print.printCancel();

        String str = sc.nextLine();
        if (str.equals("1")) {
            order.clear();
            System.out.println(" 진행하던 주문이 취소되었습니다. ");
            showMenuList();
        } else if (str.equals("2")){
            showMenuList();
        } else {
            cancelOrder();
        }
    }
}
