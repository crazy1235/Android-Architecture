package com.jacksen.mdrr.data;

import com.jacksen.mdrr.model.MobileInfo;
import com.jacksen.mdrr.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by jacksen on 2016/7/29.
 */

public interface ApiService {

    @Headers({"apikey: 48b0fc4c8047a43a9da5d5c1f65df2e9"})
    @GET(Constants.BASE_URL + Constants.QUERY_MOBILE_URL)
    Call<MobileInfo> getMobileInfo(@Query("phone") String mobileNum);

}
