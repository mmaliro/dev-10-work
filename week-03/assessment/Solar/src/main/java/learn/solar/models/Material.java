package learn.solar.models;

public enum Material {
    multi_Si,
    mono_Si,
    A_Si,
    CdTe,
    CIGS;

    public boolean isEmpty() {
        return false;
    }
}
