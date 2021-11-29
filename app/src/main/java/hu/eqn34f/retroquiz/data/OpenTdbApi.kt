package hu.eqn34f.retroquiz.data

import hu.eqn34f.retroquiz.model.opentdb.Difficulty
import hu.eqn34f.retroquiz.model.opentdb.OpenTdbResult
import hu.eqn34f.retroquiz.model.opentdb.OpenTdbTokenResult
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenTdbApi {
    @GET("api.php")
    suspend fun getQuestions(
        @Query("difficulty") diffuculty: String,
        @Query("token") token: String?,
        @Query("amount") amount: Int = 1,
        @Query("encode") encoding: String = "url3986"
    ): OpenTdbResult

    @GET("api_token.php?command=request")
    suspend fun getToken(): OpenTdbTokenResult
}
