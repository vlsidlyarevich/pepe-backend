package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.AbstractIntegrationTest;
import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.repository.ChatRoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.vlsidlyarevich.pepeserver.ChatRoomGenerator.generateChatRoom;
import static org.springframework.test.util.AssertionErrors.assertTrue;

/**
 * DefaultChatRoomService integration test.
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/23/21.
 */
public class DefaultChatRoomServiceIT extends AbstractIntegrationTest {

    @Autowired
    private ChatRoomService sut;

    @Autowired
    private ChatRoomRepository repository;

    @Test
    public void save_Persisted_ifNotNull() {
        ChatRoom chatRoom = generateChatRoom();

        String id = sut.save(chatRoom).getId();

        assertTrue("Can't find saved ChatRoom by id", repository.existsById(id));
    }
}
