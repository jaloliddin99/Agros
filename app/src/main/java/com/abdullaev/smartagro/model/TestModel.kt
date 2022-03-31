package com.abdullaev.smartagro.model

import android.os.Parcel
import android.os.Parcelable

data class TestModel(
    val id: String?,
    val image:Int,
    val title: String?,
    val titleId: String?
):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeString(titleId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TestModel> {
        override fun createFromParcel(parcel: Parcel): TestModel {
            return TestModel(parcel)
        }

        override fun newArray(size: Int): Array<TestModel?> {
            return arrayOfNulls(size)
        }
    }


}