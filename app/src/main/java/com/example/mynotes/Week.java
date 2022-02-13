package com.example.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

public class Week implements Parcelable {
    private int index;

    public Week(int i) {
        index = i;
    }

    protected Week(Parcel in) {
        index = in.readInt();

    }

    public static final Creator<Week> CREATOR = new Creator<Week>() {
        @Override
        public Week createFromParcel(Parcel in) {
            return new Week(in);
        }

        @Override
        public Week[] newArray(int size) {
            return new Week[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
