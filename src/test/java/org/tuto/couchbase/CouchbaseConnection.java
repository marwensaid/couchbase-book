package org.tuto.couchbase;

import com.couchbase.client.CouchbaseClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CouchbaseConnection {

    public static CouchbaseClient newCouchbaseClient() throws Exception {

        List<URI> uris = new ArrayList<URI>();
        uris.add(new URI("http://127.0.0.1:8091/pools"));
        String bucketName = "default";
        String pwd = "";

        return new CouchbaseClient(uris, bucketName, pwd);
    }
}
