package xyz.qwewqa.relive.simulator.client

import kotlin.js.Promise

external fun createAuth0Client(options: dynamic): Promise<Auth0Client>


external interface Auth0Client {
    fun getTokenSilently(): Promise<String>
    fun loginWithRedirect(): Promise<Unit>
    fun logout(): Promise<Unit>
    fun handleRedirectCallback(): Promise<Unit>
    fun isAuthenticated(): Promise<Boolean>
    fun getUser(): Promise<dynamic>
}
