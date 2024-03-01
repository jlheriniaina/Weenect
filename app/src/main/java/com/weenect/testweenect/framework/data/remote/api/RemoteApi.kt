package com.weenect.testweenect.framework.data.remote.api

import com.weenect.testweenect.framework.data.remote.models.ApiEndpoint
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * Interface représentant une API distante pour récupérer des données.
 */
interface RemoteApi {

    /**
     * Effectue une requête GET vers l'endpoint des utilisateurs avec les paramètres spécifiés.
     *
     * @param params Les paramètres de la requête sous forme de map.
     * @return La réponse de la requête encapsulée dans un objet [Response<ResponseBody>]
     */
    @GET(ApiEndpoint.USERS)
    @JvmSuppressWildcards
    suspend fun getData(@QueryMap params : Map<String, Any>) : Response<ResponseBody>
}