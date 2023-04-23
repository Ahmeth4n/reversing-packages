public class TikTokAppLogNew implements EventBuilder {
    /*
    *   This class generate TikTok applog request with all original fields. (for iOS)
    *   TikTokSession is my session serializer class. it's an example session file;

    *    "vendorId": "AED29A65-EDBF-4C67-BC54-B9D42E34A616",
    *    "advertiserId": "A8CD15A5-20DB-4331-8B09-0D02FF6784BD",
    *    "idfv": "515AB497-6962-403C-826F-C18B66E3C881",
    *    "idfa": "260C9D58-D7FF-4494-9664-BAC2909ACD1F",
    *    "openUDID": "1b13c742aeb16ba20d5b9454b6f27434f2c8f138",
    *    "clientDID": "594C00DA-32BF-442C-AAC1-CBX4FF68C065",
    *    "region": "DE",
    *    "deviceId": 7204935043143665237,
    *    "installId": 7204935926039677077,
    *    "screenWidth": 1170,
    *    "screenHeight": 2532,
    *    "deviceOs": "16.1.1",
    *    "tikTokStoreRegion": "de",
    *    "tikTokStoreRegionSrc": "uid",
    *    "language": "en",
    *    "languagePreferred": "en-US",
    *    "localeIdentifier": "en_EN",
    *    "carrier": "",
    *    "installTime": 1677529930,
    *    "ipswTimestampAccess": 1575523468,
    *    "ipswTimestampModified": 1575523468,
    *    "ipswTimestampCreated": 1575523468,
    *    "ipswTimestampBirth": 1575522971,
    *    "ipswDyldUuid": "651EB4D8-A0F0-3C97-A0C4-6A8F6FC17A56",
    *    "deviceOsBuild": "17C54",
    *    "deviceModel": "iPhone13,2",
    *    "deviceModelBuild": "D53gAP",
    *    ... more
    * 
    *   The output is bigger, but I'm putting some of it here so you can understand the values from the session serializer class.
    *   You can change these values with your own session class.
    * 
    */

    private final AppLogParamGen paramGen;
    private final static String APPLOG_USER_ID = "0";
    private final static int APPLOG_NT_VALUE = 4;
    private final String APPLOG_AES_ENCRYPT_IV = TikTokUtils.getAppLogIV();
    private final String APPLOG_AES_ENCRYPT_KEY = TikTokUtils.getAppLogKey();
    private final String APPLOG_SESSION_ID = UUID.randomUUID().toString().toUpperCase();
    private final static String[] LABEL_FIELDS = {"click","click","show","main_page_time","perf_monitor","show","launch_time","perf_monitor"};
    private final static String[] TAG_FIELDS = {"homepage","homepage_hot","homepage_hot","aweme_app_performance","homepage","homepage","load_application_end","homepage"};
    private final static String[] STARTUP_EVENTS = {"turing_verify_sdk","att_authorization_status","libra_common_request","device_check_token","hybrid_ab_req_send",
            "rd_tiktokec_mall_entrance_abtest_status","multi_account_status","no_data_refresh_page","feed_request",
            "enter_homepage_hot","show_top_tab","keychain_check_slogan_page","mandatory_login_decision","ios_client_ab_vid",
            "show_slogan_page","ep_load_builtin_algorithm_records","ep_setup_database_completion","launch_log","turing_verify_sdk","topview_aweme",
            "livesdk_setting_interface_avoid","draft_db_corrupted","hybrid_ab_req_recv","os_backup_check","feed_request","device_check_result",
            "device_info","friends_tab_show","launch_log_with_ua"};
    private final TikTokSession session;
    public TikTokAppLogNew(TikTokSession session) {
        this.session = session;
        paramGen = new AppLogParamGen(session);
    }
    public enum ApplogBuildType{
        FIRST_LAUNCH_LOG,DEVICE_HEADER_LOG,LOG_SETTINGS,FOLLOW_APPLOG
    }
    public List<AppEventV1> buildEvent(){
        List<AppEventV1> parameterPayload  = new ArrayList<>();
        for (int i = 0; i <LABEL_FIELDS.length; i++){
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
            String formattedDate = ft.format(dNow);
            parameterPayload.add(i, new AppEventV1(LABEL_FIELDS[i],String.valueOf(Instant.now().toEpochMilli()),session.getAbSdkVersion(),TAG_FIELDS[i],String.valueOf(i),formattedDate,APPLOG_SESSION_ID));
        }
        return parameterPayload;
    }
    public List<LaunchAppLog> buildLaunch(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String formattedDate = ft.format(dNow);

        List<LaunchAppLog> launch  = new ArrayList<>();
        launch.add(0,new LaunchAppLog(session.getAbSdkVersion(),1,formattedDate,APPLOG_SESSION_ID,0,Instant.now().toEpochMilli(),false));
        return launch;
    }

    public List<AppPerfAppLog> buildAppPerf(){
        List<AppPerfAppLog> appPerf  = new ArrayList<>();
        appPerf.add(0,new AppPerfAppLog(APPLOG_SESSION_ID));
        return appPerf;
    }

    @Override
    public List<AppEventV3> getEventList(String[] event_names) {
        List<AppEventV3> parameterPayload  = new ArrayList<>();
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        String formattedDate = ft.format(dNow);

        int count = 0;
        for (String event: event_names){
            parameterPayload.add(count,new AppEventV3(session.getAbSdkVersion(), formattedDate,event,APPLOG_SESSION_ID,APPLOG_USER_ID,APPLOG_NT_VALUE,paramGen.getParams(event)));
        }

        return parameterPayload;
    }
    @Override
    public AppLogHeader getHeader() throws Exception {
        AppLogHeader appLogData = new AppLogHeader();
        AppLogHeader.AppLogCustomData customData = new AppLogHeader.AppLogCustomData();
        appLogData.setDeviceId(String.valueOf(session.getDeviceId()));
        appLogData.setRegion(session.getRegion());
        appLogData.setAccess("WIFI");
        appLogData.setEventSamplingVersion(1673339057);
        appLogData.setOsVersion(session.getDeviceOs());
        appLogData.setDeviceModel(session.getDeviceModel());
        appLogData.setAppName("musical_ly");
        appLogData.setVendorId(session.getVendorId());
        appLogData.setCarrier("");
        appLogData.setScene(0);
        appLogData.setSdkVersion(13061);
        appLogData.setModelDisplayName(session.getDeviceModel());
        appLogData.setDisplayName("TikTok");
        appLogData.setDeviceToken("");
        appLogData.setChannel("App Store");
        appLogData.setAppRegion(session.getRegion());
        appLogData.setAuthStatus(3);
        appLogData.setUserAgent(session.getUserAgent());
        appLogData.setIdfa(session.getIdfa());
        appLogData.setInstallId(String.valueOf(session.getInstallId()));
        appLogData.setOs("iOS");
        appLogData.setTzName("GMT");
        appLogData.setTzOffset(0);
        appLogData.setAppLanguage(session.getLanguage());
        appLogData.setCarrierRegion("");
        appLogData.setIsUpgradeUser(false);
        appLogData.setMccMnc("");
        appLogData.setAid("1233");
        appLogData.setPackageName("com.zhiliaoapp.musically");
        appLogData.setIsJailbroken(false);
        appLogData.setLanguage(session.getLanguage()+"-"+session.getRegion());
        appLogData.setCdid(session.getClientDID());
        appLogData.setAppVersion(session.getVersionName());
        appLogData.setResolution(session.getResolutionFormatted());
        appLogData.setTimezone(0);

        //TODO: custom field in app_log
        customData.setAppRegion(session.getRegion());
        customData.setEarphoneStatus("off");
        customData.setWebUa(session.getUserAgent());
        customData.setIsKidsMode(0);
        customData.setIsPad(0);
        customData.setFilterWarn(0);
        customData.setUserPeriod(0);
        customData.setUserMode(1);
        customData.setAppLanguage(session.getLanguage());
        customData.setBuildNumber(String.valueOf(session.getCfBundleVersion()));

        appLogData.setAppLogCustomData(customData);
        return appLogData;
    }

    public String build(ApplogBuildType buildType) throws Exception {
        long currentTime = Instant.now().toEpochMilli();
        String buildPayload = null;
        AppLogBody app_body = null;
        switch (buildType){
            case DEVICE_HEADER_LOG:
                HashMap<String,Object> paramList = new HashMap<>();
                paramList.put("local_time",currentTime);
                paramList.put("server_time",currentTime);
                app_body = new AppLogBody.Builder("ss_app_log", APPLOG_AES_ENCRYPT_IV, APPLOG_AES_ENCRYPT_KEY, getHeader())
                        .event_log(paramList)
                        .event_sampling(1)
                        .build();
                buildPayload = new Gson().toJson((app_body));
                break;

            case FIRST_LAUNCH_LOG:
                List<AppEventV3> parameterPayload  = getEventList(STARTUP_EVENTS);
                List<LaunchAppLog> launchBuild = buildLaunch();
                List<AppPerfAppLog> appPerfBuild = buildAppPerf();
                List<AppEventV1> eventBuild = buildEvent();

                app_body = new AppLogBody.Builder("ss_app_log",APPLOG_AES_ENCRYPT_IV,APPLOG_AES_ENCRYPT_KEY,getHeader())
                        .event_log_arr(parameterPayload)
                        .launch(launchBuild)
                        .app_perf(appPerfBuild)
                        .event(eventBuild)
                        .event_sampling(1)
                        .build();
                buildPayload = new Gson().toJson((app_body));
                break;
            case LOG_SETTINGS:
                app_body = new AppLogBody.Builder("ss_app_log", APPLOG_AES_ENCRYPT_IV, APPLOG_AES_ENCRYPT_KEY, getHeader()).build();
                buildPayload = new Gson().toJson((app_body));
                break;
        };

        return buildPayload;
    }
}