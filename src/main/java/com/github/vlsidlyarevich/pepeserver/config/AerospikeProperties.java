package com.github.vlsidlyarevich.pepeserver.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * Aerospike properties.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/14/21.
 */
@Data
@Validated
@ConfigurationProperties(prefix = "aerospike")
public class AerospikeProperties {

    @NotBlank
    private String namespace;
    @NotEmpty
    private List<String> hosts;
}
