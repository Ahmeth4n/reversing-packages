public interface EventBuilder {
    List<AppEventV3> getEventList(String[] event_names);
    AppLogHeader getHeader() throws Exception;
}
