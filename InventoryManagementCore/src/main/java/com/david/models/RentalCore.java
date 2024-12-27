package com.david.models;

import java.util.Optional;

public interface RentalCore {

    long getRentalId();

    Optional<Long> getUserId();

    long getRentalDate();

    long getExpectedReturnDate();

    Optional<Long> getActualReturnDate();
}
