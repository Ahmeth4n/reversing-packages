public class TikTokUtils {
    public static String getAppLogIV(){
        return UUID.randomUUID().toString().substring(0,16).toUpperCase();
    }
    public static String getAppLogKey(){
        return UUID.randomUUID().toString().toUpperCase();
    }
}