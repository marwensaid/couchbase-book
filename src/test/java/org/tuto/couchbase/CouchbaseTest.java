package org.tuto.couchbase;

import com.couchbase.client.CouchbaseClient;
import org.junit.Assert;
import org.junit.Test;
 
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class CouchbaseTest {

	 @Test
	    public void connect() throws Exception {
	 
	        List<URI> uris = new ArrayList<URI>();
	        uris.add(new URI("http://127.0.0.1:8091/pools"));
	        String bucketName = "default";
	        String pwd = "";
	 
	        // Connection
	        CouchbaseClient client = new CouchbaseClient(uris, bucketName, pwd);
	 
	        String key = "article_2015-09-25";
	        String value = "{\n\"titre\":\"couchbase\"\n}";
	 
	        // Set
	        client.set(key, value);
	 
	        // Get
	        String result = (String) client.get(key);
	 
	        Assert.assertEquals(value, result);
	    }
}
