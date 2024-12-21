package com.david.models;

import org.immutables.value.Value.Immutable;

@Immutable
public interface SkisIF extends SkisCore {
    long getSkisId();

    long getRentalId();
}
