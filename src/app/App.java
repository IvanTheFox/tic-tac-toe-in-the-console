package app;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Игра \"Крестики и нолики\" в консоли\nВведите:");
            UI ui = new UI();
            while (ui.AppStart()) {}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}