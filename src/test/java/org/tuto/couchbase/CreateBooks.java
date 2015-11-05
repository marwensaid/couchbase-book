package org.tuto.couchbase;

import com.couchbase.client.CouchbaseClient;
import com.google.gson.Gson;
import org.junit.Test;

import java.util.Date;

public class CreateBooks {

    @Test
    public void createBooks() throws Exception {

        CouchbaseClient client = CouchbaseConnection.newCouchbaseClient();
        Gson gson = new Gson();
        String date = getDate();
        Book book;

        book = new Book()
                .setId("1")
                .setTitle("Web Video Finder")
                .setAuthor("DFY")
                .setPublisher("Orange")
                .setDate(date);
        client.set("book_"+book.getId(), gson.toJson(book));

        book = new Book()
                .setId("2")
                .setTitle("Meta")
                .setAuthor("DFY")
                .setPublisher("Orangina")
                .setDate(date);
        client.set("book_"+book.getId(), gson.toJson(book));

        book = new Book()
                .setId("3")
                .setTitle("Proxy Media")
                .setAuthor("MFY")
                .setPublisher("Orangino")
                .setDate(date);
        client.set("book_"+book.getId(), gson.toJson(book));

    }

    private String getDate() {
        Date dateSystem = new Date();
        return dateSystem.toString();
    }
}
