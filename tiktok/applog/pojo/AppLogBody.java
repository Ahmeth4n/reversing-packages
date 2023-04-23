public class AppLogBody {
    private String magic_tag;
    @SerializedName("iv")
    private String iv_key;
    @SerializedName("key")
    private String aes_key;
    @SerializedName("time_sync")
    private HashMap<String,Object> event_log;
    private AppLogHeader header;
    private Integer event_sampling;
    @SerializedName("event_v3")
    private List<AppEventV3> event_log_arr;

    @Nullable
    @SerializedName("launch")
    private List<LaunchAppLog> launch;

    @Nullable
    @SerializedName("app_perf")
    private List<AppPerfAppLog> app_perf;

    @Nullable
    @SerializedName("event")
    private List<AppEventV1> event;


    public static class Builder{
        private String magic_tag = "ss_app_log";
        @SerializedName("iv")
        private String iv_key;
        @SerializedName("key")
        private String aes_key;
        private HashMap<String,Object> event_log;
        private List<AppEventV3> event_log_arr;
        private final AppLogHeader header;
        @Nullable
        @SerializedName("launch")
        private List<LaunchAppLog> launch;

        @Nullable
        @SerializedName("app_perf")
        private List<AppPerfAppLog> app_perf;

        @Nullable
        @SerializedName("event")
        private List<AppEventV1> event;

        private Integer event_sampling;
        public Builder(String magic_tag,  AppLogHeader header) {
            this.magic_tag = magic_tag;
            this.header = header;
        }
        public Builder launch(List<LaunchAppLog> value){
            this.launch = value;
            return this;
        }
        public Builder app_perf(List<AppPerfAppLog> value){
            this.app_perf = value;
            return this;
        }
        public Builder event(List<AppEventV1> value){
            this.event = value;
            return this;
        }
        public Builder iv_key(String value){
            iv_key = value;
            return this;
        }
        public Builder event_log_arr(List<AppEventV3> value){
            event_log_arr = value;
            return this;
        }
        public Builder aes_key(String value){
            aes_key = value;
            return this;
        }
        public Builder event_log(HashMap<String,Object> value){
            event_log = value;
            return this;
        }
        public Builder event_sampling(int value){
            event_sampling = value;
            return this;
        }

        public Builder(String magic_tag,String iv_key, String aes_key, AppLogHeader header) {
            this.iv_key = iv_key;
            this.aes_key = aes_key;
            this.header = header;
            this.magic_tag = magic_tag;
        }
        public AppLogBody build() {
            return new AppLogBody(this);
        }
    }
    private AppLogBody (Builder builder) {
        iv_key = builder.iv_key;
        aes_key = builder.aes_key;
        header = builder.header;
        event_sampling = builder.event_sampling;
        event_log = builder.event_log;
        event_log_arr = builder.event_log_arr;
        magic_tag = builder.magic_tag;
        app_perf = builder.app_perf;
        launch = builder.launch;
        event = builder.event;
    }
}
