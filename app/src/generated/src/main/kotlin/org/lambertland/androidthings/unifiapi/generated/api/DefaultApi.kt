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

package org.lambertland.androidthings.unifiapi.generated.api

import java.io.IOException
import okhttp3.OkHttpClient

import org.lambertland.androidthings.unifiapi.generated.model.Login
import org.lambertland.androidthings.unifiapi.generated.model.LoginResponse
import org.lambertland.androidthings.unifiapi.generated.model.Sites
import org.lambertland.androidthings.unifiapi.generated.model.WlanConf
import org.lambertland.androidthings.unifiapi.generated.model.WlanConfs
import org.lambertland.androidthings.unifiapi.generated.model.WlanGroups

import com.squareup.moshi.Json

import org.lambertland.androidthings.unifiapi.generated.infrastructure.ApiClient
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ApiResponse
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ClientException
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ClientError
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ServerException
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ServerError
import org.lambertland.androidthings.unifiapi.generated.infrastructure.MultiValueMap
import org.lambertland.androidthings.unifiapi.generated.infrastructure.PartConfig
import org.lambertland.androidthings.unifiapi.generated.infrastructure.RequestConfig
import org.lambertland.androidthings.unifiapi.generated.infrastructure.RequestMethod
import org.lambertland.androidthings.unifiapi.generated.infrastructure.ResponseType
import org.lambertland.androidthings.unifiapi.generated.infrastructure.Success
import org.lambertland.androidthings.unifiapi.generated.infrastructure.toMultiValue

class DefaultApi(basePath: kotlin.String = defaultBasePath, client: OkHttpClient = ApiClient.defaultClient) : ApiClient(basePath, client) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty(ApiClient.baseUrlKey, "https://demo.ubnt.com:8443/api")
        }
    }

    /**
     * Lists all sites of the authenticated user
     * 
     * @return Sites
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun listSites() : Sites {
        val localVarResponse = listSitesWithHttpInfo()

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as Sites
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Lists all sites of the authenticated user
     * 
     * @return ApiResponse<Sites?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun listSitesWithHttpInfo() : ApiResponse<Sites?> {
        val localVariableConfig = listSitesRequestConfig()

        return request<Unit, Sites>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation listSites
     *
     * @return RequestConfig
     */
    fun listSitesRequestConfig() : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/self/sites",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Lists the specified WLAN configuation
     * 
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @return WlanConfs
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun listWlanConfig(site: kotlin.String, confId: kotlin.String) : WlanConfs {
        val localVarResponse = listWlanConfigWithHttpInfo(site = site, confId = confId)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as WlanConfs
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Lists the specified WLAN configuation
     * 
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @return ApiResponse<WlanConfs?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun listWlanConfigWithHttpInfo(site: kotlin.String, confId: kotlin.String) : ApiResponse<WlanConfs?> {
        val localVariableConfig = listWlanConfigRequestConfig(site = site, confId = confId)

        return request<Unit, WlanConfs>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation listWlanConfig
     *
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @return RequestConfig
     */
    fun listWlanConfigRequestConfig(site: kotlin.String, confId: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/s/{site}/rest/wlanconf/{confId}".replace("{"+"site"+"}", site.toString()).replace("{"+"confId"+"}", confId.toString()),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Lists all WLAN configurations
     * 
     * @param site Name of the site
     * @return WlanConfs
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun listWlanConfigs(site: kotlin.String) : WlanConfs {
        val localVarResponse = listWlanConfigsWithHttpInfo(site = site)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as WlanConfs
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Lists all WLAN configurations
     * 
     * @param site Name of the site
     * @return ApiResponse<WlanConfs?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun listWlanConfigsWithHttpInfo(site: kotlin.String) : ApiResponse<WlanConfs?> {
        val localVariableConfig = listWlanConfigsRequestConfig(site = site)

        return request<Unit, WlanConfs>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation listWlanConfigs
     *
     * @param site Name of the site
     * @return RequestConfig
     */
    fun listWlanConfigsRequestConfig(site: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/s/{site}/rest/wlanconf".replace("{"+"site"+"}", site.toString()),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * List all WLAN group
     * 
     * @param site Name of the site
     * @return WlanGroups
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun listWlanGroups(site: kotlin.String) : WlanGroups {
        val localVarResponse = listWlanGroupsWithHttpInfo(site = site)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as WlanGroups
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * List all WLAN group
     * 
     * @param site Name of the site
     * @return ApiResponse<WlanGroups?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun listWlanGroupsWithHttpInfo(site: kotlin.String) : ApiResponse<WlanGroups?> {
        val localVariableConfig = listWlanGroupsRequestConfig(site = site)

        return request<Unit, WlanGroups>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation listWlanGroups
     *
     * @param site Name of the site
     * @return RequestConfig
     */
    fun listWlanGroupsRequestConfig(site: kotlin.String) : RequestConfig<Unit> {
        val localVariableBody = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.GET,
            path = "/s/{site}/rest/wlangroup".replace("{"+"site"+"}", site.toString()),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Login to controller
     * 
     * @param login Username and password to authenticate. Returns auth cookie (optional)
     * @return LoginResponse
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun login(login: Login? = null) : LoginResponse {
        val localVarResponse = loginWithHttpInfo(login = login)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as LoginResponse
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Login to controller
     * 
     * @param login Username and password to authenticate. Returns auth cookie (optional)
     * @return ApiResponse<LoginResponse?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun loginWithHttpInfo(login: Login?) : ApiResponse<LoginResponse?> {
        val localVariableConfig = loginRequestConfig(login = login)

        return request<Login, LoginResponse>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation login
     *
     * @param login Username and password to authenticate. Returns auth cookie (optional)
     * @return RequestConfig
     */
    fun loginRequestConfig(login: Login?) : RequestConfig<Login> {
        val localVariableBody = login
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.POST,
            path = "/login",
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

    /**
     * Update the specified WLAN configuration
     * 
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @param wlanConf WLAN configuration
     * @return WlanConfs
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     * @throws UnsupportedOperationException If the API returns an informational or redirection response
     * @throws ClientException If the API returns a client error response
     * @throws ServerException If the API returns a server error response
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class, UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun updateWlanConfig(site: kotlin.String, confId: kotlin.String, wlanConf: WlanConf) : WlanConfs {
        val localVarResponse = updateWlanConfigWithHttpInfo(site = site, confId = confId, wlanConf = wlanConf)

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as WlanConfs
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
     * Update the specified WLAN configuration
     * 
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @param wlanConf WLAN configuration
     * @return ApiResponse<WlanConfs?>
     * @throws IllegalStateException If the request is not correctly configured
     * @throws IOException Rethrows the OkHttp execute method exception
     */
    @Suppress("UNCHECKED_CAST")
    @Throws(IllegalStateException::class, IOException::class)
    fun updateWlanConfigWithHttpInfo(site: kotlin.String, confId: kotlin.String, wlanConf: WlanConf) : ApiResponse<WlanConfs?> {
        val localVariableConfig = updateWlanConfigRequestConfig(site = site, confId = confId, wlanConf = wlanConf)

        return request<WlanConf, WlanConfs>(
            localVariableConfig
        )
    }

    /**
     * To obtain the request config of the operation updateWlanConfig
     *
     * @param site Name of the site
     * @param confId Id of the WLAN configuration
     * @param wlanConf WLAN configuration
     * @return RequestConfig
     */
    fun updateWlanConfigRequestConfig(site: kotlin.String, confId: kotlin.String, wlanConf: WlanConf) : RequestConfig<WlanConf> {
        val localVariableBody = wlanConf
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "application/json"
        localVariableHeaders["Accept"] = "application/json"

        return RequestConfig(
            method = RequestMethod.PUT,
            path = "/s/{site}/rest/wlanconf/{confId}".replace("{"+"site"+"}", site.toString()).replace("{"+"confId"+"}", confId.toString()),
            query = localVariableQuery,
            headers = localVariableHeaders,
            body = localVariableBody
        )
    }

}
