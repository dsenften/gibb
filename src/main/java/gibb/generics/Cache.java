package gibb.generics;

/**
 * Implement a simple cache data structure using a generic type.
 * <p>
 * User: Daniel Senften <daniel@senften.org>
 * Date: 05.12.18, 21:21
 */
class Cache<T> {

    private T type;

    void add(T type) {
        this.type = type;
    }

    T get() {
        return type;
    }
}
