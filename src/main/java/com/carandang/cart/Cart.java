package com.carandang.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cart {

    private static Action[] actions = buildAction();
    private static CartItem[] cartItems = buildCartItems();
    private static List<CartItem> selectedCartItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            showActionPromptScreen();
            Action action = getAction(input);
            if (action != null) {
                int actionIndex = action.getIndex();
                switch (actionIndex) {
                    case 1:
                        showCartItems();
                        System.out.println("Select item to add:");
                        CartItem cartItemToAdd = getCartItemForAdd(input);
                        if (cartItemToAdd != null) {
                            selectedCartItems.add(cartItemToAdd);
                            showSelectedCartItems();
                        } else {
                            System.out.println("Invalid input");
                        }
                        break;
                    case 2:
                        showSelectedCartItems();
                        System.out.println("Select item to remove:");
                        int cartItemIndexForRemove = getCartItemIndexForRemove(input);
                        if (cartItemIndexForRemove != -1) {
                            selectedCartItems.remove(cartItemIndexForRemove);
                            showSelectedCartItems();
                        } else {
                            System.out.println("Invalid input");
                        }
                        break;
                    case 3:
                        if (selectedCartItems.isEmpty()) {
                            System.out.println("Cart is empty. No items to checkout");
                        } else {
                            printReciept();
                            flag = false;
                        }
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static Action getAction(Scanner input) {
        try {
            int index = Integer.parseInt(input.next());
            for (int i = 0; i < actions.length; i++) {
                Action action = actions[i];
                if (index == action.getIndex()) {
                    return action;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static CartItem getCartItemForAdd(Scanner input) {
        try {
            int index = Integer.parseInt(input.next());
            for (int i = 0; i < cartItems.length; i++) {
                CartItem cartItem = cartItems[i];
                if (index == cartItem.getIndex()) {
                    return cartItem;
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static int getCartItemIndexForRemove(Scanner input) {
        try {
            int index = Integer.parseInt(input.next());
            for (int i = 0; i < selectedCartItems.size(); i++) {
                if (i == index) {
                    return i;
                }
            }
            return -1;
        } catch (Exception e) {
            return -1;
        }
    }

    private static void showActionPromptScreen() {
        printDivider();
        StringBuffer sb = new StringBuffer();
        sb.append("Press ");
        for (int i = 0; i < actions.length; i++) {
            Action action = actions[i];
            sb.append("[");
            sb.append(action.getIndex());
            sb.append("]");
            sb.append(" ");
            sb.append(action.getDescription());
            if (i != actions.length - 1) {
                sb.append(" | ");
            }
        }
        System.out.println(sb.toString());
        printDivider();

    }

    private static void showCartItems() {
        System.out.println("Store Items");
        printDivider();
        for (int i = 0; i < cartItems.length; i++) {
            CartItem cartItem = cartItems[i];
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            sb.append(cartItem.getIndex());
            sb.append("]");
            sb.append(" ");
            sb.append(cartItem.getName());
            sb.append("  ");
            sb.append(cartItem.getCost());
            System.out.println(sb.toString());
        }
        printDivider();
    }

    private static void showSelectedCartItems() {
        printDivider();
        System.out.println("Cart Items");
        printDivider();
        for (int i = 0; i < selectedCartItems.size(); i++) {
            CartItem cartItem = selectedCartItems.get(i);
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            sb.append(i);
            sb.append("]");
            sb.append(" ");
            sb.append(cartItem.getName());
            sb.append("  ");
            sb.append(cartItem.getCost());
            System.out.println(sb.toString());
        }
    }

    private static void printReciept() {
        printDivider();
        System.out.println("RECEIPT");
        printDivider();
        System.out.println("Cashier: John  Shift: 08:00 - 18:00");
        System.out.println("Date: 2020-04-07");
        printDivider();
        System.out.println("Items:");
        double totalCost = 0;
        for (int i = 0; i < cartItems.length; i++) {
            CartItem cartItem = cartItems[i];
            long count = selectedCartItems.stream().filter(e -> e.getIndex() == cartItem.getIndex()).count();
            if (count > 0) {
                StringBuffer sb = new StringBuffer();
                sb.append("  ");
                sb.append(cartItem.getName());
                sb.append("  ");
                sb.append(count);
                sb.append("  ");
                double cost = count * cartItem.getCost();
                sb.append(cost);
                System.out.println(sb.toString());
                totalCost = totalCost + cost;
            }
        }
        printDivider();
        System.out.println("TOTAL: " + totalCost);
        printDivider();
    }

    private static void printDivider() {
        int size = 50;
        for (int i  = 0; i < 50; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    private static CartItem[] buildCartItems() {
        CartItem[] items = new CartItem[7];
        items[0] = new CartItem(0, "AMD Ryzen 5 2600", 6500.0);
        items[1] = new CartItem(1, "AMD Ryzen 5 3600", 10500.0);
        items[2] = new CartItem(2, "Kingston DDR4 16GB", 5459.0);
        items[3] = new CartItem(3, "Zotac GTX 1070ti", 15000.0);
        items[4] = new CartItem(4, "Gigabyte RTX 2080", 50000.0);
        items[5] = new CartItem(5, "Edifier Speaker", 2500.0);
        items[6] = new CartItem(6, "RGB Keyboard", 3200.0);
        return items;
    }

    private static Action[] buildAction() {
        Action[] actions = new Action[4];
        actions[0] = new Action(1, "add", "Add Item");
        actions[1] = new Action(2, "remove", "Remove Item");
        actions[2] = new Action(3,  "checkout", "Checkout");
        actions[3] = new Action(0, "exit", "Exit");
        return actions;
    }

}
