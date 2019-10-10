package br.com.gilmarioarantes.functional_programming.interfaces;

@FunctionalInterface
public interface Validador<T> {
    boolean valida(T t);
}
