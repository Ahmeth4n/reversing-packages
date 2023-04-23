public class AppEventV1 {
    private String category;
    private String label;
    @SerializedName("local_time_ms")
    private String localTimeMs;
    @SerializedName("user_id")
    private String userId;
    @SerializedName("ab_sdk_version")
    private String abSdkVersion;
    private String tag;
    private String nt;
    @SerializedName("tea_event_index")
    private String teaEventIndex;
    @SerializedName("datetime")
    private String dateTime;
    @SerializedName("session_id")
    private String sessionId;

    public AppEventV1(String label, String localTimeMs, String abSdkVersion, String tag, String teaEventIndex, String dateTime, String sessionId) {
        this.category = "event_v1";
        this.label = label;
        this.localTimeMs = localTimeMs;
        this.userId = "0";
        this.abSdkVersion = abSdkVersion;
        this.tag = tag;
        this.nt = "4";
        this.teaEventIndex = teaEventIndex;
        this.dateTime = dateTime;
        this.sessionId = sessionId;
    }
}
