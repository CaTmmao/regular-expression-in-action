package com.github.hcsp.regex;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LogProcessor {
    // 传入日志字符串，将每行开头的时间戳删除
    // 返回删除时间戳后的字符串
    // 例如，输入字符串：
    //
    // [2019-08-01 21:24:41] bt3102 (11m:21s)
    // [2019-08-01 21:24:42] TeamCity server version is 2019.1.1 (build 66192)
    // [2019-08-01 21:24:43] Collecting changes in 2 VCS roots (22s)
    //
    // 返回结果：
    //
    // bt3102 (11m:21s)
    // TeamCity server version is 2019.1.1 (build 66192)
    // Collecting changes in 2 VCS roots (22s)
    public static String process(String log) {
        String[] strings = log.split("\n");
        return Arrays.stream(strings).map(item -> item.replaceFirst("\\[.{19}]", "")).collect(Collectors.joining("\n"));
    }

    public static void main(String[] args) {
        String str =
                "[2019-12-01 01:24:41] bt3102 (11m:21s)\n"
                        + "[2019-01-01 00:00:00] TeamCity server version is 2019.1.1 [2019-01-01 00:00:00] (build 66192)\n"
                        + "[2019-01-31 23:59:59] Collecting changes in 2 VCS roots (22s)\n";

        System.out.println(process(str));
    }
}
