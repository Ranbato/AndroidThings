# org.lambertland.androidthings.unifiapi.generated - Kotlin client library for Unifi Controller API spec

## Requires

* Kotlin 1.4.30
* Gradle 6.8.3

## Build

First, create the gradle wrapper script:

```
gradle wrapper
```

Then, run:

```
./gradlew check assemble
```

This runs all tests and packages the library.

## Features/Implementation Notes

* Supports JSON inputs/outputs, File inputs, and Form inputs.
* Supports collection formats for query parameters: csv, tsv, ssv, pipes.
* Some Kotlin and Java types are fully qualified to avoid conflicts with types defined in OpenAPI definitions.
* Implementation of ApiClient is intended to reduce method counts, specifically to benefit Android targets.

<a name="documentation-for-api-endpoints"></a>
## Documentation for API Endpoints

All URIs are relative to *https://demo.ubnt.com:8443/api*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*DefaultApi* | [**listSites**](docs/DefaultApi.md#listsites) | **GET** /self/sites | Lists all sites of the authenticated user
*DefaultApi* | [**listWlanConfig**](docs/DefaultApi.md#listwlanconfig) | **GET** /s/{site}/rest/wlanconf/{confId} | Lists the specified WLAN configuation
*DefaultApi* | [**listWlanConfigs**](docs/DefaultApi.md#listwlanconfigs) | **GET** /s/{site}/rest/wlanconf | Lists all WLAN configurations
*DefaultApi* | [**listWlanGroups**](docs/DefaultApi.md#listwlangroups) | **GET** /s/{site}/rest/wlangroup | List all WLAN group
*DefaultApi* | [**login**](docs/DefaultApi.md#login) | **POST** /login | Login to controller
*DefaultApi* | [**updateWlanConfig**](docs/DefaultApi.md#updatewlanconfig) | **PUT** /s/{site}/rest/wlanconf/{confId} | Update the specified WLAN configuration


<a name="documentation-for-models"></a>
## Documentation for Models

 - [org.lambertland.androidthings.unifiapi.generated.model.Admin](docs/Admin.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.CreateAdmin](docs/CreateAdmin.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.Login](docs/Login.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.LoginResponse](docs/LoginResponse.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.Meta](docs/Meta.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.Site](docs/Site.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.Sites](docs/Sites.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.WlanConf](docs/WlanConf.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.WlanConfs](docs/WlanConfs.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.WlanGroup](docs/WlanGroup.md)
 - [org.lambertland.androidthings.unifiapi.generated.model.WlanGroups](docs/WlanGroups.md)


<a name="documentation-for-authorization"></a>
## Documentation for Authorization

<a name="CSRF_Token"></a>
### CSRF_Token

- **Type**: API key
- **API key parameter name**: csrf_token
- **Location**: 

<a name="Unifises"></a>
### Unifises

- **Type**: API key
- **API key parameter name**: unifises
- **Location**: 

