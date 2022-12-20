package RegexAndString.EmailExample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailExample {
    private static Pattern pattern;

    private static final String EMAIL_REGEX = "^\\w+@\\w+(\\.\\w+)$";

    public EmailExample() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    public boolean validate(String regex){
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
