package com.delalama.backingtracks.service.fx;

public class Attributes {
    private String codec = null;

    private long duration = -1;

    private Integer bitRate = null;

    private Integer samplingRate = null;

    private Integer channels = null;

    private Integer volume = null;

    private Integer seekTime = null;

    public Attributes(final String format, final String codec, final Integer samplingRate,
                      final Integer channels, final Integer bitRate, final Integer volume) {
        setBitRate(bitRate);
        setChannels(channels);
        setSamplingRate(samplingRate);
        setCodec(codec);
        setVolume(volume);
        setFormat(format);
    }

    public Attributes(final String format, final String codec, final Integer samplingRate,
                      final Integer channels, final Integer bitRate) {
        this(format, codec, samplingRate, channels, bitRate, null);
    }

    public Attributes(final String format, final String codec, final Integer samplingRate,
                      final Integer channels) {
        this(format, codec, samplingRate, channels, null, null);
    }

    public Attributes() {

    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getBitRate() {
        return bitRate;
    }

    public void setBitRate(Integer bitRate) {
        this.bitRate = bitRate;
    }

    public Integer getSamplingRate() {
        return samplingRate;
    }

    public void setSamplingRate(Integer samplingRate) {
        this.samplingRate = samplingRate;
    }

    public Integer getChannels() {
        return channels;
    }

    public void setChannels(Integer channels) {
        this.channels = channels;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getSeekTime() {
        return seekTime;
    }

    public void setSeekTime(Integer seekTime) {
        this.seekTime = seekTime;
    }

    private String format = null;

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return String.format(
                "%s format=%s, codec=%s, bitrate=%s, samplingrate=%s, duration=%s, channels=%s , volume=%s seekTime=%s",
                getClass().getName(), format, codec, bitRate, samplingRate, duration, channels, volume, seekTime);
    }

}
