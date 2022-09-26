package com.example.gymmanagementapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Plan implements Parcelable {
    private Training training;
    private int minutes;
    private String day;

    @Override
    public String toString() {
        return "Plan{" +
                "training=" + training +
                ", minutes=" + minutes +
                ", day='" + day + '\'' +
                ", isaccomplished=" + isaccomplished +
                '}';
    }

    private boolean isaccomplished;

    public Plan(Training training, int minutes, String day, boolean isaccomplished) {
        this.training = training;
        this.minutes = minutes;
        this.day = day;
        this.isaccomplished = isaccomplished;
    }

    protected Plan(Parcel in) {
        training = in.readParcelable(Training.class.getClassLoader());
        minutes = in.readInt();
        day = in.readString();
        isaccomplished = in.readByte() != 0;
    }

    public static final Creator<Plan> CREATOR = new Creator<Plan>() {
        @Override
        public Plan createFromParcel(Parcel in) {
            return new Plan(in);
        }

        @Override
        public Plan[] newArray(int size) {
            return new Plan[size];
        }
    };

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isIsaccomplished() {
        return isaccomplished;
    }

    public void setIsaccomplished(boolean isaccomplished) {
        this.isaccomplished = isaccomplished;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(training, i);
        parcel.writeInt(minutes);
        parcel.writeString(day);
        parcel.writeByte((byte) (isaccomplished ? 1 : 0));
    }
}
