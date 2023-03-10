/**
 * Unifi Controller API spec
 *
 * Reverse engineered API for Ubiquiti Unifi Controller
 *
 * The version of the OpenAPI document: 0.0.1
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

package org.lambertland.androidthings.unifiapi.generated.model


import com.squareup.moshi.Json

/**
 * 
 *
 * @param id 
 * @param name 
 * @param siteId 
 */

data class WlanGroup (

    @Json(name = "_id")
    var id: kotlin.String,

    @Json(name = "name")
    var name: kotlin.String,

    @Json(name = "site_id")
    var siteId: kotlin.String

)

