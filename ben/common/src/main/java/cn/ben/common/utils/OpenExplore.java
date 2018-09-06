package cn.ben.common.utils;

import java.awt.*;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;

/**
 * @TIME 2018/8/1 11:16
 * @User yangkun
 * @DESCRIPTION
 */
public class OpenExplore {
    public static void main(String[] args) throws Exception {
        browse("www.baidu.com");
    }

    public static void openDefault(String url) throws IOException {
        URI uri = URI.create(url);
        // 获取当前系统桌面扩展
        Desktop dp = Desktop.getDesktop();
        // 判断系统桌面是否支持要执行的功能
        if (dp.isSupported(Desktop.Action.BROWSE)) {
            // 获取系统默认浏览器打开链接
            dp.browse(uri);
        }
    }

    /**
     * 打开指定浏览器地址
     *
     * @param command
     * @param url
     * @throws IOException
     */
    public static void openGivenExplore(String command, String url) throws IOException {
        ProcessBuilder proc = new ProcessBuilder(command, url);
        proc.start();
    }

    public static void cmdOpen(String url) throws IOException {
        Runtime.getRuntime().exec("cmd /c start " + url);
    }


    private static void browse(String url) throws Exception {
        // 获取操作系统的名字
        String osName = System.getProperty("os.name", "");
        if (osName.startsWith("Mac OS")) {
            // 苹果的打开方式
            Class fileMgr = Class.forName("com.apple.eio.FileManager");
            Method openURL = fileMgr.getDeclaredMethod("openURL", String.class);
            openURL.invoke(null, url);
        } else if (osName.startsWith("Windows")) {
            // windows的打开方式。
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
        } else {
            // Unix or Linux的打开方式
            String[] browsers = {"firefox", "opera", "konqueror", "epiphany",
                    "mozilla", "netscape"};
            String browser = null;
            for (int count = 0; count < browsers.length && browser == null; count++)
                // 执行代码，在brower有值后跳出，
                // 这里是如果进程创建成功了，==0是表示正常结束。
                if (Runtime.getRuntime()
                        .exec(new String[]{"which", browsers[count]})
                        .waitFor() == 0)
                    browser = browsers[count];
            if (browser == null)
                throw new Exception("Could not find web browser");
            else
                // 这个值在上面已经成功的得到了一个进程。
                Runtime.getRuntime().exec(new String[]{browser, url});
        }
    }

}
