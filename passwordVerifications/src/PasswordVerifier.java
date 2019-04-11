import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class PasswordVerifier {
    private String lengthCondition = ".{8,}$";
    private String lowercaseCondition = "^(.*[a-z].*)";
//    private String lowercaseCondition = "^(?=(.*[a-z].*))";
    private String uppercaseCondition = "(.*[A-Z].*)";
//    private String uppercaseCondition = "(?=(.*[A-Z].*))";
    private String oneDigitCondition = "(.*[\\d].*)";
//    private String oneDigitCondition = "(?=(.*[\\d].*))";
    private List<String> conditions = Arrays.asList(lowercaseCondition, oneDigitCondition, uppercaseCondition
            , lengthCondition);

    public boolean verify(String password) {
        Pattern condition = getCompileRegex(lengthCondition, lowercaseCondition
                , uppercaseCondition, oneDigitCondition);

        Matcher matcher = condition.matcher(password);

        if (matcher.matches()) {
            for (String conditionn : conditions) {
                conditionn.matches(password);
            }
            return true;
        }
        return false;
    }

//    public boolean threeConditionsVeriefer() {
//       return conditions.stream();
//
//    }
    //long counter = verifiers.stream()
    //                .map(e -> e.verify(password))
    //                .filter(e -> e == true)
    //                .count();
    //        if (counter >= 3 && verifiers.get(0).verify(password)) {
    //            return true;
    //        }
    //        return false;

    public boolean specialVerifier(String password) {
        if (compile(lowercaseCondition).matcher(password).matches() == true) {
            return true;
        }
        return Boolean.valueOf("password not OK.");
    }

    private Pattern getCompileRegex(String lengthCondition, String lowercaseCondition, String uppercaseCondition, String oneDigitCondition) {
        return compile(lengthCondition + lowercaseCondition +
                uppercaseCondition + oneDigitCondition);
    }
}