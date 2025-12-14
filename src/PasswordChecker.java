import java.util.Scanner;
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RuleLength rule = new RuleLength();
        RuleContent ruleRule = new RuleContent();
        System.out.println("Bitte Passwort eingeben: ");
        String password;
        while (true) {
            password = sc.nextLine();
            if (rule.CheckLength(password) && ruleRule.CheckContent(password)) {
                System.out.println("Super");
                break;
            }
            else if (!rule.CheckLength(password) && ruleRule.CheckContent(password)) {
                System.out.println("Ungültige Länge super Zeichen!");
            }
            else if (rule.CheckLength(password) && !ruleRule.CheckContent(password)) {
                System.out.println("Schlechtes Passwort");
            }
            else {
                System.out.println("Ungültige Länge und schlechte Zeichen");
            }
            System.out.println("Bitte ein neues Passwort eingeben: ");
        }
        sc.close();
    }
}
class RuleLength {
    public boolean CheckLength(String password) {
        return password.length() >= 8 && password.length() <= 20;
    }
}
class RuleContent {
    public boolean CheckContent(String password) {
        boolean hasDigit = false;
        boolean hasLetter = false;
        boolean hasSpecials = false;
        boolean passend = false;
        String specials = "§$%&/-!";
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isLetter(c)) {
                hasLetter = true;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
            if(specials.indexOf(c) != -1) {
                hasSpecials = true;
            }
            else {
                return false;
            }
        }
        passend = hasLetter && hasDigit && hasSpecials;
        return passend;

    }
}
