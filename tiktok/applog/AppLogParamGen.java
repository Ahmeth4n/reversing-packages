public class AppLogParamGen {

    private final TikTokSession session;
    private final static int NT_VALUE = 4;
    private final static String BATTERY_CHARGE_STATUS = String.valueOf(ThreadLocalRandom.current().nextInt(0,1));
    private final static String LIVESDK_VERSION = TikTokVersion.VERSION_27_6_0.liveSdkVersion;
    private final AtomicInteger teaEventIndexCounter = new AtomicInteger(0);

    public AppLogParamGen(TikTokSession session) {
        this.session = session;
    }

    public HashMap<String,Object> getParams(String title){
        HashMap<String,Object> params = new HashMap<>();
        switch (title){
            case "turing_verify_sdk":
                params.put("duration",1);
                params.put("host_app_id","1233");
                params.put("key","init");
                params.put("params_for_special", "turing");
                break;
            case "att_authorization_status":
                params.put("status_code", "3");
                break;
            case "libra_common_request":
                params.put("scene", "0");
                break;
            case "device_check_token":
                params.put("status", "1");
                params.put("generate_duration_ms", String.valueOf(ThreadLocalRandom.current().nextInt(100,350)));
                break;
            case "hybrid_ab_req_send":
                params.put("app_start_req_send_duration", String.valueOf(ThreadLocalRandom.current().nextInt(100,350)));
                break;
            case "rd_tiktokec_mall_entrance_abtest_status":
                params.put("friends_second_tab", "0");
                params.put("mall_second_tab", "0");
                params.put("mall_top_tab", "0");
                params.put("music_dsp_strategy", "{\"dsp_entrance\":0,\"dsp_enable_background_play\":false,\"dsp_enable_feed_card\":false,\"dsp_ui_style\":0}");
                break;
            case "multi_account_status":
                params.put("enter_from", "on_launch_pre_sync");
                params.put("read_type", "0");
                params.put("user_ids", "");
                params.put("arch_type", "1");
                params.put("aweme_uids_old", "");
                params.put("free_disk_inGB", String.valueOf(ThreadLocalRandom.current().nextInt(1,9)+"."+ThreadLocalRandom.current().nextInt(100,999)));
                params.put("aweme_uids_new", "");
                params.put("store_type", "0");
                params.put("account_num", "0");
                break;
            case "no_data_refresh_page":
                params.put("network_status", "5");
                params.put("enter_from", "homepage_hot");
                break;
            case "feed_request":
                params.put("access", "none");
                params.put("feed_tab", "homepage_hot");
                params.put("network_status", "5");
                params.put("duration", String.valueOf(ThreadLocalRandom.current().nextInt(1,9)+"."+ThreadLocalRandom.current().nextInt(100,999)));
                params.put("enter_from", "on_launch_pre_sync");
                params.put("is_first", "1");
                params.put("request_method", "refresh");
                break;
            case "enter_homepage_hot":
                params.put("enter_method", "open_app");
                params.put("enter_from", "open_app");
                break;
            case "show_top_tab":
                params.put("full_tab_name", "[homepage_follow, homepage_hot]");
                params.put("nearby_visibility_is_allow", "0");
                params.put("tab_cnt", "2");
                params.put("full_tab_cnt", "2");
                break;
            case "keychain_check_slogan_page":
                params.put("has_keychain", "0");
                break;
            case "mandatory_login_decision":
                params.put("is_first_launch", "1");
                params.put("priority_region", "US");
                params.put("first_ever_priority_region", "US");
                params.put("first_ever_store_region", "US");
                params.put("is_second_launch", "0");
                params.put("store_region", "0");
                break;

            case "ios_client_ab_vid":
                params.put("status", "0");
                params.put("vid_list", "");
                break;

            case "show_slogan_page":
                params.put("cdn_ab_ready", "0");
                params.put("cdn_ab_sent", "0");
                params.put("from_start_to_current_duration", String.valueOf(ThreadLocalRandom.current().nextInt(1000,3000)+"."+ThreadLocalRandom.current().nextInt(10000,30000)));
                params.put("is_hybrid_ab_recv", "0");
                params.put("is_ab_backend_resp_received", "0");
                params.put("is_cold_start_first_launch", "1");
                break;
            case "ep_load_builtin_algorithm_records":
                params.put("builtinAlgorithmRecords", "name: tt_face, version: 11.1, sizeType: 0 name: tt_face_extra, version: 14.0, sizeType: 0 name: tt_face_attribute_age, version: 2.0, sizeType: 0 ");
                break;
            case "ep_setup_database_completion":
                params.put("success", "1");
                params.put("error","");
                break;
            case "launch_log":
                params.put("enter_to","");
                params.put("is_have_cache","0");
                params.put("last_session","not_get");
                params.put("system_mode","light");
                params.put("is_cold_launch","1");
                params.put("link_id","");
                params.put("launch_method","enter_launch");
                params.put("launch_from","");
                params.put("last_end_power","101");
                params.put("cc_mode","1");
                params.put("red_badge_number","0");
                params.put("last_start_power","101");
                params.put("launch_num","1");
                params.put("current_power",String.valueOf(ThreadLocalRandom.current().nextInt(10,100)));
                params.put("from_user_id","");
                params.put("launch_network_status","5");
                params.put("is_charging",BATTERY_CHARGE_STATUS);
                params.put("app_ui_mode","light");
                params.put("is_share_link_launch","0");
                params.put("convert_url","");
                break;
            case "topview_aweme":
                params.put("aweme_number", "0");
                break;
            case "livesdk_setting_interface_avoid":
                params.put("_param_live_platform", "live");
                params.put("avoid_reason", "not_log_in");
                params.put("sdk_version", LIVESDK_VERSION);
                break;
            case "draft_db_corrupted":
                params.put("manage", "WCDB_Story");
                params.put("status", "0");
                params.put("is_story", "1");
                break;
            case "hybrid_ab_req_recv":
                params.put("status", "0");
                params.put("req_duration", String.valueOf(ThreadLocalRandom.current().nextInt(1000,3000)+"."+ThreadLocalRandom.current().nextInt(10000,30000)));
                break;
            case "os_backup_check":
                params.put("is_first_install", "1");
                params.put("is_switch_install", "1");
                params.put("os_cloud_backup_enabled", "1");
                params.put("is_reinstall", "0");
                break;
            case "device_check_result":
                params.put("device_check_result", "new");
                break;
            case "device_info":
                params.put("is_transparent_bar", "1");
                params.put("watch_history_permission_status", "2");
                params.put("traffic_economy_mode", "0");
                params.put("cpu_core_nums", "2");
                params.put("storage_total_internal_size", "15989469184");
                params.put("memory_total_size", "2105016320");
                params.put("mic_permission_status", "0");
                params.put("photo_permission_status", "0");
                params.put("camera_permission_status", "0");
                params.put("cpu_vendor", "");
                break;
            case "friends_tab_show":
                params.put("is_top_tab", "0");
                break;
            case "launch_log_with_ua":
                params.put("is_first_launch", "1");
                params.put("user_agent", session.getUserAgent());
                break;
        }
        params.put("tea_event_index", teaEventIndexCounter.get());
        params.put("nt", NT_VALUE);
        params.put("local_time_ms", Instant.now().toEpochMilli());

        teaEventIndexCounter.getAndIncrement();
        return params;
    }

}
