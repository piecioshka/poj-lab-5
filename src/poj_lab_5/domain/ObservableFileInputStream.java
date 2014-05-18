package poj_lab_5.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ObservableFileInputStream extends FileInputStream {

    private final ArrayList<FileInputStreamObserver> closingList;
    private final ArrayList<FileInputStreamObserver> endingList;
    private final ArrayList<FileInputStreamObserver> readingList;
    private final ArrayList<FileInputStreamObserver> readingGroupList;
    private final ArrayList<FileInputStreamObserver> leavingList;

    public ObservableFileInputStream(String name) throws FileNotFoundException {
        super(name);
        this.closingList = new ArrayList<FileInputStreamObserver>();
        this.endingList = new ArrayList<FileInputStreamObserver>();
        this.readingList = new ArrayList<FileInputStreamObserver>();
        this.readingGroupList = new ArrayList<FileInputStreamObserver>();
        this.leavingList = new ArrayList<FileInputStreamObserver>();
    }

    public void addClosingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (this.closingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.closingList.add(fiso);
    }

    public void addEndingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (this.endingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.endingList.add(fiso);
    }

    public void addReadingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (this.readingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.readingList.add(fiso);
    }

    public void addReadingGroupStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (this.readingGroupList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.readingGroupList.add(fiso);
    }

    public void addLeavingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (this.leavingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.leavingList.add(fiso);
    }

    public void removeClosingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (!this.closingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.closingList.remove(fiso);
    }

    public void removeEndingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (!this.endingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.endingList.remove(fiso);
    }

    public void removeReadingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (!this.readingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.readingList.remove(fiso);
    }

    public void removeReadingGroupStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (!this.readingGroupList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.readingGroupList.remove(fiso);
    }

    public void removeLeavingStreamListener(FileInputStreamObserver fiso) {
        if (fiso == null) {
            throw new IllegalStateException();
        }

        if (!this.leavingList.contains(fiso)) {
            throw new IllegalArgumentException();
        }

        this.leavingList.remove(fiso);
    }

    @Override
    public void close() throws IOException {
        super.close();

        for (FileInputStreamObserver ob : this.closingList) {
            ob.notifyClosingStream();
        }
    }


    // reading
    @Override
    public int read() throws IOException {
        int bajt = super.read();

        for (FileInputStreamObserver ob : this.readingList) {
            ob.notifyReadingStream();
        }

        return bajt;
    }

    // reading group
    @Override
    public int read(byte b[]) throws IOException {
        int bajt = super.read();

        for (FileInputStreamObserver ob : this.readingGroupList) {
            ob.notifyReadingGroupStream();
        }

        return bajt;
    }

    // ending
    @Override
    public int read(byte b[], int off, int len) throws IOException {
        int bajt = super.read();

        for (FileInputStreamObserver ob : this.endingList) {
            ob.notifyEndingStream();
        }

        return bajt;
    }

    @Override
    public long skip(long n) throws IOException {
        long r = super.skip(n);

        for (FileInputStreamObserver ob : this.leavingList) {
            ob.notifyLeavingStream();
        }

        return r;
    }
}
