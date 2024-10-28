import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Kelas untuk merepresentasikan item menu
class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Kelas untuk merepresentasikan pesanan
class Order {
    private List<MenuItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }


    }

    public void printReceipt() {
        System.out.println("----- Nota Pemesanan -----");
        for (MenuItem item : items) {
            System.out.println(item.getName() + " - Rp " + item.getPrice());
        }
        System.out.println("--------------------------");
        System.out.println("Total: Rp " + calculateTotal());
    }
}

// Kelas utama untuk menjalankan aplikasi
public class Restaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menu = new ArrayList<>();

        // Menambahkan item menu
        menu.add(new MenuItem("Nasi Goreng", 20000));
        menu.add(new MenuItem("Mie Goreng", 15000));
        menu.add(new MenuItem("Ayam Penyet", 25000));
        menu.add(new MenuItem("Sate Ayam", 30000));

        System.out.println("Selamat datang di Restoran!");
        Order order = new Order();

        while (true) {
            System.out.println("Menu:");
            for (int i = 0; i < menu.size(); i++) {
                System.out.println((i + 1) + ". " + menu.get(i).getName() + " - Rp " + menu.get(i).getPrice());
            }
            System.out.println("Pilih item (1-" + menu.size() + ") atau 0 untuk selesai:");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            } else if (choice > 0 && choice <= menu.size()) {
                order.addItem(menu.get(choice - 1));
                System.out.println("Item ditambahkan: " + menu.get(choice - 1).getName());
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        order.printReceipt();
        scanner.close();
    }
}
