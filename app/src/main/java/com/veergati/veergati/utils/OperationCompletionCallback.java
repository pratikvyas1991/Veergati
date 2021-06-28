package com.veergati.veergati.utils;

public interface OperationCompletionCallback {
    public void onError(Error error);
    public void onSucess(Boolean isCompleted);
}
