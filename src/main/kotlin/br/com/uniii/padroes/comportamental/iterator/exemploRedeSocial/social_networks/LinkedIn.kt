package br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.social_networks

import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators.LinkedInIterator
import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators.ProfileIterator
import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.profile.Profile


class LinkedIn(cache: List<Profile>?) : SocialNetwork {
    private var contacts: List<Profile> = cache ?: arrayListOf()


    fun requestContactInfoFromLinkedInAPI(profileEmail: String): Profile? {
        // Here would be a POST request to one of the LinkedIn API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life...
        simulateNetworkLatency()
        println("LinkedIn: Loading profile '$profileEmail' over the network...")

        // ...and return test data.
        return findContact(profileEmail)
    }

    fun requestRelatedContactsFromLinkedInAPI(profileEmail: String, contactType: String): List<String> {
        // Here would be a POST request to one of the LinkedIn API endpoints.
        // Instead, we emulates long network connection, which you would expect
        // in the real life.
        simulateNetworkLatency()
        println("LinkedIn: Loading '$contactType' list of '$profileEmail' over the network...")

        // ...and return test data.
        val profile: Profile? = findContact(profileEmail)
        if (profile != null) {
            return profile.getContacts(contactType)
        }
        return listOf()
    }

    private fun findContact(profileEmail: String): Profile? {
        for (profile in contacts) {
            if (profile.email.equals(profileEmail)) {
                return profile
            }
        }
        return null
    }

    private fun simulateNetworkLatency() {
        try {
            Thread.sleep(2500)
        } catch (ex: InterruptedException) {
            ex.printStackTrace()
        }
    }

    override fun createFriendsIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "friends", profileEmail)
    }

    override fun createCoworkersIterator(profileEmail: String): ProfileIterator {
        return LinkedInIterator(this, "coworkers", profileEmail)
    }
}