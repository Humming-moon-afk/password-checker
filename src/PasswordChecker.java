import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Passwort eingeben: ");
        String password = sc.nextLine();
        // Flag: Startwert true, wird nur false gesetzt, wenn ein ungültiges Zeichen gefunden wird
        boolean langPassend = true;
        // Prüfe zuerst die Länge des Passworts
        if (password.length() >= 8 && password.length() <= 20) {
            // Gehe jedes Zeichen einzeln durch
            for (int j = 0; j < password.length(); j++) {
                // Prüfe: Das Zeichen ist ungültig, wenn es weder eine Ziffer noch ein Buchstabe ist
                // (wichtige NICHT-Logik: !Digit && !Letter)
                if (!Character.isDigit(password.charAt(j)) && !Character.isLetter(password.charAt(j))) {
                    langPassend = false;
                    break;
                }
            }
            if (langPassend != false) {
                System.out.println("Gültig");
            } else if (langPassend == false) {
                System.out.println("Passwort ist zwar passend von der Länge, aber es beinhaltet ungültige Zeichen.");
            }
        } else if (password.length() > 20) {
            System.out.println("Das Passwort ist leider zu lang");
        } else if (password.length() < 8) {
            System.out.println("Das Passwort ist leider zu kurz");
        }
    }
}