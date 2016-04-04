package com.courses.spalah;

/**
 * @author Ievgen Tararaka
 */
public class SampleClass {
    public long publicLong;
    int defaultInt;
    protected String protectedString;
    private boolean privateBoolean;

    public static SampleClass newInstance() {
        return new SampleClass();
    }

    public SampleClass() {
    }

    public SampleClass(long publicLong, int defaultInt, String protectedString, boolean privateBoolean) {
        this.publicLong = publicLong;
        this.defaultInt = defaultInt;
        this.protectedString = protectedString;
        this.privateBoolean = privateBoolean;
    }

    @Deprecated
    private boolean isPrivateBoolean() {
        return privateBoolean;
    }

    public void setPrivateBoolean(boolean privateBoolean) {
        this.privateBoolean = privateBoolean;
    }
}
