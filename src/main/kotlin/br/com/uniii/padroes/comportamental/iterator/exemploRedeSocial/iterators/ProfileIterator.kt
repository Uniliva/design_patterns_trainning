package br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators

import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.profile.Profile

interface ProfileIterator {
    fun hasNext(): Boolean
    val next: Profile?
    fun reset()
}