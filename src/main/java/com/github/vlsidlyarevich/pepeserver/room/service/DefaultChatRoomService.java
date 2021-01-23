package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.repository.ChatRoomRepository;
import com.github.vlsidlyarevich.pepeserver.uuid.IdGenerator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DefaultChatRoomService
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultChatRoomService implements ChatRoomService, IdGenerator {

    private final ChatRoomRepository repository;

    @Override
    public ChatRoom save(final ChatRoom toSave) {
        if (toSave == null) throw new IllegalArgumentException("Can't save nullable ChatRoom");
        if (Strings.isEmpty(toSave.getId())) {
            toSave.setId(generateUUID().toString());
            log.info("Saving new ChatRoom with id: {}", toSave.getId());
        }

        return repository.save(toSave);
    }
}
