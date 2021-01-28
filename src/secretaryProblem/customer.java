package secretaryProblem;

class customer implements Comparable {
    static int n = 0;
    int num;
    double t1; //Treatment time

    public customer(double treatmentTime) {
        this.num = n;
        n++;
        this.t1 = treatmentTime;
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.t1, ((customer) o).t1);
    }

    public String toString() {
        return "number of customer: " + this.num + ", treatment time: " + this.t1;
    }
}