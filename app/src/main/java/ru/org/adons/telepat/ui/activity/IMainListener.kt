package ru.org.adons.telepat.ui.activity

import ru.org.adons.telepat.ui.main.MainFragment

/**
 * Listen [MainFragment] and notify [MainActivity]
 */
interface IMainListener {

    fun showProgress()

    fun hideProgress()

}