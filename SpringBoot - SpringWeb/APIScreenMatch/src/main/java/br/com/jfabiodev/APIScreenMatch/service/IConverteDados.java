package br.com.jfabiodev.APIScreenMatch.service;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
