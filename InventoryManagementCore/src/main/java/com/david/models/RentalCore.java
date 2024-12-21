package models;

import java.util.Optional;

public interface RentalCore {

    Optional<Long> getUserId();

    long getRentalDate();

    long getExpectedReturnDate();

    Optional<Long> getActualReturnDate();
}
