package com.example.acer.gunungtertinggidiindonesia;

import android.os.Parcel;
import android.os.Parcelable;

public class Mountain implements Parcelable {
    private String name;
    private String desc;
    private String photo;
    private String tinggi;
    private String lokasi;
    private String kondisi;
    private String tags;
    private String Gmaps;
    private String Gimage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getTinggi() {
        return tinggi;
    }

    public void setTinggi(String tinggi) {
        this.tinggi = tinggi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getGmaps() {
        return Gmaps;
    }

    public void setGmaps(String gmaps) {
        Gmaps = gmaps;
    }

    public String getGimage() {
        return Gimage;
    }

    public void setGimage(String gimage) {
        Gimage = gimage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.photo);
        dest.writeString(this.tinggi);
        dest.writeString(this.lokasi);
        dest.writeString(this.kondisi);
        dest.writeString(this.tags);
        dest.writeString(this.Gmaps);
        dest.writeString(this.Gimage);
    }

    public Mountain() {
    }

    protected Mountain(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.photo = in.readString();
        this.tinggi = in.readString();
        this.lokasi = in.readString();
        this.kondisi = in.readString();
        this.tags = in.readString();
        this.Gmaps = in.readString();
        this.Gimage = in.readString();
    }

    public static final Parcelable.Creator<Mountain> CREATOR = new Parcelable.Creator<Mountain>() {
        @Override
        public Mountain createFromParcel(Parcel source) {
            return new Mountain(source);
        }

        @Override
        public Mountain[] newArray(int size) {
            return new Mountain[0];
        }
    };
}
