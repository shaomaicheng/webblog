package shaomai.utils;

/**
 * 一个简单的将 markdown 内容的字符串的关于 md 语法的内容去除
 * 例如
 *
 * ###title  =>  title
 * ```java int a = 10; ```  => int a = 10;
 * **example** => example
 */
public class MarkdownParser {
    public static MarkdownParser getInstance() {
        return Holder.mInstance;
    }

    private static class Holder {
        private static MarkdownParser mInstance = new MarkdownParser();
    }

    /**
     * 将 markdown 解析为普通文字
     * @param md
     * @return
     */
    public String parseMarkdown(String md) {
        StringBuilder sb = new StringBuilder("");
        String[] lines = md.split("\n");
        for (String item: lines) {
            sb.append(parseLine(item)).append("\n");
        }
        return sb.subSequence(0, sb.length() - 1).toString();
    }

    /**
     * 解析每一行字符串
     * @param line
     * @return
     */
    public String parseLine(String line) {
        if (line.startsWith("#")) {
            return parseLine(line.substring(1, line.length()));
        } else if (line.startsWith("*") && line.endsWith("*")) {
            return parseLine(line.substring(1, line.length()-1));
        }  else if (line.startsWith("`") || line.startsWith("```")) {
            return "";
        } else if (line.startsWith(" ")) {
            return parseLine(line.substring(1, line.length()));
        } else {
            return line;
        }
    }
}
