public class TiktokXorEncrypt{
    
    /*
    * Tiktok sends data such as email - phone number and password in the login and registration process
    * by XOR encrypting the post data. You can encrypt your data conveniently using this function.
    * */

    public static String xorEncrypt(String param){
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < param.length(); i++) {
            int hexify = param.charAt(i) ^ 5;
            output.append(String.format("%02x", hexify));
        }

        return String.valueOf(output);
    }

    public static void main(String[] args) {
        System.out.println(xorEncrypt("ahmeth4n@gmail.com"));
    }
    
}