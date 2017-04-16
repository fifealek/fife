package com.fife.lamda;

/**
 * Created by C5248281 on 4/16/2017.
 */
public class ContenerData {
   final private Integer time;
   final private String timeString;

   public ContenerData(Integer time,String timeString) {
       this.time=time;
       this.timeString=timeString;
   }

    public Integer getTime() {
        return time;
    }

    public String getTimeString() {
        return timeString;
    }

    @Override
    public String toString() {
        return "ContenerData{" +
                "time=" + time +
                ", timeString='" + timeString + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContenerData that = (ContenerData) o;

        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        return timeString != null ? timeString.equals(that.timeString) : that.timeString == null;
    }

    @Override
    public int hashCode() {
        int result = time != null ? time.hashCode() : 0;
        result = 31 * result + (timeString != null ? timeString.hashCode() : 0);
        return result;
    }
}
