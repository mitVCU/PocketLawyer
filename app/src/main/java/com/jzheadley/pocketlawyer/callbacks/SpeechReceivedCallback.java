package com.jzheadley.pocketlawyer.callbacks;

import android.util.Log;

import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;
import com.ibm.watson.developer_cloud.speech_to_text.v1.websocket.RecognizeCallback;

public class SpeechReceivedCallback implements RecognizeCallback {

    private static final String TAG = "MicrophoneRecognizeDele";

    /**
     * Speech has been received.
     */
    @Override
    public void onTranscription(SpeechResults speechResults) {
        // System.out.println(speechResults);

        // String text = speechResults.getResults().get(0).getAlternatives().get(0).getTranscript();

        // Controller model = getInstance();
        // model.interpretResults(speechResults);
    }

    @Override
    public void onConnected() {
        Log.d(TAG, "Connected to watson");
    }

    @Override
    public void onError(Exception e) {
        System.err.println(e);
    }

    @Override
    public void onDisconnected() {
    }
}