package br.com.uniii.padroes.estrutural.proxy

import br.com.uniii.padroes.estrutural.proxy.proxy.YouTubeCacheProxy
import br.com.uniii.padroes.estrutural.proxy.videoLib.ThirdPartyYouTubeClass


object Demo {
    @JvmStatic
    fun main(args: Array<String>) {
        val naiveDownloader = YouTubeDownloader(ThirdPartyYouTubeClass())
        val smartDownloader = YouTubeDownloader(YouTubeCacheProxy())

        val naive = test(naiveDownloader)
        val smart = test(smartDownloader)
        print("Time saved by caching proxy: " + (naive - smart) + "ms")
    }

    private fun test(downloader: YouTubeDownloader): Long {
        val startTime = System.currentTimeMillis()

        // User behavior in our app:
        downloader.renderPopularVideos()
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderPopularVideos()
        downloader.renderVideoPage("dancesvideoo")
        // Users might visit the same page quite often.
        downloader.renderVideoPage("catzzzzzzzzz")
        downloader.renderVideoPage("someothervid")

        val estimatedTime = System.currentTimeMillis() - startTime
        print("Time elapsed: " + estimatedTime + "ms\n")
        return estimatedTime
    }
}