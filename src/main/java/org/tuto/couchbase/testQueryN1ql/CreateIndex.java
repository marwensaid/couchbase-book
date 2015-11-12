package org.tuto.couchbase.testQueryN1ql;


import com.couchbase.client.java.query.Index;
import com.couchbase.client.java.query.Statement;
import com.couchbase.client.java.query.dsl.path.index.IndexType;
import org.tuto.couchbase.testQueryN1ql.util.AbstractConnection;

/**
 * Created by msaidi on 11/12/15.
 */
public class CreateIndex extends AbstractConnection {
    public static void main(String[] args) {
        new CreateIndex();
    }

    public String testName() {
        return "creation index";
    }

    public void test() {
        Statement indexCreate = Index.createPrimaryIndex().on("default").using(IndexType.GSI);
        run(indexCreate);
    }


}
