package shaomai.test.utils;

import org.junit.Test;
import shaomai.utils.MarkdownParser;

import static org.junit.Assert.assertEquals;

public class MarkdownParseTest {

    @Test
    public void parseLineTest() {
        MarkdownParser parser = MarkdownParser.getInstance();
        String line1 = "###Title";
        assertEquals(parser.parseLine(line1), "Title");
        String line2 = "**subtitle**";
        assertEquals(parser.parseLine(line2), "subtitle");
        String line3 = "#####Title***";
        assertEquals(parser.parseLine(line3), "Title***");
        String line4 = "```java";
        assertEquals(parser.parseLine(line4), "");
        String line5 = "### Title";
        assertEquals(parser.parseLine(line5), "Title");
    }

    @Test
    public void parseMarkdownTest() {
        MarkdownParser markdownParser = MarkdownParser.getInstance();
        String md = "# 深入理解Android消息机制\n" +
                "\n" +
                "在日常的开发中，Android 的消息机制作为系统运行的根本机制之一，显得十分的重要。\n" +
                "### 从 Handler 发送消息开始\n" +
                "\n" +
                "查看源码，Handler的post、send方法最终都会走到\n" +
                "```java\n" +
                "public final boolean sendMessageDelayed(Message msg, long delayMillis) {\n" +
                "\tif (delayMillis < 0) {\n" +
                "\t    delayMillis = 0;\n" +
                "    }\n" +
                "    return sendMessage";
        String expect = "深入理解Android消息机制\n" +
                "\n" +
                "在日常的开发中，Android 的消息机制作为系统运行的根本机制之一，显得十分的重要。\n" +
                "从 Handler 发送消息开始\n" +
                "\n" +
                "查看源码，Handler的post、send方法最终都会走到\n" +
                "\n" +
                "public final boolean sendMessageDelayed(Message msg, long delayMillis) {\n" +
                "\tif (delayMillis < 0) {\n" +
                "\t    delayMillis = 0;\n" +
                "}\n" +
                "return sendMessage";
        assertEquals(markdownParser.parseMarkdown(md), expect);
    }
}
