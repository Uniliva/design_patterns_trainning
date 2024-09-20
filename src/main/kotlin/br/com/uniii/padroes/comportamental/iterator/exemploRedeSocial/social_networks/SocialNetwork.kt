package br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.social_networks

import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators.ProfileIterator


interface SocialNetwork {
    fun createFriendsIterator(profileEmail: String): ProfileIterator
    fun createCoworkersIterator(profileEmail: String): ProfileIterator
}