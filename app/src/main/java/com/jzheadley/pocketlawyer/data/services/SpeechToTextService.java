package com.jzheadley.pocketlawyer.data.services;

import com.ibm.watson.developer_cloud.android.library.audio.MicrophoneInputStream;
import com.ibm.watson.developer_cloud.android.library.audio.utils.ContentType;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.jzheadley.pocketlawyer.callbacks.SpeechReceivedCallback;
import com.jzheadley.pocketlawyer.data.singletons.SpeechToTextClient;

import java.util.List;

public class SpeechToTextService {

    private List<String> keywords;

    public void startRecording() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SpeechToTextClient.getInstance().recognizeUsingWebSocket(new MicrophoneInputStream(true), getRecognizeOptions(), new SpeechReceivedCallback());
            }
        }).start();
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    private RecognizeOptions getRecognizeOptions() {
        return new RecognizeOptions.Builder()
                .continuous(true)
                .keywords((String[]) keywords.toArray())
                .contentType(ContentType.OPUS.toString())
                .model("en-US_BroadbandModel")
                .interimResults(true)
                .inactivityTimeout(2000)
                .build();
    }
}
