package com.ben.shiro.util;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yangkun
 */
public class PageUtil {
    private static final Long PAGE_INDEX = 1L;
    private static final Long PAGE_SIZE = 10L;
    private static final Long TOTAL = 0L;

    public static <T> Page<T> getPageParam(HttpServletRequest request) {
        String pageIndex = request.getParameter("current");
        String pageSize = request.getParameter("size");
        String total = request.getParameter("total");
        String searchCount = request.getParameter("searchCount");
        String pages = request.getParameter("pages");
        Long aLong = getLong(pageIndex, PAGE_INDEX);
        Long bLong = getLong(pageSize, PAGE_SIZE);
        Long cLong = getLong(total, TOTAL);
        Boolean sc = getBoolean(searchCount, Boolean.FALSE);
        return new Page<>(aLong, bLong, cLong, sc);
    }

    private static Long getLong(String s, Long d) {
        try {
            return Long.valueOf(s);
        } catch (Exception e) {
            return d;
        }
    }

    private static Boolean getBoolean(String s, Boolean b) {
        try {
            return Boolean.valueOf(s);
        } catch (Exception e) {
            return b;
        }
    }
}
