public class IGPublicKeyGenerator extends BaseApi {

    public IGPublicKeyGenerator(BaseRequest request) {
        super(request);
    }

    /*
    * The value of `ig-set-password-encryption-pub-key` in the response header will be your public key that you will use in encryption operations,
    * and `ig-set-password-encryption-key-id` value will be your key id that you will use in encryption operations.
    * 
    * 
    * I used a BaseApi class to extend my own requester class and used the `request` variable to send requests.
    * You can replace it with your OkHttp class 
    * 
    * 
    * Example login encryption:
    * 
    *    String url = "https://b.i.instagram.com/api/v1/accounts/login/";
    *    String password = IGUtils.encryptPassword("yourPassword",(String) publicKeyValues.get("publicKeyId"), (Integer) publicKeyValues.get("publicKey"));
    *    password = URLEncoder.encode(password, "UTF-8");
    * 
    *    it's a example PWD_INSTAGRAM usage. 
    * 
    * */
   
    public HashMap<String,Object> get_public_key(IGHeaderBuilder builder) throws Exception {
        String url = "https://i.instagram.com/api/v1/launcher/mobileconfig/";

        HashMap<String,String> header = new HashMap<>();
        header.put("X-Ig-App-Locale",builder.getIg_app_locale());
        header.put("X-Ig-Device-Locale",builder.getIg_device_locale());
        header.put("X-Ig-Mapped-Locale",builder.getIg_mapped_locale());
        header.put("X-Pigeon-Rawclienttime",builder.getRaw_client_time());
        header.put("X-Ig-Bandwidth-Speed-Kbps", builder.getIg_bandwidth_speed_kbps());
        header.put("X-Ig-Bandwidth-Totalbytes-B",builder.getIg_bandwidth_totalbytes_b());
        header.put("X-Ig-Bandwidth-Totaltime-Ms",builder.getIg_bandwidth_totaltime_ms());
        header.put("X-Ig-App-Startup-Country",builder.getIg_app_startup_country());
        header.put("X-Bloks-Version-Id",builder.getBloks_version_id());
        header.put("X-Ig-Www-Claim",builder.getIg_ww_claim());
        header.put("X-Bloks-Is-Layout-Rtl",builder.getBloks_is_layout_rtl());
        header.put("X-Ig-Device-Id",builder.getIg_device_id());
        header.put("X-Ig-Family-Device-Id",builder.getFamily_device_id());
        header.put("X-Ig-Android-Id",builder.getIg_android_id());
        header.put("X-Ig-Timezone-Offset",builder.getIg_timezone_offset());
        header.put("X-Fb-Connection-Type",builder.getFb_connection_type());
        header.put("X-Ig-Connection-Type",builder.getIg_connection_type());
        header.put("X-IG-Capabilities",builder.getIg_capabilities());
        header.put("X-Ig-App-Id",builder.getIg_app_id());
        header.put("User-Agent",builder.getUser_agent());
        header.put("Accept-Language","en-US");
        header.put("X-Mid",builder.getX_mid());
        header.put("Ig-Intended-User-Id",builder.getIg_intended_user_id());
        header.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        header.put("X-Fb-Http-Engine",builder.getFb_http_engine());
        header.put("X-Fb-Client-Ip",builder.getFb_client_ip());
        header.put("X-Fb-Server-Cluster",builder.getFb_server_cluster());


        JSONObject jsonObject = new JSONObject();

        jsonObject.put("bool_opt_policy", "0");
        jsonObject.put("mobileconfigsessionless", "");
        jsonObject.put("api_version", "3");
        jsonObject.put("unit_type", "1");
        jsonObject.put("query_hash", "4640c4f14a49cd3392b6dccd8321ddb2740e4640e1e31790ee577cb1ba8440bb"); //i dont know how it's generated
        jsonObject.put("ts", System.currentTimeMillis()+"");
        jsonObject.put("device_id", builder.getIg_device_id());
        jsonObject.put("fetch_type", "ASYNC_FULL");
        jsonObject.put("family_device_id", builder.getFamily_device_id());

        String post_data = jsonObject.toString();
        String post_body = "signed_body=SIGNATURE."+URLEncoder.encode(post_data);

        this.request.setContent_type("application/x-www-form-urlencoded");
        Headers headers = Headers.of(header);
        Response response = request.post_request(url,post_body,headers);

        HashMap<String,Object> publicKey = new HashMap<>();
        publicKey.put("publicKey",response.header("ig-set-password-encryption-pub-key"));
        publicKey.put("publicKeyId",Integer.parseInt(Objects.requireNonNull(response.header("ig-set-password-encryption-key-id"))));
        
        return publicKey;
    }

}
