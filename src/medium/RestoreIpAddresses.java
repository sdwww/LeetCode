/**
 * @(#)RestoreIpAddresses.java, 8月 29, 2021.
 * <p>
 * Copyright 2021 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author www
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses solution = new RestoreIpAddresses();
        List<String> list = solution.restoreIpAddresses("101023");
        System.out.println(list);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        search(list, s, new ArrayList<>());
        return list;
    }

    private void search(List<String> list, String leftString, List<Integer> numList) {
        if (leftString.length() == 0) {
            return;
        }
        if (numList.size() == 3) {
            if (("0".equals(leftString)
                    || (!leftString.startsWith("0") && leftString.length() <= 3 && Integer.parseInt(leftString) <= 255))) {
                numList.add(Integer.parseInt(leftString));
                list.add(convertToString(numList));
            }
            return;
        }
        // 取第一位
        ArrayList<Integer> tempNumList = new ArrayList<>(numList);
        tempNumList.add(Integer.parseInt(leftString.substring(0, 1)));
        search(list, leftString.substring(1), tempNumList);
        // 取前两位
        if (leftString.length() >= 2 && !leftString.startsWith("0")) {
            tempNumList = new ArrayList<>(numList);
            tempNumList.add(Integer.parseInt(leftString.substring(0, 2)));
            search(list, leftString.substring(2), tempNumList);
        }
        // 取前三位
        if (leftString.length() >= 3 && !leftString.startsWith("0") && Integer.parseInt(leftString.substring(0, 3)) <= 255) {
            tempNumList = new ArrayList<>(numList);
            tempNumList.add(Integer.parseInt(leftString.substring(0, 3)));
            search(list, leftString.substring(3), tempNumList);
        }
    }

    private String convertToString(List<Integer> list) {
        String string = list.get(0) + "." +
                list.get(1) + "." +
                list.get(2) + "." +
                list.get(3);
        return string;
    }
}