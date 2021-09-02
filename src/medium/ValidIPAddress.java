package medium;

/**
 * 468. 验证IP地址
 */
public class ValidIPAddress {

    public static void main(String[] args) {
        ValidIPAddress validIPAddress = new ValidIPAddress();
        String s = validIPAddress.validIPAddress("20EE:FGb8:85a3:0:0:8A2E:0370:7334");
        System.out.println(s);
    }

    public String validIPAddress(String IP) {
        if (isIPV4(IP)) {
            return "IPv4";
        }
        if (isIPV6(IP)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean isIPV4(String IP) {
        if (IP.endsWith(".")) {
            return false;
        }
        String[] strings = IP.split("\\.");
        if (strings.length != 4) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0 || strings[i].length() > 3) {
                return false;
            }
            if (strings[i].startsWith("0") && strings[i].length() != 1) {
                return false;
            }
            for (int j = 0; j < strings[i].length(); j++) {
                if (strings[i].charAt(j) < '0' || strings[i].charAt(j) > '9') {
                    return false;
                }
            }
            if (Integer.parseInt(strings[i]) > 255) {
                return false;
            }
        }
        return true;
    }

    private boolean isIPV6(String IP) {
        if (IP.endsWith(":")) {
            return false;
        }
        String[] strings = IP.split(":");
        if (strings.length != 8) {
            return false;
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].length() == 0 || strings[i].length() > 4) {
                return false;
            }
            for (int j = 0; j < strings[i].length(); j++) {
                if (!((strings[i].charAt(j) >= '0' && strings[i].charAt(j) <= '9') ||
                        (strings[i].charAt(j) >= 'a' && strings[i].charAt(j) <= 'f') ||
                        (strings[i].charAt(j) >= 'A' && strings[i].charAt(j) <= 'F'))) {
                    return false;
                }
            }
        }
        return true;
    }
}
