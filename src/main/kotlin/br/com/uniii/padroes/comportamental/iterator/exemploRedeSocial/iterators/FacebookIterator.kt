package br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.iterators

import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.profile.Profile
import br.com.uniii.padroes.comportamental.iterator.exemploRedeSocial.social_networks.Facebook


class FacebookIterator(facebook: Facebook, private val type: String, private val email: String) : ProfileIterator {
    private val facebook: Facebook = facebook
    private var currentPosition = 0
    private val emails: MutableList<String> = ArrayList()
    private val profiles: MutableList<Profile?> = ArrayList<Profile?>()

    private fun lazyLoad() {
        if (emails.size == 0) {
            val profiles: List<String> = facebook.requestProfileFriendsFromFacebook(
                this.email,
                this.type
            )
            for (profile in profiles) {
                emails.add(profile)
                this.profiles.add(null)
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
            var friendProfile: Profile? = profiles[currentPosition]
            if (friendProfile == null) {
                friendProfile = facebook.requestProfileFromFacebook(friendEmail)
                profiles[currentPosition] = friendProfile
            }
            currentPosition++
            return friendProfile
        }

    override fun reset() {
        currentPosition = 0
    }
}