package com.pcb.ProductCouchbase.config;


//import com.pcb.ProductCouchbase.User;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import java.util.Collections;

@Configuration
public class CouchBaseConfig extends AbstractCouchbaseConfiguration {


    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "myapp";
    }

    @Override
    public String getPassword() {
        return "123321";
    }

    @Override
    public String getBucketName() {
        return "customer";
    }

//    @Override
//    public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
//        mapping.mapEntity(User.class, getCouchbaseTemplate(userBucket));
//    }

//    @SneakyThrows
//    private CouchbaseTemplate getCouchbaseTemplate(String bucketName) {
//        CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName),
//                mappingCouchbaseConverter(couchbaseMappingContext(customConversions()),
//                        new CouchbaseCustomConversions(Collections.emptyList())));
//
//        template.setApplicationContext(context);
//        return template;
//    }
//
//    private CouchbaseClientFactory couchbaseClientFactory(String bucketName) {
//        return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()),
//                bucketName, this.getScopeName());
//    }
}