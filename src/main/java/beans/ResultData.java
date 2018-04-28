package beans;

public class ResultData {
    private String id;
    private String mmac;
    private String rate;
    private String time;
    private String lat;
    private String lon;
    private String data_mac;
    private String data_rssi;
    private String data_rssi1;
    private String data_rssi2;
    private String data_tmc;
    private String data_router;
    private String data_range;
    private String data_ts;
    private String data_ds;
    private String data_rssi3;
    private String data_tc;

    @Override
    public String toString() {
        return "ResultData{" +
                "id='" + id + '\'' +
                ", mmac='" + mmac + '\'' +
                ", rate='" + rate + '\'' +
                ", time='" + time + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", data_mac='" + data_mac + '\'' +
                ", data_rssi='" + data_rssi + '\'' +
                ", data_rssi1='" + data_rssi1 + '\'' +
                ", data_rssi2='" + data_rssi2 + '\'' +
                ", data_tmc='" + data_tmc + '\'' +
                ", data_router='" + data_router + '\'' +
                ", data_range='" + data_range + '\'' +
                ", data_ts='" + data_ts + '\'' +
                ", data_ds='" + data_ds + '\'' +
                ", data_rssi3='" + data_rssi3 + '\'' +
                ", data_tc='" + data_tc + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMmac() {
        return mmac;
    }

    public void setMmac(String mmac) {
        this.mmac = mmac;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getData_mac() {
        return data_mac;
    }

    public void setData_mac(String data_mac) {
        this.data_mac = data_mac;
    }

    public String getData_rssi() {
        return data_rssi;
    }

    public void setData_rssi(String data_rssi) {
        this.data_rssi = data_rssi;
    }

    public String getData_rssi1() {
        return data_rssi1;
    }

    public void setData_rssi1(String data_rssi1) {
        this.data_rssi1 = data_rssi1;
    }

    public String getData_rssi2() {
        return data_rssi2;
    }

    public void setData_rssi2(String data_rssi2) {
        this.data_rssi2 = data_rssi2;
    }

    public String getData_tmc() {
        return data_tmc;
    }

    public void setData_tmc(String data_tmc) {
        this.data_tmc = data_tmc;
    }

    public String getData_router() {
        return data_router;
    }

    public void setData_router(String data_router) {
        this.data_router = data_router;
    }

    public String getData_range() {
        return data_range;
    }

    public void setData_range(String data_range) {
        this.data_range = data_range;
    }

    public String getData_ts() {
        return data_ts;
    }

    public void setData_ts(String data_ts) {
        this.data_ts = data_ts;
    }

    public String getData_ds() {
        return data_ds;
    }

    public void setData_ds(String data_ds) {
        this.data_ds = data_ds;
    }

    public String getData_rssi3() {
        return data_rssi3;
    }

    public void setData_rssi3(String data_rssi3) {
        this.data_rssi3 = data_rssi3;
    }

    public String getData_tc() {
        return data_tc;
    }

    public void setData_tc(String data_tc) {
        this.data_tc = data_tc;
    }
}
