package com.github.vlsidlyarevich.pepeserver.room.service;

import com.github.vlsidlyarevich.pepeserver.AbstractUnitTest;
import com.github.vlsidlyarevich.pepeserver.room.domain.ChatRoom;
import com.github.vlsidlyarevich.pepeserver.room.repository.ChatRoomRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

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
    public void create_illegalArgumentException_ifNullableName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> sut.create(null, List.of("id")),
                "Expected save() to throw IllegalArgumentException");

        assertEquals(thrown.getMessage(), "Chat room name can't be empty or nullable");
    }

    @Test
    public void create_illegalArgumentException_ifEmptyName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> sut.create("", List.of("id")),
                "Expected save() to throw IllegalArgumentException");

        assertEquals(thrown.getMessage(), "Chat room name can't be empty or nullable");
    }

    @Test
    public void create_illegalArgumentException_ifNullableUserIds() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> sut.create("name", null),
                "Expected save() to throw IllegalArgumentException");

        assertEquals(thrown.getMessage(), "Chat room users can't be empty or nullable");
    }

    @Test
    public void create_illegalArgumentException_ifEmptyUserIds() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class,
                () -> sut.create("name", Lists.emptyList()),
                "Expected save() to throw IllegalArgumentException");

        assertEquals(thrown.getMessage(), "Chat room users can't be empty or nullable");
    }

    @Test
    public void create_savedObject_ifValidArguments() {
        ChatRoom toSave = new ChatRoom("name", List.of("id"));

        when(repository.save(eq(toSave))).thenReturn(toSave);

        ChatRoom saved = sut.create(toSave.getName(), toSave.getUserIds());

        assertEquals(toSave, saved);
    }
}