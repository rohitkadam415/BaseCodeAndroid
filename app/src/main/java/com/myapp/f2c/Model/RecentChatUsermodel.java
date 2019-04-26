package com.myapp.f2c.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Rohit Kadam
 */
public class RecentChatUsermodel implements Parcelable {
  private String displayname;
  private String avtarimage;
  private long echoes;
  private String userid;
  private long datetime;
  private String lastmessage;

  public RecentChatUsermodel() {
  }

  public RecentChatUsermodel(String displayname, String avtarimage, long echoes,
                             String userid) {
    this.displayname = displayname;
    this.avtarimage = avtarimage;
    this.echoes = echoes;
    this.userid = userid;
  }

  protected RecentChatUsermodel(Parcel in) {
    displayname = in.readString();
    avtarimage = in.readString();
    echoes = in.readLong();
    userid = in.readString();
    lastmessage = in.readString();
    datetime = in.readLong();
  }

  public static final Creator<RecentChatUsermodel> CREATOR = new Creator<RecentChatUsermodel>() {
    @Override
    public RecentChatUsermodel createFromParcel(Parcel in) {
      return new RecentChatUsermodel(in);
    }

    @Override
    public RecentChatUsermodel[] newArray(int size) {
      return new RecentChatUsermodel[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(displayname);
    dest.writeString(avtarimage);
    dest.writeLong(echoes);
    dest.writeString(userid);
    dest.writeString(lastmessage);
    dest.writeLong(datetime);
  }

  public String getDisplayname() {
    return displayname;
  }

  public void setDisplayname(String displayname) {
    this.displayname = displayname;
  }

  public String getAvtarimage() {
    return avtarimage;
  }

  public void setAvtarimage(String avtarimage) {
    this.avtarimage = avtarimage;
  }

  public long getEchoes() {
    return echoes;
  }

  public void setEchoes(long echoes) {
    this.echoes = echoes;
  }

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public long getDatetime() {
    return datetime;
  }

  public void setDatetime(long datetime) {
    this.datetime = datetime;
  }

  public String getLastmessage() {
    return lastmessage;
  }

  public void setLastmessage(String lastmessage) {
    this.lastmessage = lastmessage;
  }
}
