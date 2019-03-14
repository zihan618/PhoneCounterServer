package com.phonecounter.server.model;

import java.util.Date;
import java.util.Objects;

public class DailyRecord {
    private Long id, timeSpent;
    private Date timestamp;
    private String packageName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DailyRecord that = (DailyRecord) o;
        return Objects.equals(timeSpent, that.timeSpent) &&
                Objects.equals(timestamp, that.timestamp) &&
                Objects.equals(packageName, that.packageName);
    }

    public boolean subEquals(DailyRecord o) {
        return o.getPackageName().equals(packageName) && o.getTimestamp().equals(timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSpent, timestamp, packageName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Long getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(Long timeSpent) {
        this.timeSpent = timeSpent;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
