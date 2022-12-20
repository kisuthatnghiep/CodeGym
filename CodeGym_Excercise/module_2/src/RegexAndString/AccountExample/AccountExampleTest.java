package RegexAndString.AccountExample;

public class AccountExampleTest {
    public static void main(String[] args) {
        String[] validAccount = {"123abc_", "_abc123", "______", "123456","abcdefgh"};
        String[] inValidAccount = {".@", "12345", "1234_", "abcde"};
        AccountExample accountExample = new AccountExample();
        for (String account: validAccount){
            System.out.println("Account: " + account + " is " + accountExample.validate(account));
        }
        for (String account: inValidAccount){
            System.out.println("Account: " + account + " is " + accountExample.validate(account));
        }
    }
}
