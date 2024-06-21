package com.overcomingroom.ulpet.place.repository;

import com.overcomingroom.ulpet.place.domain.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    Optional<Place> findByContentId(long contentId);

    Optional<Place> findByPlaceNameAndAddress(String placeName, String address);
}
