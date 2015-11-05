package org.tuto.couchbase;

import com.couchbase.client.CouchbaseClient;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Date;

public class CreateVideos {
    @Test
    public void createVideos() throws Exception {
        CouchbaseClient client = CouchbaseConnection.newCouchbaseClient();
        Gson gson = new Gson();
        Video video;
        String date = getDate();

        video = new Video()
                .setId("1")
                .setSource("bein")
                .setTitle("football")
                .setDate(date)
                .setLink("www.youtube.com");
        client.set("video_" + video.getId(), gson.toJson(video));

        video = new Video()
                .setId("2")
                .setSource("canal")
                .setTitle("Start-up week-end")
                .setDate(date)
                .setLink("www.youtube.com");
        client.set("video_" + video.getId(), gson.toJson(video));

    }

    private String getDate() {
        Date dateSystem = new Date();
        return dateSystem.toString();
    }

}
