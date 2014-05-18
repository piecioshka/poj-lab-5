package poj_lab_5.domain;

public class FileInputStreamObserverImplement implements FileInputStreamObserver {

    @Override
    public void notifyClosingStream() {
        System.out.println("Strumień się zakończył");
    }

    @Override
    public void notifyEndingStream() {
        System.out.println("Doszliśmy do końca strumienia");
    }

    @Override
    public void notifyReadingStream() {
        System.out.println("Odczytaliśmy: liczba bajtów, indeks");
    }

    @Override
    public void notifyReadingGroupStream() {
        System.out.println("Odczytaliśmy: liczba bajtów, indeks pierwszego, indeks ostatniego");
    }

    @Override
    public void notifyLeavingStream() {
        System.out.println("Opuszczenie bajtów: liczba bajtów opuszczonych, indeks ostatniego opuszczonego bajtu");
    }
}
