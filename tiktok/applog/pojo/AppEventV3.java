public class AppEventV3 {
    private String ab_sdk_version;
    private String datetime;
    private String event;
    private String session_id;
    private String user_id;
    private int nt;
    private HashMap<String,Object> params;

    public String getAbSdkVersion() {
        return ab_sdk_version;
    }

    public void setAbSdkVersion(String ab_sdk_version) {
        this.ab_sdk_version = ab_sdk_version;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String user_id) {
        this.user_id = user_id;
    }

    public int getNt() {
        return nt;
    }

    public void setNt(int nt) {
        this.nt = nt;
    }

    public HashMap<String, Object> getParams() {
        return params;
    }

    public void setParams(HashMap<String, Object> params) {
        this.params = params;
    }

    public AppEventV3(String ab_sdk_version, String datetime, String event, String session_id, String user_id, int nt, HashMap<String,Object> params) {
        this.ab_sdk_version = ab_sdk_version;
        this.datetime = datetime;
        this.event = event;
        this.session_id = session_id;
        this.user_id = user_id;
        this.nt = nt;
        this.params = params;
    }

}
