package com.github.vlsidlyarevich.pepeserver.config;

import com.github.vlsidlyarevich.pepeserver.room.repository.MongoRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * MongoDB configuration.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/14/21.
 */
@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@EnableMongoRepositories(basePackageClasses = MongoRoomRepository.class)
public class MongoConfig {

}
