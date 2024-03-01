package com.weenect.testweenect.framework.data.remote.models.request

class ParamBuilderQueryRequest {
    private val params: MutableMap<String, Any> = mutableMapOf()

    /**
     * Ajoute un paramètre à la requête.
     *
     * @param key // La clé du paramètre.
     * @param value // La valeur du paramètre.
     * @return Cette instance de ParamBuilderQueryRequest pour permettre l'appel chaîné des méthodes.
     */
    fun addParam(key: String, value: Any): ParamBuilderQueryRequest {
        params[key] = value
        return this
    }

    /**
     * Ajoute plusieurs paires clé-valeur à la requête.
     *
     * @param pairs // Les paires clé-valeur à ajouter.
     * @return // Cette instance de ParamBuilderQueryRequest pour permettre l'appel chaîné des méthodes.
     */
    fun addParams(vararg pairs: Pair<String, Any>): ParamBuilderQueryRequest {
        params.putAll(pairs.associateBy({ it.first }, { it.second }))
        return this
    }

    /**
     * Construit et renvoie les paramètres de la requête.
     *
     * @return // Les paramètres de la requête sous forme de Map.
     */
    fun build(): Map<String, Any> {
        return params
    }
}