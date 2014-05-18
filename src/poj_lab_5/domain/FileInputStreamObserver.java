package poj_lab_5.domain;

interface FileInputStreamObserver {
    public void notifyClosingStream();

    public void notifyEndingStream();

    public void notifyReadingStream();

    public void notifyReadingGroupStream();

    public void notifyLeavingStream();
}
