package guru.springframework.msscbrewery.web.mappers.shared;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Component
public final class DateMapper {

    public Timestamp offsetDateTimeToTimestamp(OffsetDateTime offsetDateTime) {
        return Timestamp.valueOf(LocalDateTime.ofInstant(offsetDateTime.toInstant(), offsetDateTime.getOffset()));
    }

    public OffsetDateTime timestampToOffsetDateTime(Timestamp timestamp) {
        return OffsetDateTime.ofInstant(timestamp.toInstant(), OffsetDateTime.now().getOffset());
    }
}
