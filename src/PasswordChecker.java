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
                System.out.println("Gute Länge und passende Zeichen!");
                break;
            }
            else if (!rule.CheckLength(password) && ruleRule.CheckContent(password)) {
                System.out.println("Ungültige Länge aber passende Zeichen!");
            }
            else if (rule.CheckLength(password) && !ruleRule.CheckContent(password)) {
                System.out.println("Passende Länge aber ungültige Zeichen!");
            }
            else {
                System.out.println("Ungültige Länge und ungültige Zeichen!");
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
        String allowedSpecialCharacters = "§$%&-*!";
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetter(password.charAt(i)) &&
                    !Character.isDigit(password.charAt(i)) &&
                    allowedSpecialCharacters.indexOf(password.charAt(i)) == -1) {
                return false;
            }
        }
        return true;
    }
}

