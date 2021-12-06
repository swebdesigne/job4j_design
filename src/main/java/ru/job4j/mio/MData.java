package ru.job4j.mio;

import java.io.Serializable;

class Data implements Serializable {
    private final int n;

    public Data(int n) {
        this.n = n;
    }

    public String toString() {
        return Integer.toString(n);
    }
}
