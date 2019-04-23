package com.gridgain.hcdemo.model;

import java.io.Serializable;

public interface Identifiable<T> extends Serializable {

    public T key();
}
