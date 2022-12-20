package com.example.casestudy3.service.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private Pattern patternAccount;
    private Pattern patternPassword;
    private Pattern patternEmail;
    private Pattern patternTelephone;
    private Matcher matcher;

    private final String ACCOUNT_PATTERN = "^[_a-z0-9]{6,}$";
    private final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{6,8}$";
    private final String EMAIL_PATTERN =
            "^(([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)?)(@)([a-zA-Z]+.[A-Za-z]+\\.?([a-zA-Z0-9]+)\\.?([a-zA-Z0-9]+))$";
    private final String TELEPHONE_PATTERN = "^[0-9]{10}$";

    public Regex() {
        patternAccount = Pattern.compile(ACCOUNT_PATTERN);
        patternPassword = Pattern.compile(PASSWORD_PATTERN);
        patternEmail = Pattern.compile(EMAIL_PATTERN);
        patternTelephone = Pattern.compile(TELEPHONE_PATTERN);
    }

    public boolean validateAccount(String regex) {
        matcher = patternAccount.matcher(regex);
        return matcher.matches();
    }

    public boolean validatePassword(String regex) {
        matcher = patternPassword.matcher(regex);
        return matcher.matches();
    }

    public boolean validateEmail (String regex) {
        matcher = patternEmail.matcher(regex);
        return matcher.matches();
    }

    public boolean validateTelephone (String regex) {
        matcher = patternTelephone.matcher(regex);
        return matcher.matches();
    }
}
