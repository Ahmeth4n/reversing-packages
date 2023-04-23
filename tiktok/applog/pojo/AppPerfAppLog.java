public class AppPerfAppLog {
    @SerializedName("session_id")
    private String sessionId;
    private String label;
    @SerializedName("local_time")
    private long localTime;
    private String scene;
    private String event;
    @SerializedName("log_type")
    private String logType;

    public AppPerfAppLog(String sessionId) {
        this.sessionId = sessionId;
        this.label = "launch";
        this.localTime = Instant.now().toEpochMilli();
        this.scene = "low_retain";
        this.event = "monitor";
        this.logType = "app_perf";
    }
}
