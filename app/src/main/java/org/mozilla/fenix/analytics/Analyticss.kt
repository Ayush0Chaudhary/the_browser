/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package org.mozilla.fenix.analytics
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL =
    "http://panda123.pythonanywhere.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface Analyticss {
    @GET("start")
     suspend fun getStart(
        @Query("user_id") userId: String
    ): String

    @GET("defaultBrowser")
    suspend fun getDefaultBrowser(
        @Query("user_id") userId: String
    ): String
}

object AnalyticsApi {
    val retrofitService : Analyticss by lazy {
        retrofit.create(Analyticss::class.java)
    }
}
