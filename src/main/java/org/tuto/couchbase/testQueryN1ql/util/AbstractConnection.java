package org.tuto.couchbase.testQueryN1ql.util;

import com.couchbase.client.core.logging.CouchbaseLogger;
import com.couchbase.client.core.logging.CouchbaseLoggerFactory;
import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.json.JsonObject;
import com.couchbase.client.java.env.CouchbaseEnvironment;
import com.couchbase.client.java.env.DefaultCouchbaseEnvironment;
import com.couchbase.client.java.query.Query;
import com.couchbase.client.java.query.QueryResult;
import com.couchbase.client.java.query.QueryRow;
import com.couchbase.client.java.query.Statement;

import java.io.IOException;

/**
 * Created by msaidi on 11/12/15.
 */
public abstract class AbstractConnection {
    public static final String COUCHBASE_IP = "127.0.0.1";
    public static final String BUCKET = "beer-sample";
    public static final String PASSWORD = "";
    public static final CouchbaseEnvironment COUCHBASE_ENVIRONMENT = DefaultCouchbaseEnvironment.create();
    public static final CouchbaseLogger COUCHBASE_LOGGER = CouchbaseLoggerFactory.getInstance(AbstractConnection.class);
    protected Cluster cluster;
    protected Bucket bucket;

    protected AbstractConnection() {
        cluster = CouchbaseCluster.create(COUCHBASE_ENVIRONMENT, COUCHBASE_IP);
        try {
            bucket = cluster.openBucket(BUCKET, PASSWORD);
            test();
        } finally {
            cluster.disconnect();
        }
    }

    protected abstract void test();

    public void run(Query query, boolean state) {
        try {
            QueryResult queryResult = bucket.query(query);
            printout(queryResult, state);
        } catch (Exception e) {
            COUCHBASE_LOGGER.error("error " + testName(), e);
        }
    }

    public void run(Query query) {
        run(query, false);
    }

    public void run(Statement statement) {
        try {
            QueryResult queryResult = bucket.query(statement);
            printout(queryResult, false);
        } catch (Exception e) {
            COUCHBASE_LOGGER.error("error" + testName(), e);
        }
    }

    protected abstract String testName();

    private void printout(QueryResult queryResult, boolean state) {
        if (queryResult.finalSuccess()) {
            System.out.println(testName() + "Ok :" + queryResult.allRows().size());
            pause(state);
            for (QueryRow queryRow : queryResult) {
                System.out.println(queryRow.value());
            }
        } else {
            System.err.println(testName() + "failed");
            for (JsonObject jsonObjectError : queryResult.errors()) {
                System.err.println(jsonObjectError);
            }
        }
    }

    private void pause(boolean state) {
        try {
            if (state) {
                System.in.read();
            }
        } catch (IOException e) {
            COUCHBASE_LOGGER.error("pause error", e);
        }
    }
}
