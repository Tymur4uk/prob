import static io.netty.util.internal.PlatformDependent.isWindows;

public class TestHelper {
    public static String siteUrl(){
        if (isWindows()){
            return "D:\\Tymur\\ViberDownloads\\chromedriver\\prob\\src\\main\\resources\\index.html";
        }else {
        throw new RuntimeException("Your OS is not support!");
        }
    }
}
