package com.david.models;


import org.immutables.value.Value.Immutable;

@Immutable
public interface SnowboardIF extends SnowboardCore {
    long getSnowboardId();

    long getRentalId();
}
