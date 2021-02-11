package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.AbstractIntegrationTest;
import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.repository.ChatRoomRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
    public void create_Persisted_ifValidParams() {
        String id = sut.create("name", List.of("id")).getId();

        assertTrue("Can't find saved ChatRoom by id", repository.existsById(id));
    }
}
