package com.pedropmbf.todolistjava.entities.enums;

public enum TaskStatus {

    TO_BE_DONE(1),
    DONE(2),
    ARQUIVED(3);

    private int code;
    private TaskStatus (int code) {
        this.code = code;
    }

    public int getCode () {
        return code;
    }

    public static TaskStatus valueOf (int code){
        for (TaskStatus value : TaskStatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo TaskStatus e invalido: " + code);
    }
}
