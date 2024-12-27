package com.david.models.snowboard;


import org.immutables.value.Value.Immutable;

@Immutable
public interface SnowboardIF extends SnowboardCore {
    long getSnowboardId();
}
