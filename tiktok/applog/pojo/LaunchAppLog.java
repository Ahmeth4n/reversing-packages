public class LaunchAppLog {
    @SerializedName("ab_sdk_version")
    private String abSdkVersion;
    @SerializedName("tea_event_index")
    private int teaEventIndex;
    @SerializedName("datetime")
    private String dateTime;
    @SerializedName("session_id")
    private String sessionId;
    @SerializedName("user_id")
    private int userId;
    @SerializedName("local_time_ms")
    private long localTimeMs;
    @SerializedName("is_background")
    private boolean isBackground;

    public LaunchAppLog(String abSdkVersion, int teaEventIndex, String dateTime, String sessionId, int userId, long localTimeMs, boolean isBackground) {
        this.abSdkVersion = abSdkVersion;
        this.teaEventIndex = teaEventIndex;
        this.dateTime = dateTime;
        this.sessionId = sessionId;
        this.userId = userId;
        this.localTimeMs = localTimeMs;
        this.isBackground = isBackground;
    }
}
