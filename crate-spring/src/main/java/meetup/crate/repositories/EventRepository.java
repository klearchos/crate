package meetup.crate.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import meetup.model.Event;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class EventRepository {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    EventRepository(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
        this.dataSource = dataSource;
    }

    public List<Event> findAll() {
        List<Event> events = jdbcTemplate.query(
                "SELECT id, sensor_name, sensor_value, created FROM events",
                (rs, rowNum) -> new Event(rs.getString("id"),
                    rs.getString("sensor_name"),
                    rs.getFloat("sensor_temp_value"),
                    rs.getFloat("sensor_humidity_value"),
                    rs.getDate("created"))
        );
        return events;
    }

    public void insert(Event newEvent) throws SQLException {
        String sql = "INSERT INTO events (id, sensor_name, sensor_temp_value, sensor_humidity_value, created)"
                + " VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, UUID.randomUUID().toString());
            ps.setString(2, newEvent.getSensorName());
            ps.setFloat(3, newEvent.getSensorTempValue());
            ps.setFloat(4, newEvent.getSensorHumidityValue());
            ps.setLong(5, (new Date()).getTime());
            ps.executeUpdate();
        }
    }
}
