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
 * @param attrHiddenId 
 * @param attrNoDelete 
 * @param desc 
 * @param role 
 */

data class Site (

    @Json(name = "_id")
    var id: kotlin.String,

    @Json(name = "name")
    var name: kotlin.String,

    @Json(name = "attr_hidden_id")
    var attrHiddenId: kotlin.String? = null,

    @Json(name = "attr_no_delete")
    var attrNoDelete: kotlin.Boolean? = null,

    @Json(name = "desc")
    var desc: kotlin.String? = null,

    @Json(name = "role")
    var role: kotlin.String? = null

)

