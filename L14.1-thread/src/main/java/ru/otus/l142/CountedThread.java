package ru.otus.l142;

public final class CountedThread extends BaseThread {
    private static StateObject stateObject = new StateObject();

    protected void doSomething() {
        super.doSomething();
        stateObject.increment();
    }

    int getI() {
        return stateObject.getI();
    }
}
