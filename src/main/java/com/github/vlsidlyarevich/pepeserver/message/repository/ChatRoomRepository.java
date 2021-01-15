package com.github.vlsidlyarevich.pepeserver.message.repository;

import com.github.vlsidlyarevich.pepeserver.message.domain.ChatRoom;
import org.springframework.data.aerospike.repository.AerospikeRepository;
import org.springframework.stereotype.Repository;

/**
 * ChatRoomRepository
 *
 * @author Vladislav Sidlyarevich <vlsidlyarevich@gmail.com>
 * Created on 1/13/21.
 */
@Repository
public interface ChatRoomRepository extends AerospikeRepository<ChatRoom, String> {

}
