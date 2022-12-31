
# WlanConf

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**enabled** | **kotlin.Boolean** |  | 
**name** | **kotlin.String** |  | 
**usergroupId** | **kotlin.String** |  | 
**wlangroupId** | **kotlin.String** |  | 
**wpaEnc** | [**inline**](#WpaEnc) |  | 
**wpaMode** | [**inline**](#WpaMode) |  | 
**xPassphrase** | **kotlin.String** |  | 
**id** | **kotlin.String** |  |  [optional]
**bcFilterEnabled** | **kotlin.Boolean** |  |  [optional]
**bcFilterList** | **kotlin.collections.MutableList&lt;kotlin.String&gt;** |  |  [optional]
**dtimMode** | **kotlin.String** |  |  [optional]
**dtimNa** | **kotlin.Int** |  |  [optional]
**dtimNg** | **kotlin.Int** |  |  [optional]
**groupRekey** | **kotlin.Int** |  |  [optional]
**isGuest** | **kotlin.Boolean** |  |  [optional]
**macFilterEnabled** | **kotlin.Boolean** |  |  [optional]
**macFilterList** | **kotlin.collections.MutableList&lt;kotlin.String&gt;** |  |  [optional]
**macFilterPolicy** | **kotlin.String** |  |  [optional]
**minrateNaAdvertisingRates** | **kotlin.Boolean** |  |  [optional]
**minrateNaBeaconRateKbps** | **kotlin.Int** |  |  [optional]
**minrateNaDataRateKbps** | **kotlin.Int** |  |  [optional]
**minrateNaEnabled** | **kotlin.Boolean** |  |  [optional]
**minrateNaMgmtRateKbps** | **kotlin.Int** |  |  [optional]
**minrateNgAdvertisingRates** | **kotlin.Boolean** |  |  [optional]
**minrateNgBeaconRateKbps** | **kotlin.Int** |  |  [optional]
**minrateNgCckRatesEnabled** | **kotlin.Boolean** |  |  [optional]
**minrateNgDataRateKbps** | **kotlin.Int** |  |  [optional]
**minrateNgEnabled** | **kotlin.Boolean** |  |  [optional]
**minrateNgMgmtRateKbps** | **kotlin.Int** |  |  [optional]
**schedule** | **kotlin.collections.MutableList&lt;kotlin.String&gt;** |  |  [optional]
**scheduleEnabled** | **kotlin.Boolean** |  |  [optional]
**security** | [**inline**](#Security) |  |  [optional]
**siteId** | **kotlin.String** |  |  [optional]
**vlan** | **kotlin.String** |  |  [optional]
**vlanEnabled** | **kotlin.Boolean** |  |  [optional]
**wepIdx** | **kotlin.Int** |  |  [optional]
**xIappKey** | **kotlin.String** |  |  [optional]


<a name="WpaEnc"></a>
## Enum: wpa_enc
Name | Value
---- | -----
wpaEnc | ccmp


<a name="WpaMode"></a>
## Enum: wpa_mode
Name | Value
---- | -----
wpaMode | wpa2


<a name="Security"></a>
## Enum: security
Name | Value
---- | -----
security | wpapsk, wpaeap, wep



