package com.erhuotu.two_2.utilslibrary.Utils;

import java.util.Comparator;

/**
 * Created by TWO-2
 * 2018/9/18
 */
public class ComparatorImpl implements Comparator<String> {

    @Override
    public int compare(String lhs, String rhs) {
        return lhs.compareTo(rhs);
    }
}
