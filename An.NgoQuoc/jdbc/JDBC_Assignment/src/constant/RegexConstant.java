package constant;

public class RegexConstant {
	public static final String REGEX_DATE = "^(0?[1-9]|[12][0-9]|3[01])[\\-](0?[1-9]|1[012])[\\-]\\d{4}$";
	public static final String REGEX_PHONE = "([0-9]{7,15})\\b";
	public static final String REGEX_MAIL = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
}
