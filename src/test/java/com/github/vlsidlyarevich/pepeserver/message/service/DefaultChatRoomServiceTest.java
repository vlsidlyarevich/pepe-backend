package com.github.vlsidlyarevich.pepeserver.message.service;

import com.github.vlsidlyarevich.pepeserver.AbstractUnitTest;
import com.github.vlsidlyarevich.pepeserver.message.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.message.repository.ChatRoomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.util.Lists.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class DefaultChatRoomServiceTest extends AbstractUnitTest {

    @Mock
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

    @Test
    public void save_savedObject_ifNotNull() {
        ChatRoom toSave = new ChatRoom("name", emptyList(), null, null, emptyList());

        when(repository.save(eq(toSave))).thenReturn(toSave);

        ChatRoom saved = sut.save(toSave);

        assertEquals(toSave, saved);
    }
}