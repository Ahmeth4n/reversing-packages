package org.fbyte.services.apis.instagram.builder;

import org.fbyte.services.apis.instagram.IGConstant;
import org.fbyte.services.apis.instagram.util.IGUtils;

import java.util.concurrent.ThreadLocalRandom;

public class IGBuilder {

    /*
    * This class creates instagram headers
    */

    private final static IGBuilder INSTANCE = new IGBuilder();
    public static IGBuilder getInstance() {
        return INSTANCE;
    }
    public IGHeaderBuilder igHeaderBuilder;
    private final IGConstant igConstant;
    private String locale;

    public IGBuilder(){
        this.igHeaderBuilder = new IGHeaderBuilder();
        this.igConstant = new IGConstant();
    }
    public IGBuilder(String locale){
        this.locale = locale;
        this.igHeaderBuilder = new IGHeaderBuilder();
        this.igConstant = new IGConstant();
    }

    @Override
    public String toString() {
        return "IGBuilder{" +
                "igHeaderBuilder=" + igHeaderBuilder +
                ", igConstant=" + igConstant +
                ", locale='" + locale + '\'' +
                '}';
    }

    public void build(){

        if (locale == null){
            locale = igConstant.DEFAULT_LOCALE;
        }

        igHeaderBuilder.setIg_app_locale(locale);
        igHeaderBuilder.setIg_device_locale(locale);
        igHeaderBuilder.setIg_mapped_locale(locale);
        igHeaderBuilder.setRaw_client_time(System.currentTimeMillis() + "");
        igHeaderBuilder.setIg_bandwidth_speed_kbps(String.valueOf(ThreadLocalRandom.current().nextInt(2000, 4000)));
        igHeaderBuilder.setIg_bandwidth_totalbytes_b("0");
        igHeaderBuilder.setIg_bandwidth_totaltime_ms("0");
        igHeaderBuilder.setIg_app_startup_country(locale.split("_")[0].toUpperCase());
        igHeaderBuilder.setBloks_version_id("a399f367a2e4aa3e40cdb4aab6535045b23db15f3dea789880aa0970463de062");
        igHeaderBuilder.setIg_ww_claim("0");
        igHeaderBuilder.setBloks_is_layout_rtl("false");
        igHeaderBuilder.setIg_device_id(IGUtils.randomUuid());
        igHeaderBuilder.setFamily_device_id(IGUtils.randomUuid());
        igHeaderBuilder.setWaterfall_id(IGUtils.randomUuid());

        /*
        *  new android version use:
        *  0QQ.A03 = new String[]{"9774d56d682e549c", "9d1d1f0dfa440886", "fc067667235b8f19"}
        * */
        igHeaderBuilder.setIg_android_id(IGUtils.getUpdatedDeviceId());
        igHeaderBuilder.setIg_timezone_offset("0");
        igHeaderBuilder.setFb_connection_type("WIFI");
        igHeaderBuilder.setIg_connection_type("WIFI");
        igHeaderBuilder.setIg_capabilities("3brTv10=");
        igHeaderBuilder.setIg_app_id(this.igConstant.INSTA_APP_ID);
        igHeaderBuilder.setX_mid("Y4f0vQABAAEUpCxzXOYr9RBte7U0");
        igHeaderBuilder.setIg_intended_user_id("0");
        igHeaderBuilder.setFb_http_engine("Liger");
        igHeaderBuilder.setFb_client_ip("True");
        igHeaderBuilder.setFb_server_cluster("True");
        igHeaderBuilder.setUser_agent(this.igConstant.INSTA_USER_AGENT);

    }
}
