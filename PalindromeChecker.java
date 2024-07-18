public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static void main(String[] args) {
        String input = "A man, a plan, a canal, Panama";
        boolean result = isPalindrome(input);
        System.out.println("Is the string a palindrome? " + result);
    }
}
