package codeartitect.taskflower.global;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@MappedSuperclass
public abstract class BaseTimeEntity {

    @Column
    private LocalDateTime created_at;

    @Column
    private LocalDateTime updated_at;

    @PrePersist
    public void prePersist() {
        ZoneId zoneId = getUserZoneId();
        this.created_at = LocalDateTime.now(zoneId);
        this.updated_at = LocalDateTime.now(zoneId);
    }

    @PreUpdate
    public void preUpdate() {
        ZoneId zoneId = getUserZoneId();
        this.updated_at = LocalDateTime.now(zoneId);
    }

    public abstract ZoneId getUserZoneId();
}
