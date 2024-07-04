package com.example.omegleapp.utils

import org.webrtc.PeerConnectionFactory
import org.webrtc.VideoCapturer
import org.webrtc.VideoTrack

object WebRTCUtils {
    private lateinit var peerConnectionFactory: PeerConnectionFactory

    fun initPeerConnectionFactory() {
        PeerConnectionFactory.initialize(
            PeerConnectionFactory.InitializationOptions.builder()
                .createInitializationOptions()
        )
        peerConnectionFactory = PeerConnectionFactory.builder().createPeerConnectionFactory()
    }

    fun createVideoTrack(capturer: VideoCapturer): VideoTrack {
        val videoSource = peerConnectionFactory.createVideoSource(capturer.isScreencast)
        capturer.startCapture(1280, 720, 30)
        return peerConnectionFactory.createVideoTrack("video", videoSource)
    }
}
