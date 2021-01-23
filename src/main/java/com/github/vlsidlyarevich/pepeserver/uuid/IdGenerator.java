package com.github.vlsidlyarevich.pepeserver.uuid;

import java.util.UUID;

/**
 * Interface with uuid-generation logic.
 * Should be used with persistence services.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/23/21.
 */
public interface IdGenerator {

    default UUID generateUUID() {
        return UUID.randomUUID();
    }
}
