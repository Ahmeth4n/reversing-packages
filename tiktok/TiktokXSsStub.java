public class TiktokXSsStub {

    /*
    * This class will be generate X-Ss-Stub headers value. 
    * Basically X-Ss-Stub is the encrypted form of post datas
    */

    public static String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMd5(byte[] input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input);
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }


    public static String generateStub(String body){
        String dataMd5 = getMd5(body);
        dataMd5 = dataMd5.toUpperCase();

        return dataMd5;
    }

    public static String generateStub(byte[] body){
        String dataMd5 = getMd5(body);
        dataMd5 = dataMd5.toUpperCase();

        return dataMd5;
    }

    public static void main(String[] args) {
        System.out.println(TiktokXSsStub.generateStub("ahmeth4n"));
    }

}
