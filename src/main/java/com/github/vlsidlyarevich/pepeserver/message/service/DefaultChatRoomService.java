package com.github.vlsidlyarevich.pepeserver.message.service;

import com.github.vlsidlyarevich.pepeserver.message.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.message.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DefaultChatRoomService
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultChatRoomService implements ChatRoomService {

    private final ChatRoomRepository repository;

    @Override
    public ChatRoom save(final ChatRoom toSave) {
        if (toSave == null) throw new IllegalArgumentException("Can't save nullable ChatRoom");
        return repository.save(toSave);
    }
}
