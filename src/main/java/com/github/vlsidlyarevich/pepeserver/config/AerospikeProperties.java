package com.github.vlsidlyarevich.pepeserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Aerospike properties.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com> Created on 1/14/21.
 * @see com.aerospike.client.Host
 */
@Data
@Validated
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeProperties {

    @NotBlank
    private String namespace;
    @NotEmpty
    private List<AerospikeHost> hosts;

    @Data
    @Validated
    public static class AerospikeHost {
        /**
         * Host name or IP address of database server.
         */
        @NotBlank
        private String name;

        /**
         * TLS certificate name used for secure connections.
         */
        private String tlsName;

        /**
         * Port of database server.
         */
        private int port = 3000;
    }
}
