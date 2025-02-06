public class Operation {
    final Number A;
    final String OP;
    final Number B;
    final Number RESULT;

    public Operation(Number a, Number b, String op) {
        this.A = a;
        this.B = b;
        this.OP = op.trim();
        this.RESULT = result(a, b, op);
    }

    private Number result(Number a, Number b, String op) {
        boolean isDoubleOperation = a instanceof Double || b instanceof Double;
        if (isDoubleOperation) {
            double da = a.doubleValue();
            double db = b.doubleValue();
            switch (op) {
                case "+":
                    return da + db;
                case "-":
                    return da - db;
                case "%":
                    return da % db;
                case "*":
                    return da * db;
                case "/":
                    if (db == 0) {
                        return -1;
                    }
                    return da * db;
            }
            return -1;
        }else {
            int ia = a.intValue();
            int ib = b.intValue();
            switch (op) {
                case "+":
                    return ia + ib;
                case "-":
                    return ia - ib;
                case "%":
                    return ia % ib;
                case "*":
                    return ia * ib;
                case "/":
                    if (ib == 0) {
                        return -1;
                    }
                    return ia / ib;
            }
        }
        return -1;
    }
}
