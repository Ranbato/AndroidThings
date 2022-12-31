/**
 * Unifi Controller API spec
 *
 * Reverse engineered API for Ubiquiti Unifi Controller
 *
 * The version of the OpenAPI document: 0.1.0
 * Contact: github@container42.de
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport"
)

package org.lambertland.kotlin.unifiapi.generated.model


import kotlinx.serialization.SerialName

/**
 * 
 *
 * @param adminId 
 * @param deviceId 
 * @param email 
 * @param name 
 * @param emailAlertEnabled 
 * @param emailAlertGroupingDelay 
 * @param emailAlertGroupingEnabled 
 * @param htmlEmailEnabled 
 * @param isLocal 
 * @param isProfessionalInstaller 
 * @param isSuper 
 * @param lastSiteName 
 * @param requiresNewPassword 
 * @param superSitePermissions 
 * @param uiSettings 
 */

data class Admin (

    @SerialName("admin_id")
    val adminId: kotlin.String,

    @SerialName("device_id")
    val deviceId: kotlin.String,

    @SerialName("email")
    val email: kotlin.String,

    @SerialName("name")
    val name: kotlin.String,

    @SerialName("email_alert_enabled")
    val emailAlertEnabled: kotlin.Boolean? = null,

    @SerialName("email_alert_grouping_delay")
    val emailAlertGroupingDelay: kotlin.Int? = null,

    @SerialName("email_alert_grouping_enabled")
    val emailAlertGroupingEnabled: kotlin.Boolean? = null,

    @SerialName("html_email_enabled")
    val htmlEmailEnabled: kotlin.Boolean? = null,

    @SerialName("is_local")
    val isLocal: kotlin.Boolean? = null,

    @SerialName("is_professional_installer")
    val isProfessionalInstaller: kotlin.Boolean? = null,

    @SerialName("is_super")
    val isSuper: kotlin.Boolean? = null,

    @SerialName("last_site_name")
    val lastSiteName: kotlin.String? = null,

    @SerialName("requires_new_password")
    val requiresNewPassword: kotlin.Boolean? = null,

    @SerialName("super_site_permissions")
    val superSitePermissions: kotlin.Any? = null,

    @SerialName("ui_settings")
    val uiSettings: kotlin.Any? = null

)