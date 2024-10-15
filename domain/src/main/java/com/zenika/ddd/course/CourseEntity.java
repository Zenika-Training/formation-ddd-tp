package com.zenika.ddd.course;

import com.zenika.ddd.doc.DomainObject;
import com.zenika.ddd.shared.StatutCourse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DomainObject
public class CourseEntity {
    @Builder.Default
    private final CourseVoId id = new CourseVoId(UUID.randomUUID());
    private UUID commandeId;
    private LivreurEntity livreurEntity;
    @Builder.Default
    private StatutCourse statut = StatutCourse.AVAILABLE;
    private Destination destination;
    private RestaurantEntity restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
