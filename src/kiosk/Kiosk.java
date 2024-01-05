package kiosk;


import domain.MenuType;
import domain.Order;
import domain.Product;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    Scanner sc = new Scanner(System.in);
    private final Order order = new Order();
    private final PrintList print = new PrintList(order);

    public void start() {
        showMenu();
    }

    public void showMenu() {
        print.printMain();
        showDetail(sc.nextLine());

    }

    public void showDetail(String str) {
        List<Product> list = null;
        switch (str) {
            case "1" -> list = print.printDetail(MenuType.BURGERS);
            case "2" -> list = print.printDetail(MenuType.FROZEN_CUSTARD);
            case "3" -> list = print.printDetail(MenuType.DRINKS);
            case "4" -> list = print.printDetail(MenuType.BEER);
            case "5" -> {
                cart();
                return;
            }
            case "6" -> {
                cancel();
                return;
            }
            default -> showMenu();
        }

        int num = Integer.parseInt(sc.nextLine());
        if (num > list.size()) {
            showDetail(str);
        }
        order(list.get(num-1));
    }

    private void cart() {
        print.printCart();
        String str = sc.nextLine();
        if (str.equals("1")) {
            ordering();
        } else if(str.equals("2")){
            showMenu();
        } else {
            cart();
        }
    }

    private void ordering() {
        print.printOrder();
        showMenu();
    }

    private void order(Product product) {
        print.printAddCart(product);

        String str = sc.nextLine();
        if (str.equals("1")) {
            order.addCart(product);
            System.out.println(product.getName() + " 가 장바구니 추가 되었습니다.");
            showMenu();
        } else if (str.equals("2")) {
            showMenu();
        } else {
            order(product);
        }
    }

    private void cancel() {
        print.printCancel();

        String str = sc.nextLine();
        if (str.equals("1")) {
            order.clear();
            System.out.println("주문취소");
            showMenu();
        } else if (str.equals("2")){
            showMenu();
        } else {
            cancel();
        }
    }

}
