package ru.liamin.vladimir;

import ru.liamin.vladimir.Helpers.ParamsUtil;

import static java.lang.Math.*;

public class CountFunction {

    public double getValueF(double x) {
        return 1 + x;
    }

    public double getValueP(double x) {
        return 1 / (2 + x);
    }

    public double getFstDerP(double x) {
        return -1 / pow(2 + x, 2);
    }

    public double getValueQl(double z) {
        return 0d;
    }

    public double getValueQr(double y1, double z1) {
        return ParamsUtil.beta1 / ParamsUtil.beta2 * getValueP(1.0) * y1 * z1;
    }

    public double getValueR(double x) {
        return cos(x);
    }

    public double getFstDerR(double x) {
        return -sin(x);
    }
}
