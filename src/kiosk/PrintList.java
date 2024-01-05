package kiosk;

import domain.MenuType;
import domain.Order;
import domain.Product;

import java.util.List;

public class PrintList {

    private static final MakeList makeList = new MakeList();
    private final Order order;

    public PrintList(Order order) {
        this.order = order;
        makeList.init();
    }


    public void printMainMenuList(MenuType type) {
        List<Product> mainList = makeList.getType(type);
        int cnt = 1;

        System.out.println("========================================================\n\n");
        System.out.println("[ SHAKESHACK MENU ]");

        for (Product main : mainList) {
            if (cnt == 5) {
                System.out.println("\n\n[ ORDER MENU ]");
            }
            System.out.print(cnt++ + ". ");

            main.printMenu();
        }

        System.out.println("\n\n========================================================");
    }

    public List<Product> printDetailMenuList(MenuType type) {
        List<Product> list = makeList.getType(type);
        int num = 1;

        System.out.println("========================================================\n\n");
        System.out.println("[ " + type.name() + " MENUS ] ");
        for (Product p : list) {
            System.out.print(num++ +". ");
            p.printProd();
        }
        System.out.println("\n\n========================================================");

        return list;
    }

    public void printCartList() {
        System.out.println("========================================================\n\n");
        int cnt = 1;
        System.out.println("[ ORDERS ]");
        System.out.println("아래와 같이 주문하시겠습니까?");
        List<Product> cart = order.getCart();

        for (Product c : cart) {
            System.out.print(cnt++ + ". ");
            c.printProd();
        }

        System.out.println("[ Total ]");
        System.out.printf(" ₩  %.1f \n", order.getTotal());
        System.out.println("1. 주문\t\t\t2. 메뉴판");
        System.out.println("\n\n========================================================");
    }

    public void printOrder() {
        System.out.println("========================================================\n\n");
        System.out.println("주문 완료");
        System.out.println("대기번호는 [ " + order.getOrderNumber() + " ] 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        System.out.println("\n\n========================================================");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.clear();
    }

    public void printAddCart(Product product) {
        System.out.println("========================================================\n\n");
        product.printProd();
        System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t\t\t2. 취소");
        System.out.println("\n\n========================================================");
    }

    public void printCancel() {
        System.out.println("========================================================\n\n");
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t\t\t2. 취소");
        System.out.println("\n\n========================================================");
    }
}
