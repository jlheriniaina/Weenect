package com.weenect.testweenect.framework.data.remote.models.response

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

/**
 * Classe utilitaire pour gérer les réponses des API.
 */
class ApiResponse {

    /**
     * Exécute la logique de traitement de la réponse de l'API.
     *
     * @param T // Le type de l'objet attendu en réponse.
     * @param response // La réponse de l'API encapsulée dans un objet Response<ResponseBody>.
     * @param typeOfT // Le type de l'objet attendu (utilisé pour la désérialisation).
     * @return // L'objet désérialisé de type T.
     * @throws // IOException Si une erreur de réseau ou une erreur de lecture se produit.
     * @throws Exception // Si une erreur non gérée se produit lors de la désérialisation ou du traitement de la réponse.
     */
    suspend fun <T : Any> execute(
        response : Response<ResponseBody>,
        typeOfT: Type
    ): T = withContext(Dispatchers.IO) {
        try {
            val body = response.body()
            if (response.isSuccessful && body != null) {
                Gson().fromJson<T>(body.charStream(), typeOfT)
            } else {
                throw IOException("Not found")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}