package com.demo.sharding.mapper;

import com.demo.sharding.domain.UserAccount;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * @author yangkun
 * @see
 * @since
 */
@Repository
public interface UserAccountMapper {

    List<UserAccount> selectAll();
}
