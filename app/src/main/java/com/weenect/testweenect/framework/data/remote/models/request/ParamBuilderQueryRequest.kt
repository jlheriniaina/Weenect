package com.weenect.testweenect.framework.data.remote.models.request

class ParamBuilderQueryRequest {
    private val params: MutableMap<String, Any> = mutableMapOf()

    fun addParam(key: String, value: Any): ParamBuilderQueryRequest {
        params[key] = value
        return this
    }

    fun addParams(vararg pairs: Pair<String, Any>): ParamBuilderQueryRequest {
        params.putAll(pairs.associateBy({ it.first }, { it.second }))
        return this
    }

    fun build(): Map<String, Any> {
        return params
    }
}