package com.weenect.testweenect.application.presentation.navigation

import com.weenect.testweenect.helpers.NavigationIntent
import kotlinx.coroutines.channels.Channel

interface AppNavigator {
    val navigationChannel: Channel<NavigationIntent>

    /**
     * Navigue en arrière dans la hiérarchie de navigation.
     *
     * @param route  //La route spécifique à laquelle naviguer en arrière, ou null pour une navigation par défaut.
     * @param inclusive //Indique si la destination spécifiée doit être incluse dans la navigation arrière.
     */
    suspend fun navigateBack(
        route: String? = null,
        inclusive: Boolean = false,
    )

    /**
     * Tente de naviguer en arrière dans la hiérarchie de navigation.
     *
     * @param route //La route spécifique à laquelle naviguer en arrière, ou null pour une navigation par défaut.
     * @param inclusive //Indique si la destination spécifiée doit être incluse dans la navigation arrière.
     */
    fun tryNavigateBack(
        route: String? = null,
        inclusive: Boolean = false,
    )

    /**
     * Navigue vers une nouvelle destination.
     *
     * @param route //La route de destination.
     * @param popUpToRoute //La route à laquelle la navigation doit "pop" (remontée) jusqu'à atteindre.
     * @param inclusive //Indique si la destination spécifiée doit être incluse dans la navigation.
     * @param isSingleTop //Indique si la destination est une activité de type "single top".
     */
    suspend fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )

    /**
     * Tente de naviguer vers une nouvelle destination.
     *
     * @param route // La route de destination.
     * @param popUpToRoute // La route à laquelle la navigation doit "pop" (remontée) jusqu'à atteindre.
     * @param inclusive // Indique si la destination spécifiée doit être incluse dans la navigation.
     * @param isSingleTop // Indique si la destination est une activité de type "single top".
     */
    fun tryNavigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}