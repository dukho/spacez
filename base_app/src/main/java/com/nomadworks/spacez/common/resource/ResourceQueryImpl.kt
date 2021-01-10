package com.nomadworks.spacez.common.resource

import android.content.Context
import android.provider.Settings
import com.nomadworks.spacez.common.BuildConfig
import com.nomadworks.spacez.common.config.AppConfig

class ResourceQueryImpl(
    private val context: Context, private val appConfig: AppConfig,
    private val versionName: String,
    private val versionCode: String
) : ResourceQuery {
    private val releaseConfig = if (BuildConfig.DEBUG) "DEBUG" else "RELEASE"

    override fun getString(resId: Int): String = context.getString(resId)
    override fun getString(resId: Int, param: String): String = getString(resId).format(param)
    override fun getStringArray(resId: Int): Array<String> = context.resources.getStringArray(resId)
    override fun getQuantityString(resId: Int, count: Int, param: String) =
        context.resources.getQuantityString(resId, count, param)

    override fun getDeviceId(): String = context.getDeviceId()
    override fun getVersionInfo(): String =
        "Version $versionName (build $versionCode) - $releaseConfig"

    override fun getVersionName(): String = versionName
    override fun getVersionCode(): String = versionCode

    private fun Context.getDeviceId() =
        Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)
}