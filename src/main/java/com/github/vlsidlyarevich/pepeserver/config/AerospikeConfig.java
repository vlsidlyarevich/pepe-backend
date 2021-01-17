package com.github.vlsidlyarevich.pepeserver.config;

import com.aerospike.client.Host;
import com.github.vlsidlyarevich.pepeserver.message.repository.AerospikeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.aerospike.config.AbstractAerospikeDataConfiguration;
import org.springframework.data.aerospike.repository.config.EnableAerospikeRepositories;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Aerospike configuration.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/14/21.
 */
@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))
@EnableConfigurationProperties(value = AerospikeProperties.class)
@EnableAerospikeRepositories(basePackageClasses = AerospikeRepository.class)
public class AerospikeConfig extends AbstractAerospikeDataConfiguration {

    private final AerospikeProperties properties;

    @Override
    protected Collection<Host> getHosts() {
        return properties.getHosts()
                .stream()
                .map(host -> new Host(host.getName(), host.getTlsName(), host.getPort()))
                .collect(Collectors.toList());
    }

    @Override
    protected String nameSpace() {
        return properties.getNamespace();
    }
}
