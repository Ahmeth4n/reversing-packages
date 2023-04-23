public class AppLogHeader {
    @Nullable
    @SerializedName("app_version_minor")
    private String appVersionMinor;
    private String device_id;
    private String region;
    private String access;
    private String os_version;
    private String device_model;
    private String app_name;
    private String vendor_id;
    private String carrier;
    private int scene;
    private int event_sampling_version;
    private int sdk_version;
    private String model_display_name;
    private String display_name;
    private String device_token;
    private String channel;
    private String app_region;
    private int auth_status;
    private String user_agent;
    private String idfa;
    private String install_id;
    private String os;
    private String tz_name;
    private int tz_offset;
    private String app_language;
    private String carrier_region;
    private boolean is_upgrade_user;
    private String mcc_mnc;
    private String aid;
    @SerializedName("package")
    private String package_name;
    private boolean is_jailbroken;
    private String language;
    private String cdid;
    private String app_version;
    private String resolution;
    private int timezone;
    @SerializedName("custom")
    private AppLogCustomData appLogCustomData;

    public int getEventSamplingVersion() {
        return event_sampling_version;
    }
    public void setEventSamplingVersion(int event_sampling_version) {
        this.event_sampling_version = event_sampling_version;
    }
    public String getDeviceId() {
        return device_id;
    }

    public void setDeviceId(String device_id) {
        this.device_id = device_id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getOsVersion() {
        return os_version;
    }

    public void setOsVersion(String os_version) {
        this.os_version = os_version;
    }

    public String getDeviceModel() {
        return device_model;
    }

    public void setDeviceModel(String device_model) {
        this.device_model = device_model;
    }

    public String getAppName() {
        return app_name;
    }

    public void setAppName(String app_name) {
        this.app_name = app_name;
    }

    public String getVendorId() {
        return vendor_id;
    }

    public void setVendorId(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int getSdkVersion() {
        return sdk_version;
    }

    public void setSdkVersion(int sdk_version) {
        this.sdk_version = sdk_version;
    }

    public String getModeldisplay_name() {
        return model_display_name;
    }

    public void setModelDisplayName(String model_display_name) {
        this.model_display_name = model_display_name;
    }

    public String getDisplayName() {
        return display_name;
    }

    public void setDisplayName(String display_name) {
        this.display_name = display_name;
    }

    public String getDeviceToken() {
        return device_token;
    }

    public void setDeviceToken(String device_token) {
        this.device_token = device_token;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAppRegion() {
        return app_region;
    }

    public void setAppRegion(String app_region) {
        this.app_region = app_region;
    }

    public int getAuthStatus() {
        return auth_status;
    }

    public void setAuthStatus(int auth_status) {
        this.auth_status = auth_status;
    }

    public String getUserAgent() {
        return user_agent;
    }

    public void setUserAgent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getIdfa() {
        return idfa;
    }

    public void setIdfa(String idfa) {
        this.idfa = idfa;
    }

    public String getInstallId() {
        return install_id;
    }

    public void setInstallId(String install_id) {
        this.install_id = install_id;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getTzName() {
        return tz_name;
    }

    public void setTzName(String tz_name) {
        this.tz_name = tz_name;
    }

    public int getTzOffset() {
        return tz_offset;
    }

    public void setTzOffset(int tz_offset) {
        this.tz_offset = tz_offset;
    }

    public String getAppLanguage() {
        return app_language;
    }

    public void setAppLanguage(String app_language) {
        this.app_language = app_language;
    }

    public String getCarrierRegion() {
        return carrier_region;
    }

    public void setCarrierRegion(String carrier_region) {
        this.carrier_region = carrier_region;
    }

    public boolean isIsUpgradeUser() {
        return is_upgrade_user;
    }

    public void setIsUpgradeUser(boolean is_upgrade_user) {
        this.is_upgrade_user = is_upgrade_user;
    }

    public String getMccMnc() {
        return mcc_mnc;
    }

    public void setMccMnc(String mcc_mnc) {
        this.mcc_mnc = mcc_mnc;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPackageName() {
        return package_name;
    }

    public void setPackageName(String package_name) {
        this.package_name = package_name;
    }

    public boolean isIsJailbroken() {
        return is_jailbroken;
    }

    public void setIsJailbroken(boolean is_jailbroken) {
        this.is_jailbroken = is_jailbroken;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCdid() {
        return cdid;
    }

    public void setCdid(String cdid) {
        this.cdid = cdid;
    }

    public String getAppVersion() {
        return app_version;
    }

    public void setAppVersion(String app_version) {
        this.app_version = app_version;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public AppLogCustomData getAppLogCustomData() {
        return appLogCustomData;
    }

    public void setAppLogCustomData(AppLogCustomData appLogCustomData) {
        this.appLogCustomData = appLogCustomData;
    }

    public static class AppLogCustomData {
        private String app_region;
        private String earphone_status;
        private String web_ua;
        private int is_kids_mode;
        private int is_pad;
        private int filter_warn;
        private int user_period;
        private int user_mode;
        private String app_language;
        private String build_number;

        public String getAppRegion() {
            return app_region;
        }

        public void setAppRegion(String app_region) {
            this.app_region = app_region;
        }

        public String getEarphoneStatus() {
            return earphone_status;
        }

        public void setEarphoneStatus(String earphone_status) {
            this.earphone_status = earphone_status;
        }

        public String getWebUa() {
            return web_ua;
        }

        public void setWebUa(String web_ua) {
            this.web_ua = web_ua;
        }

        public int getIsKidsMode() {
            return is_kids_mode;
        }

        public void setIsKidsMode(int is_kids_mode) {
            this.is_kids_mode = is_kids_mode;
        }

        public int getIsPad() {
            return is_pad;
        }

        public void setIsPad(int is_pad) {
            this.is_pad = is_pad;
        }

        public int getFilterWarn() {
            return filter_warn;
        }

        public void setFilterWarn(int filter_warn) {
            this.filter_warn = filter_warn;
        }

        public int getUserPeriod() {
            return user_period;
        }

        public void setUserPeriod(int user_period) {
            this.user_period = user_period;
        }

        public int getUserMode() {
            return user_mode;
        }

        public void setUserMode(int user_mode) {
            this.user_mode = user_mode;
        }

        public String getAppLanguage() {
            return app_language;
        }

        public void setAppLanguage(String app_language) {
            this.app_language = app_language;
        }

        public String getBuildNumber() {
            return build_number;
        }

        public void setBuildNumber(String build_number) {
            this.build_number = build_number;
        }
    }
}

