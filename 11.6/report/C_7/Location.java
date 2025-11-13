package report;

class Location{
    private String city;
    private double latitude;
    private double hardness;

    public Location(String city, double latitude, double hardness){
        this.city = city; this.latitude=latitude; this.hardness = hardness;
    }


    public void setC(String city) {
        this.city = city;
    }

    public void setH(double hardness) {
        this.hardness = hardness;
    }

    public void setL(double latitude) {
        this.latitude = latitude;
    }

    public String toString() {
        return this.latitude + " " + this.hardness;
    }

    public String getC() {
        return city;
    }

    public double getH() {
        return hardness;
    }

    public double getL() {
        return latitude;
    }
}
