package br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators

import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.profile.Profile
import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.social_networks.LinkedIn


class LinkedInIterator(linkedIn: LinkedIn, private val type: String, private val email: String) : ProfileIterator {
    private val linkedIn: LinkedIn = linkedIn
    private var currentPosition = 0
    private val emails: MutableList<String> = ArrayList()
    private val contacts: MutableList<Profile?> = ArrayList<Profile?>()

    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles: List<String> = linkedIn.requestRelatedContactsFromLinkedInAPI(
                this.email,
                this.type
            )
            for (profile in profiles) {
                emails.add(profile)
                contacts.add(null)
            }
        }
    }

    override fun hasNext(): Boolean {
        lazyLoad()
        return currentPosition < emails.size
    }

    override val next: Profile?
        get() {
            if (!hasNext()) {
                return null
            }

            val friendEmail = emails[currentPosition]
            var friendContact: Profile? = contacts[currentPosition]
            if (friendContact == null) {
                friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail)
                contacts[currentPosition] = friendContact
            }
            currentPosition++
            return friendContact
        }

    override fun reset() {
        currentPosition = 0
    }
}