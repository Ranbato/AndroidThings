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


import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.serialization.SerialName
import java.io.Serializable

/**
 * 
 *
 * @param cmd 
 * @param email 
 * @param name 
 * @param requiredNewPassword 
 * @param role 
 * @param xPassword 
 * @param permissions 
 */

data class CreateAdmin (

    @SerialName("cmd")
    val cmd: kotlin.String,

    @SerialName("email")
    val email: kotlin.String,

    @SerialName("name")
    val name: kotlin.String,

    @SerialName("required_new_password")
    val requiredNewPassword: kotlin.Boolean,

    @SerialName("role")
    val role: kotlin.String,

    @SerialName("x_password")
    val xPassword: kotlin.String,

    @SerialName("permissions")
    val permissions: kotlin.Array<CreateAdmin.Permissions>

) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 123
    }

    /**
     * 
     *
     * Values: ADOPT,RESTART
     */
    enum class Permissions(val value: kotlin.String) {
        @JsonProperty(value = "API_DEVICE_ADOPT") ADOPT("API_DEVICE_ADOPT"),
        @JsonProperty(value = "API_DEVICE_RESTART") RESTART("API_DEVICE_RESTART");
    }
}

