package com.github.vlsidlyarevich.pepeserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * MongoDB properties.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com> Created on 1/14/21.
 */
@Data
@Validated
@ConfigurationProperties(prefix = "mongodb")
public class MongoProperties {

    @NotBlank
    private String database;
    @NotBlank
    private String host;
    @NotNull
    @Positive
    private Integer port;
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    /**
     * <p>The format of the Connection String is:</p>
     * <pre>
     *      mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database.collection][?options]]
     *  </pre>
     */
    public String getConnectionString() {
        return String.format("mongodb://%s:%s@%s:%s/%s", username, password, host, port, database);
    }
}
