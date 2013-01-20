package com.emitrom.lienzo.client.core.util;

import com.emitrom.lienzo.client.core.util.StringUtil;
import com.emitrom.lienzo.client.junit.LienzoTestCase;

public class TestStringUtil extends LienzoTestCase
{
    public void testFormat()
    {
        assertEquals("", StringUtil.format(""));
        assertEquals("a", StringUtil.format("a"));
        assertEquals("a", StringUtil.format("{0}", "a"));
        assertEquals("abc", StringUtil.format("{0}", "abc"));
        assertEquals("dabc", StringUtil.format("d{0}", "abc"));
        assertEquals("dabce", StringUtil.format("d{0}e", "abc"));
        assertEquals("abcxyz", StringUtil.format("{0}{1}", "abc", "xyz"));
        assertEquals("abcexyz", StringUtil.format("{0}e{1}", "abc", "xyz"));
        assertEquals("dabcexyz", StringUtil.format("d{0}e{1}", "abc", "xyz"));
        assertEquals("abcexyzd", StringUtil.format("{0}e{1}d", "abc", "xyz"));
        assertEquals("abc{a}xyz", StringUtil.format("{0}{a}{1}", "abc", "xyz"));
        assertEquals("abc{a}xyz{", StringUtil.format("{0}{a}{1}{", "abc", "xyz"));
        assertEquals("abc{a}xyz}", StringUtil.format("{0}{a}{1}}", "abc", "xyz"));
    }
}
