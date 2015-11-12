package org.tuto.couchbase.testQueryN1ql;

import com.couchbase.client.java.query.Query;
import com.couchbase.client.java.query.Statement;
import org.tuto.couchbase.testQueryN1ql.util.AbstractConnection;

import static com.couchbase.client.java.query.Select.select;
import static com.couchbase.client.java.query.dsl.Expression.*;
import static com.couchbase.client.java.query.dsl.Sort.asc;

/**
 * Created by msaidi on 11/12/15.
 */
public class QueryWithPredicate extends AbstractConnection {
    public static void main(String[] args) {
        new QueryWithPredicate();
    }

    public String testName() {
        return "Query with predicate";
    }

    public void test() {
        Statement queryPredicate = select(x("autheur").as("book")).from(i("default")).where(x("type").eq(s("book"))).orderBy(asc("autheur")).limit(5);
        Query query = Query.simple(queryPredicate);
        run(query);
    }
}
