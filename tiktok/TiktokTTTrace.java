public class TiktokTTTrace {

    /*
    * This class will be generate X-Tt-Trace-Id headers value.
    */

    public static String generateTraceId(long deviceId, short aid) {
        return generateTraceId(deviceId, aid, System.currentTimeMillis(), null);
    }

    private static String toHexLower(byte[] data) {
        return Hex.encodeHexString(data).toLowerCase();
    }

    public static byte[] shortToBytes(short x) {
        ByteBuffer buffer = ByteBuffer.allocate(Short.BYTES);
        buffer.putShort(x);
        return buffer.array();
    }

    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }

    public static String generateTraceId(long deviceId, short aid, long timestamp, String padding) {
        StringBuilder result = new StringBuilder();

        result.append("00-");

        StringBuilder part = new StringBuilder();

        // Timestamp.
        part.append(toHexLower(generateTimestampBytes(timestamp)));

        // Device id.
        String deviceIdHex = "010";
        if (deviceId != 0) {
            deviceIdHex = toHexLower(longToBytes(deviceId)).replaceFirst("^0+(?!$)", "");
            deviceIdHex = String.format("%02x", deviceIdHex.length()) + deviceIdHex;
        }

        part.append(deviceIdHex);

        // Padding.
        int paddingRequired = 20 - deviceIdHex.length();
        if (padding != null && padding.length() == paddingRequired) {
            part.append(padding);
        } else {
            while (paddingRequired > 0) {
                part.append(String.format("%01x", ThreadLocalRandom.current().nextInt(0, 16)));
                paddingRequired--;
            }
        }

        // AID.
        part.append(toHexLower(shortToBytes(aid)));

        // Merge
        String partResult = part.toString();

        result.append(partResult);
        result.append("-");
        result.append(partResult, 0, 16);
        result.append("-01");

        return result.toString();
    }

    private static byte[] generateTimestampBytes(long timestamp) {
        BigInteger v4 = BigInteger.valueOf(timestamp);

        BigInteger v5 = BigInteger.valueOf(-9223372034707292159L)
                .multiply(v4)
                .shiftRight(64)
                .add(v4);

        BigInteger v6 = v4.subtract(BigInteger.valueOf(4294967295L).multiply(v5.shiftRight(31).add(v5.shiftRight(63))));

        byte[] result = v6.toByteArray();
        if (result[0] == 0) {
            result = Arrays.copyOfRange(result, 1, result.length);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateTraceId(7164356829035070983L, (short) 1233));
    }

}