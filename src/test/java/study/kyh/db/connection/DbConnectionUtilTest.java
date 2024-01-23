package study.kyh.db.connection;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

@Slf4j
public class DbConnectionUtilTest {

    @Test
    void connection() {
        Connection connection = DbConnectionUtil.getConnection();
        Assertions.assertThat(connection).isNotNull();
    }

}
