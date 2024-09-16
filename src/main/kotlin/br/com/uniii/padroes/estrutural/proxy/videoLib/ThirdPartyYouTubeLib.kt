package br.com.uniii.padroes.estrutural.proxy.videoLib


interface ThirdPartyYouTubeLib {
    fun popularVideos(): HashMap<String, Video>

    fun getVideo(videoId: String): Video
}