package poj_lab_5.domain;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("poj lab 5");

        FileInputStreamObserverImplement fisoe1 = new FileInputStreamObserverImplement();
        FileInputStreamObserverImplement fisoe2 = new FileInputStreamObserverImplement();
        FileInputStreamObserverImplement fisoe3 = new FileInputStreamObserverImplement();
        FileInputStreamObserverImplement fisoe4 = new FileInputStreamObserverImplement();
        FileInputStreamObserverImplement fisoe5 = new FileInputStreamObserverImplement();

        ObservableFileInputStream ofis = new ObservableFileInputStream("data/foobar.txt");

        ofis.addClosingStreamListener(fisoe1);
        ofis.addEndingStreamListener(fisoe2);
        ofis.addReadingStreamListener(fisoe3);
        ofis.addReadingGroupStreamListener(fisoe4);
        ofis.addLeavingStreamListener(fisoe5);

        ofis.removeClosingStreamListener(fisoe1);
        ofis.removeEndingStreamListener(fisoe2);
        // ofis.removeReadingStreamListener(fisoe3);
        ofis.removeReadingGroupStreamListener(fisoe4);
        ofis.removeLeavingStreamListener(fisoe5);

        ofis.read();
        // ofis.close();
        // ofis.read(n);
        // ofis.read(n, l);
        // ofis.skip();
    }
}