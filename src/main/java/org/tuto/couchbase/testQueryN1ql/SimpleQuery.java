package org.tuto.couchbase.testQueryN1ql;

import com.couchbase.client.java.query.Query;
import org.tuto.couchbase.testQueryN1ql.util.AbstractConnection;

/**
 * Created by msaidi on 11/12/15.
 */
public class SimpleQuery extends AbstractConnection {
    public static void main(String[] args) {
        new SimpleQuery();
    }

    @Override
    public void test() {
        Query query = Query.simple("SELECT autheur AS book, type FROM `default` ORDER BY name LIMIT 5");
        run(query);
    }

    @Override
    protected String testName() {
        return "simple query";
    }

}
