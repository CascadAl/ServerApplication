package com.example.serverapplication.domain.entity.response

import android.os.Parcelable
import com.example.serverapplication.common.ResponseStatus
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
sealed class Response: Parcelable {
    @Parcelize
    data class Success<T>(
        val status: String = ResponseStatus.OK._name,
        val data: @RawValue T
    ): Response(), Parcelable

    @Parcelize
    data class Error(
        val status: String = ResponseStatus.ERROR._name,
        val message: String
    ): Response(), Parcelable
}