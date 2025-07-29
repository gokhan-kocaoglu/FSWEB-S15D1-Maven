package org.example.models;

import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPazar Arabası - Seçenekler:");
            System.out.println("0 - Uygulamayı sonlandır");
            System.out.println("1 - Eleman ekle (tekli veya virgüllü çoklu)");
            System.out.println("2 - Eleman çıkar (tekli veya virgüllü çoklu)");
            System.out.print("Seçiminizi girin (0, 1, 2): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) {
                System.out.println("Uygulama sonlandırılıyor...");
                break;
            } else if (choice.equals("1")) {
                System.out.print("Eklemek istediğiniz eleman(ları) girin (virgül ile ayırabilirsiniz): ");
                String input = scanner.nextLine();
                addItems(input);
                printSorted();
            } else if (choice.equals("2")) {
                System.out.print("Çıkarmak istediğiniz eleman(ları) girin (virgül ile ayırabilirsiniz): ");
                String input = scanner.nextLine();
                removeItems(input);
                printSorted();
            } else {
                System.out.println("Geçersiz seçim! Lütfen tekrar deneyin.");
            }
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            if (product.isEmpty()) continue;
            if (!checkItemIsInList(product)) {
                groceryList.add(product);
            }
        }
        sortAndDeduplicate();
    }

    // Eleman siler
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String product = item.trim().toLowerCase();
            if (checkItemIsInList(product)) {
                groceryList.remove(product);
            }
        }
        sortAndDeduplicate();
    }

    // Eleman listede var mı diye kontrol eder
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // Listeyi sıralar ve ekrana basar
    public static void printSorted() {
        sortAndDeduplicate();
        System.out.println("\nGüncel Pazar Listesi:");
        for (String item : groceryList) {
            System.out.println("- " + item);
        }
    }

    // Yardımcı metod: listeyi hem sıralar hem de tekrarları siler
    private static void sortAndDeduplicate() {
        Set<String> set = new TreeSet<>(groceryList);
        groceryList.clear();
        groceryList.addAll(set);
    }
}
