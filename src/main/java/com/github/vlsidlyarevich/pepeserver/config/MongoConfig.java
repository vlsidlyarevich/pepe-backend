package com.github.vlsidlyarevich.pepeserver.config;

import com.github.vlsidlyarevich.pepeserver.room.repository.MongoRoomRepository;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/14/21.
 */
@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@EnableConfigurationProperties(value = MongoProperties.class)
@EnableMongoRepositories(basePackageClasses = MongoRoomRepository.class)
public class MongoConfig extends AbstractMongoClientConfiguration {

    private final MongoProperties properties;

    @Override
    protected String getDatabaseName() {
        return properties.getDatabase();
    }

    @Override
    protected void configureClientSettings(final MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString(properties.getConnectionString()));
        super.configureClientSettings(builder);
    }
}
