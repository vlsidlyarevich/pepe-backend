package com.github.vlsidlyarevich.pepeserver.message.service;

import com.github.vlsidlyarevich.pepeserver.AbstractUnitTest;
import com.github.vlsidlyarevich.pepeserver.message.repository.ChatRoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DefaultChatRoomServiceTest extends AbstractUnitTest {

    @MockBean
    private ChatRoomRepository repository;

    @InjectMocks
    private DefaultChatRoomService sut;

    @Test
    public void save_illegalArgumentException_ifNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> sut.save(null),
                "Expected save() to throw IllegalArgumentException");

        assertEquals(thrown.getMessage(), "Can't save nullable ChatRoom");
    }
}