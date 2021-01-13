package com.github.vlsidlyarevich.pepeserver.message.repository;

import com.github.vlsidlyarevich.pepeserver.message.domain.ChatRoom;
import org.springframework.data.aerospike.repository.AerospikeRepository;

/**
 * ChatRoomRepository
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
public interface ChatRoomRepository extends AerospikeRepository<ChatRoom, String> {

}
