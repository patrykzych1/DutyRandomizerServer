package main.domain.converter;

@FunctionalInterface
public interface Converter<From, To> {
    To convert (From from);
}
