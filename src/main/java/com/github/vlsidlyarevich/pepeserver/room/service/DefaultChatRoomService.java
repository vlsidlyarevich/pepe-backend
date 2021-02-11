package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.repository.ChatRoomRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.StringUtils.hasText;

/**
 * DefaultChatRoomService
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Slf4j
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultChatRoomService implements ChatRoomService {

    private final ChatRoomRepository repository;

    @Override
    public ChatRoom create(final String name, final List<String> userIds) {
        if (!hasText(name))
            throw new IllegalArgumentException("Chat room name can't be empty or nullable");
        if (userIds == null || userIds.isEmpty())
            throw new IllegalArgumentException("Chat room users can't be empty or nullable");

        return repository.save(new ChatRoom(name, userIds));
    }
}
