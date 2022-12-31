# DefaultApi

All URIs are relative to *https://demo.ubnt.com:8443/api*

Method | HTTP request | Description
------------- | ------------- | -------------
[**listSites**](DefaultApi.md#listSites) | **GET** /self/sites | Lists all sites of the authenticated user
[**listWlanConfig**](DefaultApi.md#listWlanConfig) | **GET** /s/{site}/rest/wlanconf/{confId} | Lists the specified WLAN configuation
[**listWlanConfigs**](DefaultApi.md#listWlanConfigs) | **GET** /s/{site}/rest/wlanconf | Lists all WLAN configurations
[**listWlanGroups**](DefaultApi.md#listWlanGroups) | **GET** /s/{site}/rest/wlangroup | List all WLAN group
[**login**](DefaultApi.md#login) | **POST** /login | Login to controller
[**updateWlanConfig**](DefaultApi.md#updateWlanConfig) | **PUT** /s/{site}/rest/wlanconf/{confId} | Update the specified WLAN configuration


<a name="listSites"></a>
# **listSites**
> Sites listSites()

Lists all sites of the authenticated user

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
try {
    val result : Sites = apiInstance.listSites()
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#listSites")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#listSites")
    e.printStackTrace()
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**Sites**](Sites.md)

### Authorization


Configure CSRF_Token:
    ApiClient.apiKey["csrf_token"] = ""
    ApiClient.apiKeyPrefix["csrf_token"] = ""
Configure Unifises:
    ApiClient.apiKey["unifises"] = ""
    ApiClient.apiKeyPrefix["unifises"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listWlanConfig"></a>
# **listWlanConfig**
> WlanConfs listWlanConfig(site, confId)

Lists the specified WLAN configuation

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
val site : kotlin.String = site_example // kotlin.String | Name of the site
val confId : kotlin.String = confId_example // kotlin.String | Id of the WLAN configuration
try {
    val result : WlanConfs = apiInstance.listWlanConfig(site, confId)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#listWlanConfig")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#listWlanConfig")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **site** | **kotlin.String**| Name of the site |
 **confId** | **kotlin.String**| Id of the WLAN configuration |

### Return type

[**WlanConfs**](WlanConfs.md)

### Authorization


Configure CSRF_Token:
    ApiClient.apiKey["csrf_token"] = ""
    ApiClient.apiKeyPrefix["csrf_token"] = ""
Configure Unifises:
    ApiClient.apiKey["unifises"] = ""
    ApiClient.apiKeyPrefix["unifises"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listWlanConfigs"></a>
# **listWlanConfigs**
> WlanConfs listWlanConfigs(site)

Lists all WLAN configurations

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
val site : kotlin.String = site_example // kotlin.String | Name of the site
try {
    val result : WlanConfs = apiInstance.listWlanConfigs(site)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#listWlanConfigs")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#listWlanConfigs")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **site** | **kotlin.String**| Name of the site |

### Return type

[**WlanConfs**](WlanConfs.md)

### Authorization


Configure CSRF_Token:
    ApiClient.apiKey["csrf_token"] = ""
    ApiClient.apiKeyPrefix["csrf_token"] = ""
Configure Unifises:
    ApiClient.apiKey["unifises"] = ""
    ApiClient.apiKeyPrefix["unifises"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listWlanGroups"></a>
# **listWlanGroups**
> WlanGroups listWlanGroups(site)

List all WLAN group

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
val site : kotlin.String = site_example // kotlin.String | Name of the site
try {
    val result : WlanGroups = apiInstance.listWlanGroups(site)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#listWlanGroups")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#listWlanGroups")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **site** | **kotlin.String**| Name of the site |

### Return type

[**WlanGroups**](WlanGroups.md)

### Authorization


Configure CSRF_Token:
    ApiClient.apiKey["csrf_token"] = ""
    ApiClient.apiKeyPrefix["csrf_token"] = ""
Configure Unifises:
    ApiClient.apiKey["unifises"] = ""
    ApiClient.apiKeyPrefix["unifises"] = ""

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="login"></a>
# **login**
> LoginResponse login(login)

Login to controller

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
val login : Login =  // Login | Username and password to authenticate. Returns auth cookie
try {
    val result : LoginResponse = apiInstance.login(login)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#login")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#login")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **login** | [**Login**](Login.md)| Username and password to authenticate. Returns auth cookie | [optional]

### Return type

[**LoginResponse**](LoginResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateWlanConfig"></a>
# **updateWlanConfig**
> WlanConfs updateWlanConfig(site, confId, wlanConf)

Update the specified WLAN configuration

### Example
```kotlin
// Import classes:
//import org.lambertland.androidthings.unifiapi.generated.infrastructure.*
//import org.lambertland.androidthings.unifiapi.generated.model.*

val apiInstance = DefaultApi()
val site : kotlin.String = site_example // kotlin.String | Name of the site
val confId : kotlin.String = confId_example // kotlin.String | Id of the WLAN configuration
val wlanConf : WlanConf =  // WlanConf | WLAN configuration
try {
    val result : WlanConfs = apiInstance.updateWlanConfig(site, confId, wlanConf)
    println(result)
} catch (e: ClientException) {
    println("4xx response calling DefaultApi#updateWlanConfig")
    e.printStackTrace()
} catch (e: ServerException) {
    println("5xx response calling DefaultApi#updateWlanConfig")
    e.printStackTrace()
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **site** | **kotlin.String**| Name of the site |
 **confId** | **kotlin.String**| Id of the WLAN configuration |
 **wlanConf** | [**WlanConf**](WlanConf.md)| WLAN configuration |

### Return type

[**WlanConfs**](WlanConfs.md)

### Authorization


Configure CSRF_Token:
    ApiClient.apiKey["csrf_token"] = ""
    ApiClient.apiKeyPrefix["csrf_token"] = ""
Configure Unifises:
    ApiClient.apiKey["unifises"] = ""
    ApiClient.apiKeyPrefix["unifises"] = ""

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

